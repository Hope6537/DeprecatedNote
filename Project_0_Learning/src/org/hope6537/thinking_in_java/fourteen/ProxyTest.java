package org.hope6537.thinking_in_java.fourteen;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @describe һ���ӿڣ����ڵ�������������
 * @author Hope6537(����)
 * @signdate 2014-7-17����01:59:41
 * @version 0.9
 * @company Changchun University&SHXT
 */
interface Interface {
	void doSomething();

	void somethingElse(String arg);
}

/**
 * @describe ʵ���࣬����ʵ��ҵ�����
 * @author Hope6537(����)
 * @signdate 2014-7-17����02:00:08
 * @version 0.9
 * @company Changchun University&SHXT
 */
class RealObject implements Interface {
	@Override
	public void doSomething() {
		System.out.println("Real Doing");
	}

	@Override
	public void somethingElse(String arg) {
		System.out.println("Here Something Else " + arg);
	}
}

/**
 * @describe ��̬�����࣬����ʵ�ֶ���Ĳ�ͬ�Ĳ���������׷��
 * @author Hope6537(����)
 * @signdate 2014-7-17����02:00:23
 * @version 0.9
 * @company Changchun University&SHXT
 */
class SimpleProxy implements Interface {
	private Interface proxy;

	public SimpleProxy(Interface inter) {
		this.proxy = inter;
	}

	@Override
	public void doSomething() {
		System.out.println("Proxying");
		proxy.doSomething();
	}

	@Override
	public void somethingElse(String arg) {
		System.out.println("Proxying Else");
		proxy.somethingElse(arg);
	}
}

/**
 * @describe ��������
 * @author Hope6537(����)
 * @signdate 2014-7-17����02:01:23
 * @version 0.9
 * @company Changchun University&SHXT
 */
class ProxyDemo {
	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("Classic");
	}

	public static void main(String[] args) {
		consumer(new RealObject());
		consumer(new SimpleProxy(new RealObject()));
	}
}

/**
 * @describe ��̬������
 * @author Hope6537(����)
 * @signdate 2014-7-17����02:01:31
 * @version 0.9
 * @company Changchun University&SHXT
 */
class DynamicProxyHander implements InvocationHandler {
	private Object proxyed;

	public DynamicProxyHander(Object object) {
		proxyed = object;
	}

	/*
	 * (non-Javadoc) ʵ�ִ���ķ��䷽��
	 * 
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object,
	 * java.lang.reflect.Method, java.lang.Object[])
	 * 
	 * @author:Hope6537(����)
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// ��ȡ���࣬�����Ͳ���
		System.out.println("----Proxying : " + proxy.getClass() + " , Method: "
				+ method + " ,args: " + args);
		// ����в����������
		if (args != null) {
			for (Object arg : args) {
				System.out.println("--:" + arg);
			}
		}
		// ��󷵻ط���������
		return method.invoke(proxyed, args);

	}
}

/**
 * @describe ����ѡ����
 * @author Hope6537(����)
 * @signdate 2014-7-17����02:17:52
 * @version 0.9
 * @company Changchun University&SHXT
 */
class MethodSelector implements InvocationHandler {

	private Object proxyed;
	private String wonder;

	public MethodSelector(Object object, String wonder) {
		this.wonder = wonder;
		proxyed = object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		//ѡ���wonder��ͬ�ķ������Ƶķ��������в���
		if (method.getName().equals(wonder)) {
			System.out.println("Confirm");
		}
		return method.invoke(proxyed, args);
	}

}

/**
 * @describe ʵ���࣬��̬����
 * @author Hope6537(����)
 * @signdate 2014-7-17����02:03:16
 * @version 0.9
 * @company Changchun University&SHXT
 */
class SimpleDynamicProxy {
	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("Dynamic");

	}

	public static void main(String[] args) {
		RealObject realobject = new RealObject();
		consumer(realobject);
		/*Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class
				.getClassLoader(), new Class[] { Interface.class },
				new DynamicProxyHander(realobject));*/
		Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class
				.getClassLoader(), new Class[] { Interface.class },
				new MethodSelector(realobject,"doSomething"));
		consumer(proxy);
	}
}

public class ProxyTest {
	public static void main(String[] args) {
		ProxyDemo.main(args);
		SimpleDynamicProxy.main(args);
	}
}
