package org.hope6537.thinking_in_java.eighteen;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @describe ʹ��Zip����ѹ��
 * @author Hope6537(����)
 * @signdate 2014��7��25������1:57:52
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class ZipCompress {

	public static void main(String[] args) {
		try {
			Compress(new String[] { "G:\\Data.txt" });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	public static void Compress(String[] args) throws IOException {
		File file = new File("G:\\ZipCompress.zip");
		FileOutputStream f = new FileOutputStream(file);
		// ����ѹ����ʽ ����ѹ���ļ������ ���徏�n����� ����ע��
		CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());
		ZipOutputStream zos = new ZipOutputStream(csum);
		BufferedOutputStream out = new BufferedOutputStream(zos);
		zos.setComment("Java Zipping : Powered By Hope6537");
		// Ȼ��ʼ��ȡ���ļ����ֶ�
		for (String arg : args) {
			System.out.println("Writing texts :" + arg);
			// ��ȡ������
			BufferedReader in = new BufferedReader(new FileReader(arg));
			// ���s�ļ�ݔ��������µ�ZipEntry����ԓ������춻�ȡ�����ø�ѹ���ļ������п������õ�����
			zos.putNextEntry(new ZipEntry(arg));
			int c;
			// ���б߶���д
			while ((c = in.read()) != -1) {
				out.write(c);
			}
			in.close();
			out.flush();
		}
		out.close();
		// Ȼ��ر��� ѹ������

		System.out.println("CheckedOutputStream "
				+ csum.getChecksum().getValue());
		System.out.println("====Reading Files====");
		// ��ȡѹ���ļ� ͬ�� �����ļ���ȡ�� ѹ���ļ���ȡ�� �����ȡ��
		FileInputStream fi2 = new FileInputStream(file);
		CheckedInputStream cusmi = new CheckedInputStream(fi2, new Adler32());
		ZipInputStream in = new ZipInputStream(cusmi);
		BufferedInputStream bis = new BufferedInputStream(in);
		ZipEntry ze;
		// �������ѹ��������ȡ����Ȼ��ʼ�����ֽڶ�
		while ((ze = in.getNextEntry()) != null) {
			System.out.println("Reading File :" + ze);
			int x;
			while ((x = bis.read()) != -1) {
				System.out.write(x);
			}
		}
		System.out.println();
		if (args.length == 1) {
			System.out.println("CheckSum :" + cusmi.getChecksum().getValue());
		}
		bis.close();
		// ����һ�ֽ�ѹ������
		ZipFile zf = new ZipFile(file);
		@SuppressWarnings("rawtypes")
		Enumeration e = zf.entries();
		while (e.hasMoreElements()) {
			ZipEntry ze2 = (ZipEntry) e.nextElement();
			System.out.println("File: " + ze2);

		}
	}
}
