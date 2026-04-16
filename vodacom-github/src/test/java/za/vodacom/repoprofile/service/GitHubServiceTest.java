package za.vodacom.repoprofile.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import za.vodacom.repoprofile.client.github.GitHubApiClient;
import za.vodacom.repoprofile.dto.github.RepositoryDTO;
import za.vodacom.repoprofile.dto.github.UserProfileDTO;
import za.vodacom.repoprofile.service.Impl.GithubServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class GitHubServiceTest {

    @Autowired
    private GithubServiceImpl githubService;

    @MockitoBean
    private GitHubApiClient gitHubApiClient;

    @Test
    void whenGetGithubUser_thenReturnUserProfileDTO() throws Exception {
        // Arrange
        UserProfileDTO dto = new UserProfileDTO();
        dto.setName("Octo Cat");
        dto.setBio("Test bio");

        // Ensure we mock the exact call the service makes
        when(gitHubApiClient.getUserProfile("octocat"))
                .thenReturn(ResponseEntity.ok(dto));

        // Act
        UserProfileDTO result = githubService.getGithubUser("octocat");

        // Assert
        assertNotNull(result, "Service returned null, check if the mock was called correctly");
        assertEquals("Octo Cat", result.getName());
        assertEquals("Test bio", result.getBio());
    }

    @Test
    void whenGetAllPublicRepos_thenReturnRepositoryList() throws Exception {
        // Arrange
        RepositoryDTO repo = new RepositoryDTO();
        repo.setName("test-repo");
        repo.setStargazersCount(10);

        when(gitHubApiClient.getUserRepositories("octocat"))
                .thenReturn(ResponseEntity.ok(List.of(repo)));

        // Act
        List<RepositoryDTO> repos = githubService.getAllPublicRepos("octocat");

        // Assert
        assertNotNull(repos);
        assertEquals(1, repos.size());
        assertEquals("test-repo", repos.get(0).getName());
    }
}
