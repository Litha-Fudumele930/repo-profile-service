package za.vodacom.repoprofile.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import za.vodacom.repoprofile.config.pojo.Github;

@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

    private Github github;

    public Github getGithub() {
        return github;
    }

    public void setGithub(Github github) {
        this.github = github;
    }
}
