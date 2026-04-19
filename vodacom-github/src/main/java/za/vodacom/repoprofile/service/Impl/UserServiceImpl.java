package za.vodacom.repoprofile.service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.vodacom.repoprofile.dto.ListProfiles200Response;
import za.vodacom.repoprofile.dto.github.ProfileSummaryDTO;
import za.vodacom.repoprofile.service.GithubService;
import za.vodacom.repoprofile.service.UserService;
import za.vodacom.repoprofile.service.mapper.RepositoryMapper;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    GithubService githubService;


    @Override
    @Cacheable(value = "githubUsers", key = "{#page, #since}")
    public ListProfiles200Response getUsers(Integer page, Integer since) {

        ListProfiles200Response response =  new ListProfiles200Response();
        List<ProfileSummaryDTO> profileSummaryDTOList;

        try {
         profileSummaryDTOList =   githubService.listUsers(since,page);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        response.setUsers(RepositoryMapper.mapProfileSummaries(profileSummaryDTOList));

        return response;
    }
}
