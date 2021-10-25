package com.convertorxlstoHtml.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//@Configuration
@EnableAutoConfiguration
@SpringBootApplication //(scanBasePackages={"com.convertorxlstoHtml.demo"})
//@ComponentScan(basePackages = {"com.convertorxlstoHtml.demo.repository"})

public class TrueCallerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TrueCallerApplication.class, args);
        System.out.println("TrueCaller application Started");
    }

}
