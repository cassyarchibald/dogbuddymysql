package com.dogbuddyapi.dogbuddy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.web.bind.annotation.CrossOrigin;

@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
@EntityScan(basePackageClasses = {DogbuddyApplication.class, Jsr310Converters.class})
@CrossOrigin(origins = "http://localhost:3000")
public class DogbuddyApplication {

    public static void main(String[] args) {
        SpringApplication.run(DogbuddyApplication.class, args);
    }

}

