package org.hope6537.thinking_in_java.fifteen;

class Other {

}

/**
 * @Describe ����ʹ���κ�������Ϊ�䷺�Ͳ���
 * @Author Hope6537(����)
 * @Signdate 2014-7-19����06:10:48
 * @version 0.9
 * @company Changchun University&SHXT
 */
class BasicOther extends BasicHolder<Other> {

}

/**
 * @Describe ���޶� ǿ�Ʒ��͵������Լ��ı߽������ʹ��
 * @Author Hope6537(����)
 * @Signdate 2014-7-19����06:10:33
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class Unconstrained {
	public static void main(String[] args) {
		BasicOther b = new BasicOther();
		BasicOther b2 = new BasicOther();
		b.setElement(new Other());
		Other o = b.getElement();
		b.f();
	}
	/*
	 * output: other
	 */
}
