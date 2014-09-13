package org.hope6537.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUpdateUtils {

	public FileUpdateUtils() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @Descirbe
	 * @Author Hope6537(����)
	 * @Params @param request
	 * @Params @param response
	 * @Params @param folder
	 * @Params @param nextStep
	 * @Params @return
	 * @SignDate 2014-5-2����01:59:09
	 * @Version 0.9
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<String> updateImage(HttpServletRequest request,
			HttpServletResponse response, String folder, String nextStep) {
		ArrayList<String> arrayList = new ArrayList<String>();
		ArrayList<NameValuePair> arrayList2 = new ArrayList<NameValuePair>();
		try {

			response.setContentType("text/html; charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");

			// ��ô����ļ���Ŀ������
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// ��ȡ�ļ��ϴ���Ҫ�����·����upload�ļ�������ڡ�
			String path = request.getSession().getServletContext().getRealPath(
					"/" + folder);
			String lesspath = "//" + folder;
			// ������ʱ����ļ��Ĵ洢�ң�����洢�ҿ��Ժ����մ洢�ļ����ļ��в�ͬ����Ϊ���ļ��ܴ�Ļ���ռ�ù����ڴ��������ô洢�ҡ�
			factory.setRepository(new File(path));
			// ���û���Ĵ�С�����ϴ��ļ���������������ʱ���ͷŵ���ʱ�洢�ҡ�
			factory.setSizeThreshold(1024 * 1024);
			// �ϴ��������ࣨ��ˮƽAPI�ϴ�������
			ServletFileUpload upload = new ServletFileUpload(factory);

			// ���� parseRequest��request������ ����ϴ��ļ� FileItem �ļ���list ��ʵ�ֶ��ļ��ϴ���
			List<FileItem> list = (List<FileItem>) upload.parseRequest(request);
			for (FileItem item : list) {
				// ��ȡ���������֡�
				String name = item.getFieldName();
				// �����ȡ�ı���Ϣ����ͨ���ı���Ϣ����ͨ��ҳ�����ʽ���������ַ�����
				if (item.isFormField()) {
					// ��ȡ�û�����������ַ�����
					String value = item.getString();
					arrayList2.add(new NameValuePair(name, value));
				}
				// ���������ǷǼ��ַ���������ͼƬ����Ƶ����Ƶ�ȶ������ļ���
				else {
					// ��ȡ·����
					String value = item.getName();
					// ȡ�����һ����б�ܡ�
					int start = value.lastIndexOf("\\");
					// ��ȡ�ϴ��ļ��� �ַ������֡�+1��ȥ����б�ܡ�
					String filename = value.substring(start + 1);
					/*
					 * �������ṩ�ķ���ֱ��д���ļ��С� item.write(new File(path,filename));
					 */
					// �յ�д�����յ��ļ��С�
					OutputStream out = new FileOutputStream(new File(path,
							filename));
					InputStream in = item.getInputStream();

					arrayList.add(lesspath + "//" + filename);
					int length = 0;
					byte[] buf = new byte[1024];
					System.out.println("��ȡ�ļ�����������:" + item.getSize());

					while ((length = in.read(buf)) != -1) {
						out.write(buf, 0, length);
					}
					in.close();
					out.close();
				}
			}
			request.setAttribute("PARAMS", arrayList2);
			request.setAttribute("FILEPATHS", arrayList);
			// UserinfoServiceServlet?SERVICE=UPDATESERVICE&&STEP=2
			request.getRequestDispatcher(nextStep).forward(request, response);
			return arrayList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
