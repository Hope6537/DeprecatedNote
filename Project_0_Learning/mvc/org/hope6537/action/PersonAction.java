package org.hope6537.action;

import org.hope6537.model.Person;
import org.hope6537.service.PersonService;

/** 
 * <p>Describe: 面向用户的网页跳转中间件action</p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年9月12日下午8:43:55</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class PersonAction {

	/**
	 * <p>Describe: 等待注入的服务类</p>
	 * <p>Using: </p>
	 */
	private PersonService personService;

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	public int savePerson(Person person) {
		return personService.savePerson(person);
	}
}
