package org.hope6537.springtest.createObject;

/** 
 * <p>Describe: 静态工厂模式</p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年9月10日下午7:00:57</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class HelloWorldFactory {

	public static HelloWorld getInstance() {
		return new HelloWorld();
	}

}
