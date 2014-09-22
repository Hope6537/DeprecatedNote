package org.hope6537.springtest.aop.annotation;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/** 
 * <p>Describe: Dao层的实现类</p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年9月14日下午2:41:53</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
@Component("personDao")
public class PersonDaoImpl implements PersonDao {

	@Override
	public void savePerson(Person person) {
		System.out.println("Save Person");
		System.out.println(person.toString());
	}

	@Override
	public void updatePerson(Person person) {
		System.out.println("Update Person");
		System.out.println(person.toString());
	}

	@Override
	public void deletePerson(Person person) {
		System.out.println("Delete Person");
		System.out.println(person.toString());
	}

	@Override
	public List<Person> queryPerson(String HQL) {
		// int a = 1 / 0; 用于捕捉异常
		ArrayList<Person> list = new ArrayList<Person>();
		list.add(new Person(1, "pname"));
		System.out.println(list.toString());
		return list;
	}
}
