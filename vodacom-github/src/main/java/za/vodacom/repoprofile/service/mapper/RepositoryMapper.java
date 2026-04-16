package za.vodacom.repoprofile.service.mapper;

import za.vodacom.repoprofile.domain.UserRepositories;
import za.vodacom.repoprofile.dto.Repository;
import za.vodacom.repoprofile.dto.github.RepositoryDTO;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RepositoryMapper {

    // Map and sort repos coming from GitHub DTOs
    public static List<Repository> mapAndSortRepos(List<RepositoryDTO> repositoryDTOList,String frequentLanguage) {
        return repositoryDTOList.stream()
                .filter(dto -> dto.getStargazersCount() != null && dto.getStargazersCount() > 0)
                .sorted(Comparator.comparingInt(RepositoryDTO::getStargazersCount).reversed())
                .map(dto -> {
                    Repository repo = new Repository();
                    repo.setId(dto.getId());
                    repo.setName(dto.getName());
                    repo.setFullName(dto.getFullName());
                    repo.setLanguage(dto.getLanguage());
                    repo.setHtmlUrl(dto.getHtmlUrl());
                    repo.setStargazersCount(dto.getStargazersCount());
                    repo.setFrequentLanguage(frequentLanguage);
                    return repo;
                })
                .collect(Collectors.toList());
    }

    // Map repos retrieved from DB entities
    public static List<Repository> mapReposFromDb(List<UserRepositories> repositories,String frequentLanguage) {
        return repositories.stream()
                .map(repoEntity -> {
                    Repository repo = new Repository();
                    repo.setName(repoEntity.getRepoName());
                    repo.setFullName(repoEntity.getFullName());
                    repo.setLanguage(repoEntity.getLanguage());
                    repo.setHtmlUrl(repoEntity.getHtmlUrl());
                    repo.setStargazersCount(repoEntity.getStargazersCount());
                    repo.setFrequentLanguage(frequentLanguage);
                    return repo;
                })
                .sorted(Comparator.comparingInt(Repository::getStargazersCount).reversed()) // add sorting if needed
                .collect(Collectors.toList());
    }
}
