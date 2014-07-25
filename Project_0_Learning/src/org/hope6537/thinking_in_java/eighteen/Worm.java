package org.hope6537.thinking_in_java.eighteen;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;

class Data implements Serializable {
	private int n;

	public Data(int n) {
		super();
		this.n = n;
	}

	@Override
	public String toString() {
		return n + "";
	}

}

public class Worm implements Serializable {

	private static Random rand = new Random(47);

	private Data[] d = new Data[] { new Data(rand.nextInt(10)),
			new Data(rand.nextInt(10)), new Data(rand.nextInt(10)) };

	private Worm next;
	private char c;

	public Worm(int i, char x) {

		System.out.println("Worm ���췽��" + i);
		c = x;
		if (--i > 0) {
			next = new Worm(i, (char) (x + 1));
		}
	}

	public Worm() {
		System.out.println("Default");
	}

	@Override
	public String toString() {
		StringBuilder rBuilder = new StringBuilder("-->");
		rBuilder.append(c);
		rBuilder.append("(");
		for (Data dat : d) {
			rBuilder.append(dat);
		}
		rBuilder.append(")");
		if (next != null) {
			rBuilder.append(next);
		}
		return rBuilder.toString();
	}

	public static void main(String[] args) throws Exception {
		// ��һ�ַ��� ��д�ļ�
		File file = new File("G:\\Worm.txt");
		Worm w = new Worm(6, 'a');
		System.out.println("w = " + w);
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
				file));
		out.writeObject("Worm Storage\n");
		out.writeObject(w);
		out.flush();
		out.close();
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
		String s = (String) in.readObject();
		Worm w2 = (Worm) in.readObject();
		System.out.println(s + "w2 = " + w2);
		//�ڶ��ַ��� ��д�ַ�����
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ObjectOutputStream out2 = new ObjectOutputStream(bout);
		out2.writeObject("Worm storage\n");
		out2.writeObject(w);
		out2.flush();
		ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(
				bout.toByteArray()));
		s = (String) in2.readObject();
		Worm w3 = (Worm) in2.readObject();
		System.out.println(s + "w3 = " + w3);
	}

}
