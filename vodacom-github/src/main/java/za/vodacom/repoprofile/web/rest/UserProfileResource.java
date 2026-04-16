package za.vodacom.repoprofile.web.rest;

import brave.Tracer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.server.ResponseStatusException;
import za.vodacom.repoprofile.dto.UserProfileResponse;
import za.vodacom.repoprofile.service.ProfilesService;
import za.vodacom.repoprofile.api.ProfilesApiDelegate;

@Service
public class UserProfileResource implements ProfilesApiDelegate {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ProfilesService profilesService;

    /**
     * POST /profiles/{username} : Retrieve user profile and repositories
     */
    public ResponseEntity<UserProfileResponse> getProfile(String username) {

        long startTime = System.currentTimeMillis();

        UserProfileResponse profileResponse;

        log.info("Get github user {}.", username);

        // validate input
        if ( username == null || username.trim().isEmpty()) {
            log.debug("Username not provided, please enter a username to continue");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username not provided, please enter a username to continue");
        }

        profileResponse = profilesService.getUserDetails(username);

        log.info(
                "Get user {}  completed. Duration: {}ms",
                username,
                System.currentTimeMillis() - startTime
        );
        // Return result
        return ResponseEntity.status(HttpStatus.OK)
                .header("X-Trace-Id")
                .body(profileResponse);
    }
}
