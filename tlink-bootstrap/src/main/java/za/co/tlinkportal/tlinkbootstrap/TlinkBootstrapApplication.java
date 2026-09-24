package za.co.tlinkportal.tlinkbootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "za.co.tlinkportal")
@EnableFeignClients(basePackages = "za.co.tlinkportal")
@EnableJpaRepositories(basePackages = "za.co.tlinkportal")
@EntityScan(basePackages = "za.co.tlinkportal")
public class TlinkBootstrapApplication {

    public static void main(String[] args) {
        SpringApplication.run(TlinkBootstrapApplication.class, args);
    }
}
