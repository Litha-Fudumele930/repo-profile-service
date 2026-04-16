package za.vodacom.repoprofile.service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.vodacom.repoprofile.client.github.GitHubApiClient;
import za.vodacom.repoprofile.dto.github.RepositoryDTO;
import za.vodacom.repoprofile.dto.github.UserProfileDTO;
import za.vodacom.repoprofile.service.GithubService;

import java.util.List;

@Service
public class GithubServiceImpl implements GithubService {

    @Autowired
    GitHubApiClient gitHubApiClient;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public UserProfileDTO getGithubUser(String username) throws Exception {
        log.debug("Get user {} from github:", username);

        UserProfileDTO userDetails;

        try {

            userDetails = gitHubApiClient.getUserProfile(username).getBody();

        } catch (Exception e) {
            log.error("Feign error caught - {}", e.getMessage());
            throw new Exception("Failed to query Github - " + e.getMessage());
        }

        return userDetails;
    }

    @Override
    public List<RepositoryDTO> getAllPublicRepos(String username) throws Exception {
        log.debug("Get public repos list by  user {} from github:", username);

        List<RepositoryDTO> repositoryDTOList;

        try {
            repositoryDTOList = gitHubApiClient.getUserRepositories(username).getBody();

        } catch (Exception e) {
            log.error("Feign error caught - {}", e.getMessage());
            throw new Exception("Failed to query Github - " + e.getMessage());
        }

        return repositoryDTOList;
    }
}
