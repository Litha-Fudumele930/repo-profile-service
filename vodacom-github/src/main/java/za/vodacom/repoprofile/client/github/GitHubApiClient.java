package za.vodacom.repoprofile.client.github;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
    name = "${application.github.feignClientName}",
    url = "${application.github.url}",
    configuration = ClientConfiguration.class
)
public interface GitHubApiClient extends UsersApi {}
