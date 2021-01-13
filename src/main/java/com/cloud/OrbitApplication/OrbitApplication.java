package com.cloud.OrbitApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.cloud.OrbitApplication.exception.handler.RestTemplateResponseErrorHandler;

import org.springframework.boot.web.client.RestTemplateBuilder;
import javax.annotation.PostConstruct;
import java.util.TimeZone;


@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = "com.cloud.OrbitApplication")
@ComponentScan(basePackages = "com.cloud.OrbitApplication")
@EnableJpaRepositories(basePackages = "com.cloud.OrbitApplication")
public class OrbitApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrbitApplication.class, args);
	}
	
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder()
                .errorHandler(new RestTemplateResponseErrorHandler())
                .build();
    }

    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getDefault());
    }

}
