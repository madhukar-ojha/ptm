package com.ptm.common.service;

import java.util.Collections;
import java.util.Map;

public class ServiceException {
	private String errorCode;
	private String shortMesage;
	private String longMesage;
	private Map<String, Object> errorParams;
	
	public ServiceException(String errorCode, String shortMesage, String longMesage, Map<String, Object> errorParams) {
		this.errorCode = errorCode;
		this.shortMesage = shortMesage;
		this.longMesage = longMesage;
		this.errorParams = errorParams;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getShortMesage() {
		return shortMesage;
	}

	public String getLongMesage() {
		return longMesage;
	}

	public Map<String, Object> getErrorParams() {
		return Collections.unmodifiableMap(errorParams);
	}
	
}
