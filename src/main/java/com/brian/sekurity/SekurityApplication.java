package com.brian.sekurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SekurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SekurityApplication.class, args);
    }

    @Bean
    public CommandLineRunner createPassword(PasswordEncoder passwordEncoder) {
        return args -> {
            System.out.println(passwordEncoder.encode("administrator"));
            System.out.println(passwordEncoder.encode("customer"));
        };
    }
}
