package za.vodacom.repoprofile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "za.vodacom.repoprofile.client.github")
public class RepoProfileApplication {

  public static void main(String[] args) {
    SpringApplication.run(RepoProfileApplication.class, args);
  }

}
