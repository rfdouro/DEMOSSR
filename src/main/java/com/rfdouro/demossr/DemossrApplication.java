package com.rfdouro.demossr;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class DemossrApplication implements CommandLineRunner {

	@Value("${spring.datasource.url}")
	private String ds;

	public static void main(String[] args) {
		SpringApplication.run(DemossrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("DATASOURCE = " + ds);
	}

}
