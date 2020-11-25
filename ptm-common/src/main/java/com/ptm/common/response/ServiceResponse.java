package com.ptm.common.response;

import org.springframework.http.HttpStatus;

public class ServiceResponse<S,E> {
	private S successResponse;
	private E errorResponse;
	private HttpStatus httpStatus;
	public ServiceResponse(S successResponse, E errorResponse, HttpStatus httpStatus) {
		this.successResponse = successResponse;
		this.errorResponse = errorResponse;
		this.httpStatus = httpStatus;
	}
	
	public S getSuccessResponse() {
		return successResponse;
	}

	public E getErrorResponse() {
		return errorResponse;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

}
