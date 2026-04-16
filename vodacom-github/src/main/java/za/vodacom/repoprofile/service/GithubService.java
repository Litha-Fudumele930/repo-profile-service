package za.vodacom.repoprofile.service;

import za.vodacom.repoprofile.dto.github.RepositoryDTO;
import za.vodacom.repoprofile.dto.github.UserProfileDTO;

import java.util.List;

public interface GithubService {


    UserProfileDTO getGithubUser(String username) throws Exception;

    List<RepositoryDTO> getAllPublicRepos(String username) throws Exception;
}
