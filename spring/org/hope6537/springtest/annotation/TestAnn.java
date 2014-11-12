package org.hope6537.springtest.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 描述作用范围 java+class+jvm == runtime
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
// 描述使用范围
public @interface TestAnn {
	/**
	 *<pre>
	 *属性value
	 *</pre>
	 */
	/* String value(); */

	String value() default "";
}
