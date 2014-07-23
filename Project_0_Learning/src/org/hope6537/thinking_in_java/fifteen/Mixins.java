package org.hope6537.thinking_in_java.fifteen;

import java.util.Date;

interface TimeStamped {
	long getStamp();
}

interface SerialNumbered {
	long getSerialNumber();
}

interface Basic {
	public void set(String val);

	public String get();
}

class TimeStampedImp implements TimeStamped {
	public TimeStampedImp() {
		super();
		this.timeStamp = new Date().getTime();
	}

	private final long timeStamp;

	@Override
	public long getStamp() {
		return timeStamp;
	}
}

class SerialNumberImp implements SerialNumbered {
	private static long counter = 1;
	private final long serialNumber = counter++;

	@Override
	public long getSerialNumber() {
		return serialNumber;
	}
}

class BasicImp implements Basic {
	private String value;

	@Override
	public void set(String val) {
		this.value = val;
	}

	@Override
	public String get() {
		return value;
	}
}

/**
 * @Describe ��ӿڻ�ϴӶ���������
 * @Author Hope6537(����)
 * @Signdate 2014-7-20����01:27:07
 * @version 0.9
 * @company Changchun University&SHXT
 */
class Mixin extends BasicImp implements TimeStamped, SerialNumbered {
	private TimeStamped timeStamp = new TimeStampedImp();
	private SerialNumbered serialNumber = new SerialNumberImp();

	@Override
	public long getStamp() {
		return timeStamp.getStamp();
	}

	@Override
	public long getSerialNumber() {
		return serialNumber.getSerialNumber();
	}
}

public class Mixins {
	public static void main(String[] args) {
		Mixin mixin1 = new Mixin(), mixin2 = new Mixin();
		mixin1.set("test1");
		mixin2.set("test2");
	}

}
