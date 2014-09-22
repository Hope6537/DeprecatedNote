package org.hope6537.springtest.aoptest.exception;

public class PersonServiceImpl implements PersonService {

	private PersonDao dao;

	public PersonDao getDao() {
		return dao;
	}

	public void setDao(PersonDao dao) {
		this.dao = dao;
	}

	@Override
	public void savePerson() throws Exception {
		dao.savePerson();
	}

	@Override
	public void updatePerson() throws Exception {
		dao.updatePerson();
	}

	@Override
	public void deletePerson() throws Exception {
		dao.deletePerson();
	}

}
