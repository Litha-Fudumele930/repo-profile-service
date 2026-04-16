package za.vodacom.repoprofile.config.pojo;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Github {

    private String url;
    private String feignClientName;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFeignClientName() {
        return feignClientName;
    }

    public void setFeignClientName(String feignClientName) {
        this.feignClientName = feignClientName;
    }
}
