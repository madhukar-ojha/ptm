package com.web.ptm.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PtmLoginApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PtmLoginApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PtmLoginApplication.class);
	}

}
