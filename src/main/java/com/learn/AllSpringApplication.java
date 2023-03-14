package com.learn;

import com.learn.service.RedisService;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@SpringBootApplication
public class AllSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllSpringApplication.class, args);
	}
}
