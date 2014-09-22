package org.hope6537.springtest.aoptest.exception.service;

/** 
 * <p>Describe: 反射控制类</p>
 * <p>Using: 这是Service的总调用接口，所以能在这里统一处理异常</p>
 * <p>DevelopedTime: 2014年9月17日上午10:56:55</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class ServiceInvocation {

	public static Object execution(ServiceMapping mapping) throws Exception {
		Service service = (Service) Class.forName(mapping.getServiceClass())
				.newInstance();
		// 不管怎样，都会必须调用到父接口的save方法
		service.save(mapping);
		return mapping;

	}
}
