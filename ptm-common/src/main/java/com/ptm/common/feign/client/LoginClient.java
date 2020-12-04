package com.ptm.common.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ptm.common.response.ServiceResponse;
import com.ptm.common.vo.LoginVO;
import com.ptm.common.vo.UserDetailVO;

@Component
@FeignClient(name = "ptm-login", path = "/ptm-login")
public interface LoginClient { 
	
	@PostMapping(value = "/login")
	public ResponseEntity<ServiceResponse<UserDetailVO, Exception>> login(@RequestBody LoginVO loginVO);
	
}
