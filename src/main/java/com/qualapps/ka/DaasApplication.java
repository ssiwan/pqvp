package com.qualapps.ka;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@Configuration
@EnableSwagger2
@ComponentScan(basePackages = {"com.qualapps.ka.data",
        "com.qualapps.ka.common",
        "com.qualapps.ka.controller",
       "com.qualapps.ka",
        "com.qualapps.ka.service"})
@SpringBootApplication
@EnableAutoConfiguration

public class DaasApplication {
    public static void main(String[] args) {
        SpringApplication.run(DaasApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

            System.out.println("Daas Application Ready");
        };
    }
}