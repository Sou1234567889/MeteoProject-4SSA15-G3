package tn.esprit.localisation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LocalisationApplication {

    public static void main(String[] args) {
        SpringApplication.run(LocalisationApplication.class, args);
    }

}
