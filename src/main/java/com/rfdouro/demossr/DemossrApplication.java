package com.rfdouro.demossr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class DemossrApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemossrApplication.class, args);
	}

}
