package com.ptm.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PtmCommonApplication {

	public static void main(String[] args) {
		SpringApplication.run(PtmCommonApplication.class, args);
	}

}
