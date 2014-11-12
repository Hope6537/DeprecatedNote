package org.hope6537.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.annotation.Resource;

import org.hope6537.model.Person;

public class PersonDaoImpl_Txt implements PersonDao {

	/**
	 * <p>Describe: 保存文件的具体地址</p>
	 * <p>Using: 该对象等待注入路径</p>
	 */
	
	private File file;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hope6537.dao.PersonDao#save(org.hope6537.model.Person)
	 * 
	 * @Change:Hope6537
	 */
	@Override
	public int save(Person obj) {
		if (obj == null) {
			return -1;
		}
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(obj);
			out.close();
			return 1;
		} catch (Exception e) {
			System.err.println("Error: IoException");
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				System.err.println("Error : Close Output InputStream");
				e.printStackTrace();
			}
			System.out.println("Dao Complete");
		}
		return 0;
	}
}
