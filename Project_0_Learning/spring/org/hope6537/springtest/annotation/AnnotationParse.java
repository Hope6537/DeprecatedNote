package org.hope6537.springtest.annotation;

import java.lang.reflect.Method;

/** 
 * <p>Describe: 注解解析器</p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年9月13日下午12:57:59</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class AnnotationParse {
	public static void parse() {
		Class<Test> classes = Test.class;
		classes.isAnnotation();// 是否存在注解
		// 获取类上的注解
		if (classes.isAnnotationPresent(TestAnn.class)) {
			TestAnn ann = (TestAnn) classes.getAnnotation(TestAnn.class);
			System.out.println(ann.value());
		}

		Method[] methods = classes.getMethods();
		for (Method m : methods) {
			if (m.isAnnotationPresent(TestAnn.class)) {
				TestAnn ann = (TestAnn) m.getAnnotation(TestAnn.class);
				System.out.println(ann.value());
			}
		}
	}
	
	public static void main(String[] args) {
		parse();
	}
}
