package org.hope6537.dao;

import org.hope6537.model.Person;

public interface PersonDao extends Dao<Person> {

	/* (non-Javadoc)
	 * @see org.hope6537.dao.Dao#save(java.lang.Object)
	 * @Change:Hope6537
	 */
	@Override
	public int save(Person obj);

}
