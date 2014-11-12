package org.hope6537.springtest.dao.cglibproxy;

import java.util.List;

/** 
 * <p>Describe: Dao目标接口</p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年9月14日下午2:39:57</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public interface PersonDao {

	public void savePerson(Person person);

	public void updatePerson(Person person);

	public void deletePerson(Person person);

	public List<Person> queryPerson(String HQL);

}
