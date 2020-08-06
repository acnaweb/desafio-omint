package br.com.omni.test.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.omni.test")
public class StartApi {

	public static void main(String[] args) {
		SpringApplication.run(StartApi.class, args);
	}

}
