package org.hope6537.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import org.hope6537.action.PersonAction;
import org.hope6537.model.Person;
import org.hope6537.utils.SpringHelper;
import org.junit.Test;

public class ClientTest extends SpringHelper {

	@Test
	public void test() throws Exception {
		PersonAction action = (PersonAction) context.getBean("personAction");
		Person person = new Person();
		person.setPid(1);
		person.setPname("张三");
		action.savePerson(person);

		File file = (File) context.getBean("file");
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
		Person person2;
		person2 = (Person) in.readObject();
		System.out.println(person2.toString());
		/*
		 * while ((person2 = (Person) in.readObject()) != null) {
		 * person2.toString(); }
		 */
		in.close();
	}
}
