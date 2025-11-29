package com.jmi.jobseekerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class JobSeekerApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobSeekerApiApplication.class, args);
    }

}
