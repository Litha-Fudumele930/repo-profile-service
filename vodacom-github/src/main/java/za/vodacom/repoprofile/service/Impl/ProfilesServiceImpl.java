package za.vodacom.repoprofile.service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import za.vodacom.repoprofile.domain.UserProfile;
import za.vodacom.repoprofile.domain.UserRepositories;
import za.vodacom.repoprofile.dto.Repository;
import za.vodacom.repoprofile.dto.UserProfileResponse;
import za.vodacom.repoprofile.dto.github.RepositoryDTO;
import za.vodacom.repoprofile.dto.github.UserProfileDTO;
import za.vodacom.repoprofile.repository.UserProfileRepository;
import za.vodacom.repoprofile.repository.UserRepositoriesRepository;
import za.vodacom.repoprofile.service.GithubService;
import za.vodacom.repoprofile.service.ProfilesService;
import za.vodacom.repoprofile.service.mapper.RepositoryMapper;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfilesServiceImpl implements ProfilesService {

    @Autowired
    GithubService githubService;
    @Autowired
    UserProfileRepository userProfileRepository;
    @Autowired
    UserRepositoriesRepository userRepositoriesRepository;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public UserProfileResponse getUserDetails(String username) {

        UserProfileResponse profileResponse = new UserProfileResponse();
        List<RepositoryDTO> repositoryDTOList;

            // DB lookup for user
            Optional<UserProfile> userProfile = userProfileRepository.findById(username);

            if (userProfile.isPresent()) {
                // if found look up repo table for cached data
                UserProfile profile = userProfile.get();
                List<UserRepositories> repositories = userRepositoriesRepository.findByUsername(username);

                // calculate top language used by the user across all repos
                String topLang = calculateFrequentFromDomain(repositories);
                List<Repository> sortedRepos = RepositoryMapper.mapReposFromDb(repositories, topLang);

                // set responses
                profileResponse = setResponses(
                        profile.getUsername(),
                        profile.getBio(),
                        profile.getAvatarUrl(),
                        profile.getPublicRepos(),
                        profile.getFollowers(),
                        sortedRepos
                );

            } else {
                // no user found in DB call external APIs
                UserProfileDTO userDetails = null;
                try {
                    userDetails = githubService.getGithubUser(username);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                if (userDetails != null) {
                   // if found save results to DB
                    saveProfileToDB(
                            username,
                            userDetails.getName(),
                            userDetails.getBio(),
                            userDetails.getAvatarUrl(),
                            userDetails.getPublicRepos(),
                            userDetails.getFollowers()
                    );

                    try {
                        repositoryDTOList = githubService.getAllPublicRepos(username);
                        SaveRepositoriesToDB(username, repositoryDTOList);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                    // calculate top language used by the user across all repos
                    String topLanguage = calculateFrequentLanguage(repositoryDTOList);
                    List<Repository> sortedRepos = RepositoryMapper.mapAndSortRepos(repositoryDTOList, topLanguage);
                    // set responses
                    profileResponse =  setResponses(username, userDetails.getBio(), userDetails.getAvatarUrl(), userDetails.getPublicRepos(), userDetails.getFollowers(), sortedRepos);

                    log.debug("Profile response is: {}", profileResponse);
                } else {
                    // throw exception if user not found
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found in GitHub");
                }
            }

        return profileResponse;
    }

    private String calculateFrequentLanguage(List<RepositoryDTO> list) {
        if (list == null || list.isEmpty()) return "Unknown";

        //  Get the counts
        Map<String, Long> counts = list.stream()
                .map(RepositoryDTO::getLanguage)
                .filter(l -> l != null && !l.isBlank())
                .collect(Collectors.groupingBy(l -> l, Collectors.counting()));

        if (counts.isEmpty()) return "Unknown";

        //  Find the max count
        long max = Collections.max(counts.values());

        //  Count how many have that max. If > 1, return "Unknown"
        long winners = counts.values().stream().filter(c -> c == max).count();

        return winners > 1 ? "Unknown" :
                counts.entrySet().stream()
                        .filter(e -> e.getValue() == max)
                        .map(Map.Entry::getKey)
                        .findFirst().orElse("Unknown");
    }

    private String calculateFrequentFromDomain(List<UserRepositories> list) {
        if (list == null || list.isEmpty()) return "Unknown";
        return list.stream()
                .map(UserRepositories::getLanguage)
                .filter(l -> l != null && !l.isBlank())
                .collect(Collectors.groupingBy(l -> l, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse("Unknown");
    }


    public UserProfileResponse setResponses(String username, String bio, String avatarUrl, Integer numRepos, Integer numFollowers, List<Repository> repositoryList) {
        UserProfileResponse profileResponse = new UserProfileResponse();
        profileResponse.setUsername(username);
        profileResponse.setBio(bio);
        profileResponse.setAvatarUrl(avatarUrl);
        profileResponse.setPublicRepos(numRepos);
        profileResponse.setFollowers(numFollowers);
        profileResponse.setRepositories(repositoryList);
        return profileResponse;
    }

    public void saveProfileToDB(String username, String repoName, String bio, String avatarUrl, Integer numRepos, Integer numFollowers) {
        UserProfile userProfile = new UserProfile();
        userProfile.setUsername(username);
        userProfile.setName(repoName);
        userProfile.setBio(bio);
        userProfile.setAvatarUrl(avatarUrl);
        userProfile.setPublicRepos(numRepos);
        userProfile.setFollowers(numFollowers);
        userProfile.setCreateDate(ZonedDateTime.now());
        userProfileRepository.save(userProfile);
        log.debug("profile successfully saved.");
    }

    public void SaveRepositoriesToDB(String username, List<RepositoryDTO> repositoryDTOList) {
        List<UserRepositories> reposToSave = repositoryDTOList.stream()
                .limit(50)
                .map(dto -> {
                    UserRepositories repo = new UserRepositories();
                    repo.setUsername(username);
                    repo.setRepoName(dto.getName());
                    repo.setFullName(dto.getFullName());
                    repo.setLanguage(dto.getLanguage());
                    repo.setStargazersCount(dto.getStargazersCount());
                    repo.setHtmlUrl(dto.getHtmlUrl());
                    repo.setCreatedAt(ZonedDateTime.now());
                    return repo;
                })
                .collect(Collectors.toList());

        userRepositoriesRepository.deleteByUsername(username);
        userRepositoriesRepository.saveAll(reposToSave);
    }
}