package za.vodacom.repoprofile.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import za.vodacom.repoprofile.domain.UserProfile;
import za.vodacom.repoprofile.dto.UserProfileResponse;
import za.vodacom.repoprofile.dto.github.RepositoryDTO;
import za.vodacom.repoprofile.dto.github.UserProfileDTO;
import za.vodacom.repoprofile.repository.UserProfileRepository;
import za.vodacom.repoprofile.repository.UserRepositoriesRepository;
import za.vodacom.repoprofile.service.Impl.ProfilesServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@Transactional
class ProfilesServiceTest {

    @Autowired
    private ProfilesServiceImpl profilesService;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private UserRepositoriesRepository userRepositoriesRepository;

    @MockitoBean
    private GithubService githubService;

    @BeforeEach
    void setup() {
        userProfileRepository.deleteAll();
        userRepositoriesRepository.deleteAll();
    }

    @Test
    void whenUserExistsInDb_thenReturnProfileFromDb() {
        UserProfile profile = new UserProfile();
        profile.setUsername("octocat");
        profile.setBio("Bio from DB");
        profile.setAvatarUrl("avatar.png");
        profile.setPublicRepos(5);
        profile.setFollowers(100);
        userProfileRepository.save(profile);

        UserProfileResponse response = profilesService.getUserDetails("octocat");

        assertEquals("octocat", response.getUsername());
        assertEquals("Bio from DB", response.getBio());
    }

    @Test
    void whenUserNotInDb_thenFetchFromGitHubAndPersist() throws Exception {
        UserProfileDTO dto = new UserProfileDTO();
        dto.setName("Octo Cat");
        dto.setBio("Bio from GitHub");
        dto.setAvatarUrl("avatar.png");
        dto.setPublicRepos(10);
        dto.setFollowers(200);

        RepositoryDTO repoDto = new RepositoryDTO();
        repoDto.setName("test-repo");
        repoDto.setStargazersCount(5);

        when(githubService.getGithubUser("octocat")).thenReturn(dto);
        when(githubService.getAllPublicRepos("octocat")).thenReturn(List.of(repoDto));

        UserProfileResponse response = profilesService.getUserDetails("octocat");

        assertEquals("octocat", response.getUsername());
        assertEquals("Bio from GitHub", response.getBio());
        assertTrue(userProfileRepository.findById("octocat").isPresent());
    }

    @Test
    void whenUserNotInDbAndGitHubFails_thenThrowNotFound() throws Exception {
        when(githubService.getGithubUser("ghost")).thenReturn(null);

        assertThrows(ResponseStatusException.class, () -> profilesService.getUserDetails("ghost"));
    }
}
