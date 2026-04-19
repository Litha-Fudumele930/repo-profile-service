package za.vodacom.repoprofile.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.server.ResponseStatusException;
import za.vodacom.repoprofile.dto.GetProfileRequest;
import za.vodacom.repoprofile.dto.ListProfiles200Response;
import za.vodacom.repoprofile.dto.UserProfileResponse;
import za.vodacom.repoprofile.service.ProfilesService;
import za.vodacom.repoprofile.api.ProfilesApiDelegate;
import za.vodacom.repoprofile.service.UserService;

@Service
public class UserProfileResource implements ProfilesApiDelegate {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @Autowired
    ProfilesService profilesService;


    /**
     * GET /profiles : List profiles with pagination
     * Returns an object containing a list of profiles with basic information.
     */
    public ResponseEntity<ListProfiles200Response> listProfiles(Integer page,
                                                                Integer since) {
        long startTime = System.currentTimeMillis();

        ListProfiles200Response listProfiles200Response;

        if(page > 100) {
            log.debug("Page number exceeds maximum allowed value of 100");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Page number exceeds maximum allowed value of 100");
        }

        if (page<=0) page = 5; // Default to 5 if negative or zero sent in query

        listProfiles200Response = userService.getUsers(page,since);

        log.info(
                "Retrieve profiles completed. Duration: {}ms",
                System.currentTimeMillis() - startTime
        );

        // Return result
        return ResponseEntity.status(HttpStatus.OK)
                .header("X-Trace-Id")
                .body(listProfiles200Response);

    }

    /**
     * POST /profiles : Retrieve user profile and repositories
     */
    public ResponseEntity<UserProfileResponse> getProfile(GetProfileRequest getProfileRequest) {

        long startTime = System.currentTimeMillis();

        UserProfileResponse profileResponse;

        log.info("Get github profile {}.", getProfileRequest.getUsername());

        String username = getProfileRequest.getUsername();

        // validate input
        if ( username == null || username.trim().isEmpty()) {
            log.debug("Username not provided, please enter a username to continue");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username not provided, please enter a username to continue");
        }

        profileResponse = profilesService.getUserDetails(username);

        log.info(
                "Retrieve profile {}  completed. Duration: {}ms",
                username,
                System.currentTimeMillis() - startTime
        );
        // Return result
        return ResponseEntity.status(HttpStatus.OK)
                .header("X-Trace-Id")
                .body(profileResponse);
    }
}
