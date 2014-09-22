package org.hope6537.springtest.aoptest.exception.service;

import java.lang.reflect.Method;

public abstract class ServiceImpl implements Service {

	@Override
	public Object save(ServiceMapping mapping) throws Exception {
		String methodName = mapping.getMethod();
		Object object = Class.forName(mapping.getServiceClass()).newInstance();
		Method method = Class.forName(mapping.getServiceClass()).getMethod(
				methodName);
		return method.invoke(object);
	}
}
