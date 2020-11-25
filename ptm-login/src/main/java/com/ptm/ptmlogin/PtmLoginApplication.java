package com.ptm.ptmlogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "com.ptm.ptmlogin")
public class PtmLoginApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		System.out.println("----profile name: " + System.getProperty("spring.profiles.active"));
		SpringApplication.run(PtmLoginApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PtmLoginApplication.class);
	}

}
