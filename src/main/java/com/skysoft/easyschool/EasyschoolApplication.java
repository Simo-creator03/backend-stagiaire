package com.skysoft.easyschool;

import com.skysoft.easyschool.config.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableConfigurationProperties(ApplicationProperties.class)
public class EasyschoolApplication {


	public static void main(String[] args) {
		SpringApplication.run(EasyschoolApplication.class, args);
	}

}
