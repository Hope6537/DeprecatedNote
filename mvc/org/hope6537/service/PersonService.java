package org.hope6537.service;

import org.hope6537.model.Person;

/** 
 * <p>Describe: Person对象的服务类</p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年9月12日下午8:23:25</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public interface PersonService {

	/**
	 *<pre>
	 *将一个完整的Person对象以某种方式进行持久化存储
	 *需要调用到Dao层的持久化类对象
	 *</pre>
	 * <p>Describe: 用于保存Person对象</p>
	 * <p>Using: </p>
	 * <p>How To Work: </p>
	 * <p>DevelopedTime: 2014年9月12日下午8:22:40 </p>
	 * <p>Author:Hope6537</p>
	 * @return
	 * @see
	 */
	public int savePerson(Person person);

}
