package org.hope6537.springtest.aoptest.exception.execute;

import org.hope6537.springtest.aoptest.exception.PersonAction;
import org.hope6537.utils.SpringHelper;
import org.junit.Test;

public class Client extends SpringHelper{
	
	@Test
	public void test() throws Exception{
		PersonAction action = (PersonAction) context.getBean("personAction");
		action.deletePerson();
	}

}
