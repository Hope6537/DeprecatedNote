package org.hope6537.thinking_in_java.fifteen;

/**
 * @Describe ���ڴ���һ�����࣬���̳���һ���������ͣ�����������ͽ����ҵ��۵�������Ϊ�����
 * @Author Hope6537(����)
 * @Signdate 2014-7-19����06:07:24
 * @version 0.9
 * @company Changchun University&SHXT
 */
class Subtype extends BasicHolder<Subtype> {

}

/**
 * @Describe ��������ɶ
 * @Author Hope6537(����)
 * @Signdate 2014-7-19����06:09:29
 * @version 0.9
 * @company Changchun University&SHXT
 * @param <T>
 */
class SelfBounded <T extends SelfBounded<T>>{
	
}

/**
 * @Describe ��ν��ѭ������
 * @Author Hope6537(����)
 * @Signdate 2014-7-19����06:07:09
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class CRGWithBasicHolder {
	public static void main(String[] args) {
		Subtype st1 = new Subtype() , st2 = new Subtype();
		st1.setElement(st2);
		Subtype st3 = st1.getElement();
		//��ʹ�ҽ�����set���͸�ֵ���������ɻ���Subtype������
		st1.f();
	}
}
