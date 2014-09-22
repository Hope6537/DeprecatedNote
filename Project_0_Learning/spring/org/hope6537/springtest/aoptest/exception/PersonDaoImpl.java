package org.hope6537.springtest.aoptest.exception;

public class PersonDaoImpl implements PersonDao {

	@Override
	public void savePerson() throws Exception {
		System.out.println("savePerson");
		int a = 1 / 0;
	}

	@Override
	public void updatePerson() throws Exception {
		System.out.println("updatePerson");
		int a = 1 / 0;
	}

	@Override
	public void deletePerson() throws Exception {
		System.out.println("deletePerson");
		int a = 1 / 0;
	}

}
