package org.hope6537.thinking_in_java.fifteen;

/**
 * @Describe ���Ͳ���
 * @Author Hope6537(����)
 * @Signdate 2014-7-19����03:20:54
 * @version 0.9
 * @company Changchun University&SHXT
 * @param <T>
 */
public class ClassTypeCapture<T> {

	Class<T> kind;

	public ClassTypeCapture(Class<T> kind) {
		super();
		this.kind = kind;
	}
	public boolean f(Object arg){
		return kind.isInstance(arg);
	}
}

