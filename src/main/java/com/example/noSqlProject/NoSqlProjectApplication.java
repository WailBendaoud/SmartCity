package com.example.noSqlProject;

import com.example.noSqlProject.entities.mongo.Avenue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.example.noSqlProject.repositories.mongo")
@EnableJpaRepositories(basePackages = "com.example.noSqlProject.repositories.mysql")
public class NoSqlProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoSqlProjectApplication.class, args);
		Avenue a=new Avenue();
		System.out.println(a.getId());
	}

}
