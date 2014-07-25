package org.hope6537.thinking_in_java.eighteen;

//: io/Logon.java
//Demonstrates the "transient" keyword.
import java.util.concurrent.*;
import java.io.*;
import java.util.*;

/**
 * @describe ʹ��transient�ؼ���
 * @author Hope6537(����)
 * @signdate 2014��7��25������4:55:45
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class Logon implements Serializable {
	private static final long serialVersionUID = -8426369763756174537L;
	private Date date = new Date();
	private String username;
	private transient String password;

	public Logon(String name, String pwd) {
		username = name;
		password = pwd;
	}

	public String toString() {
		return "logon info: \n   username: " + username + "\n   date: " + date
				+ "\n   password: " + password;
	}

	public static void main(String[] args) throws Exception {
		Logon a = new Logon("Hulk", "myLittlePony");
		System.out.println("logon a = " + a);
		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(
				"G:\\Logon.out"));
		o.writeObject(a);
		o.close();
		TimeUnit.SECONDS.sleep(1); // �ӳ�
		// �����л�ȡ
		@SuppressWarnings("resource")
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				"G:\\Logon.out"));
		System.out.println("Recovering object at " + new Date());
		a = (Logon) in.readObject();
		//������ʱ�����Ƿ���transient�ؼ��������Ϣ��ʧ��
		System.out.println("logon a = " + a);
	}
}