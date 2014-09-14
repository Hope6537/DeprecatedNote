package org.hope6537.springtest.createObject;

import org.hope6537.utils.SpringHelper;
import org.junit.Test;

public class Client extends SpringHelper {

	/**
	 * <p>Describe: Spring使用默认的构造函数来创建对象</p>
	 * <p>Using: 也就是说Spring的对象里面必须要有默认的构造函数（如果不在xml另外配置）</p>
	 * <p>How To Work: </p>
	 * <p>DevelopedTime: 2014年9月10日下午6:58:56 </p>
	 * <p>Author:Hope6537</p>
	 * @see
	 */
	@Test 
	public void test() {
		HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
		helloWorld.hello();
	}

	public Client() {
		super("org/hope6537/createObject/applicationContext.xml");
	}
}
