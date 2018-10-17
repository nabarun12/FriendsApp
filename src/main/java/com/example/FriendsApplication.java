package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import com.example.controller.RequestController;
import com.example.dataservice.DataService;

@ComponentScan()
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class FriendsApplication extends SpringBootServletInitializer{


   

	
	public static void main(String[] args) {
		SpringApplication.run(FriendsApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FriendsApplication.class);
	}
	
	
}