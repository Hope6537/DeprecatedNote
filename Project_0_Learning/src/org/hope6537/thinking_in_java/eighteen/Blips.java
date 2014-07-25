package org.hope6537.thinking_in_java.eighteen;

import java.io.*;

class Blip1 implements Externalizable {
	/**
	 * @describe ע�� ���е�[Ĭ��]���������ᱻ����
	 * @author Hope6537(����)
	 */
	public Blip1() {
		System.out.println("Blip1 Constructor");
	}

	public Blip1(int i) {
		System.out.println("Blip1 Constructor with Param");
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Blip1.writeExternal");
	}

	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		System.out.println("Blip1.readExternal");
	}
}

class Blip2 implements Externalizable {
	Blip2() {
		System.out.println("Blip2 Constructor");
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Blip2.writeExternal");
	}

	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		System.out.println("Blip2.readExternal");
	}
}

/**
 * @describe ���л��ͷ����л�ʵ��
 * @author Hope6537(����)
 * @signdate 2014��7��25������4:06:30
 * @version 0.9
 * @company Changchun University&SHXT
 */
// �����д������� û������ ���ǵ��������л�д�� ���ڻ�ԭ������ 1�����˹�����Ȼ���ٵ������л�����д�� ����2�ͳ������쳣
// ��Ϊb1�Ĺ������ǹ����� ��b2�Ĳ���
// ��Serializable��ͬ ��Externalizable����ù��췽��֮�� ��д������
public class Blips {
	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		System.out.println("Constructing objects:");
		Blip1 b1 = new Blip1();
		Blip2 b2 = new Blip2();
		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(
				"Blips.out"));
		System.out.println("Saving objects:");
		o.writeObject(b1);
		o.writeObject(b2);
		o.close();
		// Now get them back:
		@SuppressWarnings("resource")
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				"Blips.out"));
		System.out.println("Recovering b1:");
		b1 = (Blip1) in.readObject();
		// �����쳣
		// ! System.out.println("Recovering b2:");
		// ! b2 = (Blip2)in.readObject();
	}
}