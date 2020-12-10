package com.ptm.common.service;

import org.springframework.stereotype.Component;

public class ErrorResponse {
	private ServiceException serviceException;
	
	public ErrorResponse(ServiceException serviceException) {
		this.serviceException = serviceException;
	}
	public ServiceException getErrorResponse() {
		return serviceException;
	}
	
}
