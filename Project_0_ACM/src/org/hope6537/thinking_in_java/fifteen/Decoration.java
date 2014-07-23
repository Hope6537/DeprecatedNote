package org.hope6537.thinking_in_java.fifteen;

import java.util.Date;

class Basic1 {
	private String value;

	public void set(String val) {
		this.value = val;
	}

	public String get() {
		return value;
	}
}

class Decoratior extends Basic1 {
	protected Basic1 basic;

	public Decoratior(Basic1 basic) {
		super();
		this.basic = basic;
	}

	@Override
	public void set(String val) {
		basic.set(val);
	}

	@Override
	public String get() {
		return basic.get();
	}
}

class TimeStamped1 extends Decoratior {
	private final long timeStamp;

	public TimeStamped1(Basic1 basic) {
		super(basic);
		this.timeStamp = new Date().getTime();
	}

	public long getStamp() {
		return timeStamp;
	}
}

class SerialNumberImp1 extends Decoratior {
	private static long counter = 1;
	private final long serialNumber = counter++;

	public SerialNumberImp1(Basic1 basic) {
		super(basic);
	}

	public long getSerialNumber() {
		return serialNumber;
	}
}

/**
 * @Describe ʹ��װ����ģʽ �����Է��͵���������з�����������ʹ��װ�����������Ķ������������װ�ε����ͣ�����������������
 * ���������ֻ�ܲ������һ�㱻��װ�����͵ķ���
 * ��ͼs2�޷�����getStamp()����һ��
 * @Author Hope6537(����)
 * @Signdate 2014-7-20����01:29:23
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class Decoration {
	public static void main(String[] args) {
		TimeStamped1 t = new TimeStamped1(new Basic1());
		SerialNumberImp1 s = new SerialNumberImp1(new Basic1());
		//��������Ϊɶ��ʹ�أ�
		TimeStamped1 t2 = new TimeStamped1(new SerialNumberImp1(new Basic1()));	
		SerialNumberImp1 s2 = new SerialNumberImp1(new TimeStamped1(new Basic1()));
		
		System.out.println(s2.getSerialNumber());
	}
}
