package org.hope6537.springtest.aoptest.exception;

public class PersonAction {

	private PersonService service;

	public PersonService getService() {
		return service;
	}

	public void setService(PersonService service) {
		this.service = service;
	}

	public void savePerson() throws Exception {
		service.savePerson();
	}

	public void updatePerson() throws Exception {
		service.updatePerson();
	}

	public void deletePerson() throws Exception {
		service.deletePerson();
	}
}
