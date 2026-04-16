package za.vodacom.repoprofile.api;

import za.vodacom.repoprofile.dto.ErrorResponse;
import za.vodacom.repoprofile.dto.UserProfileResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

/**
 * A delegate to be called by the {@link ProfilesApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-04-16T17:49:49.951314600+02:00[Africa/Johannesburg]")
public interface ProfilesApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /profiles/{username} : Retrieve user profile and repositories
     * Retrieve a user’s profile details along with their repositories sorted by stargazers count, including language breakdowns.
     *
     * @param username  (required)
     * @return Successful response (status code 200)
     *         or Bad Request – invalid or missing username (status code 400)
     *         or Internal Server Error – unexpected failure when querying GitHub (status code 500)
     * @see ProfilesApi#getProfile
     */
    default ResponseEntity<UserProfileResponse> getProfile(String username) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"followers\" : 6, \"avatar_url\" : \"avatar_url\", \"repositories\" : [ { \"full_name\" : \"full_name\", \"stargazers_count\" : 5, \"html_url\" : \"html_url\", \"name\" : \"name\", \"language\" : \"language\", \"id\" : 1, \"frequent_language\" : \"frequent_language\" }, { \"full_name\" : \"full_name\", \"stargazers_count\" : 5, \"html_url\" : \"html_url\", \"name\" : \"name\", \"language\" : \"language\", \"id\" : 1, \"frequent_language\" : \"frequent_language\" } ], \"bio\" : \"bio\", \"publicRepos\" : 0, \"username\" : \"username\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
