package com.example.ProjectShop;

import com.example.ProjectShop.repository.ShopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class ProjectShopApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProjectShopApplication.class, args);
    }
}