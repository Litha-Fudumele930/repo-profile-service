package za.vodacom.repoprofile.api;

import za.vodacom.repoprofile.dto.ErrorResponse;
import za.vodacom.repoprofile.dto.UserProfileResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-04-16T17:49:49.951314600+02:00[Africa/Johannesburg]")
@Controller
@RequestMapping("${openapi.repo-profile.base-path:}")
public class ProfilesApiController implements ProfilesApi {

    private final ProfilesApiDelegate delegate;

    public ProfilesApiController(@Autowired(required = false) ProfilesApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new ProfilesApiDelegate() {});
    }

    @Override
    public ProfilesApiDelegate getDelegate() {
        return delegate;
    }

}
