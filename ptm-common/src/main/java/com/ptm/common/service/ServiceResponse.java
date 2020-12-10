package com.ptm.common.service;

import org.springframework.http.HttpStatus;

public class ServiceResponse {
	private SuccessResponse successResponse;
	private ErrorResponse errorResponse;
	private HttpStatus httpStatus;
	
	public ServiceResponse(SuccessResponse successResponse, HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	public ServiceResponse(ErrorResponse errorResponse, HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public SuccessResponse getSuccessResponse() {
		return successResponse;
	}

	public ErrorResponse getErrorResponse() {
		return errorResponse;
	}
	
}
