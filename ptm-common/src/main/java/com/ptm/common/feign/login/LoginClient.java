package com.ptm.common.feign.login;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ptm.common.service.ServiceResponse;

@Component
@FeignClient(name = "ptm-login", path = "/ptm-login")
public interface LoginClient { 
	
	@PostMapping(value = "/login")
	public <T> ResponseEntity<ServiceResponse> login(@RequestBody T request);
	
	@GetMapping(value = "/go")
	public String go();
	
}
