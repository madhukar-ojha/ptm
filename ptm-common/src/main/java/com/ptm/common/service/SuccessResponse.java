package com.ptm.common.service;

public class SuccessResponse {
	private Object successResponse;
	public <T> SuccessResponse(T successResponse) {
		this.successResponse = successResponse;
	}
	
	
	@SuppressWarnings("unchecked")
	public <T> T getSuccessResponse() {
		return (T)successResponse;
	}

}
