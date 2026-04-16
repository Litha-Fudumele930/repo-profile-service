package za.vodacom.repoprofile.service;


import za.vodacom.repoprofile.dto.UserProfileResponse;


public interface ProfilesService {

    UserProfileResponse getUserDetails(String username);

}
