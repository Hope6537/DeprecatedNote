package org.hope6537.thinking_in_java.fifteen;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

class MixinProxy implements InvocationHandler {
	/**
	 * @Describe ���������� �ﱤ�� ����<->�����ϵӳ��
	 */
	Map<String, Object> delehatesByMethod;

	/**
	 * @Describe ���췽��������̬�����Class�ķ����� ����ӳ���У��Դ�����
	 *           һ��������Ӧ��һ�������Object�������ַ������ǿ���ִ�еĶ���Class��
	 * @Author Hope6537(����)
	 * @param @param pairs
	 */
	public MixinProxy(TwoTuple<Object, Class<?>>... pairs) {
		delehatesByMethod = new HashMap<String, Object>();
		for (TwoTuple<Object, Class<?>> pair : pairs) {
			for (Method method : pair.second.getMethods()) {
				String methodName = method.getName();
				if (!delehatesByMethod.containsKey(methodName)) {
					delehatesByMethod.put(methodName, pair.first);
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object,
	 * java.lang.reflect.Method, java.lang.Object[])
	 * 
	 * @Author:Hope6537(����) ִ�з��䷽��
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		String methodName = method.getName();
		Object delegate = delehatesByMethod.get(methodName);
		return method.invoke(delegate, args);
	}

	@SuppressWarnings("unchecked")
	// δ���巺�ͣ����Կ������
	public static Object newInstance(TwoTuple... pairs) {
		Class[] interfaces = new Class[pairs.length];
		for (int i = 0; i < pairs.length; i++) {
			interfaces[i] = (Class) pairs[i].second;
		}
		// �Բ����ɶ��˼,��װ������
		ClassLoader c1 = pairs[0].first.getClass().getClassLoader();
		// ���ص�Object�����ⶫ�����ɵģ�
		return Proxy.newProxyInstance(c1, interfaces, new MixinProxy(pairs));
	}

}

/**
 * @Describe ��̬�����������
 * @Author Hope6537(����)
 * @Signdate 2014-7-20����01:57:21
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class DynamicProxyMinin {
	public static void main(String[] args) {
		Object mixin = MixinProxy.newInstance(
				tuple(new BasicImp(), Basic.class), tuple(new TimeStampedImp(),
						TimeStamped.class), tuple(new SerialNumberImp(),
						SerialNumbered.class));

		Basic b = (Basic) mixin;
		TimeStamped t = (TimeStamped) mixin;
		SerialNumbered s = (SerialNumbered) mixin;
		b.set("Hello");
		System.out.println(b.get());
		System.out.println(t.getStamp());
		System.out.println(s.getSerialNumber());
	}

	/**
	 * @Descirbe ���ɸ����͵ĳ��ж��󣬷ֱ�װ��Object�����Class����
	 * @Author Hope6537(����)
	 * @Params @param object
	 * @Params @param class1
	 * @Params @return
	 * @SignDate 2014-7-20����02:05:36
	 * @Version 0.9
	 */
	@SuppressWarnings("unchecked")
	private static TwoTuple tuple(Object object, Class class1) {
		return new TwoTuple<Object, Class>(object, class1);
	}
}
