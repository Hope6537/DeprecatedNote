package org.hope6537.springtest.aoptest.exception.service;

public class ServiceMapping {

	private String serviceClass; // 封装Service的全名

	private String method;

	public String getServiceClass() {
		return serviceClass;
	}

	public void setServiceClass(String serviceClass) {
		this.serviceClass = serviceClass;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

}
