package za.vodacom.repoprofile.service;

import za.vodacom.repoprofile.dto.ListProfiles200Response;

public interface UserService {


    ListProfiles200Response getUsers(Integer page,
                            Integer since);
}
