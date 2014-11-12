package org.hope6537.springtest.di.xml.set;

import org.hope6537.utils.SpringHelper;
import org.junit.Test;

/** 
 * <p>Describe: 依赖注入测试示例</p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年9月12日下午5:55:41</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class Client extends SpringHelper {

	public Client() {
		super("org/hope6537/springtest/di/xml/set/applicationContext.xml");
	}

	@Test
	public void test() {
		Person person = (Person) context.getBean("person");
		person.getStudent().test();
		System.out.println(person.getPid());
		System.out.println(person.getPname());
		System.out.println(person.getList().toString());
		System.out.println(person.getSet().toString());
		System.out.println(person.getMap().toString());
		System.out.println(person.getProperties().toString());

	}
}
