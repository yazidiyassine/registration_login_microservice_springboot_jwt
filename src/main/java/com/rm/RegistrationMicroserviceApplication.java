package com.rm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class RegistrationMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegistrationMicroserviceApplication.class, args);
    }

}
