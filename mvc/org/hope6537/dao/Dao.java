package org.hope6537.dao;

/** 
 * <p>Describe: 基本数据容器</p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年9月12日下午8:25:11</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public interface Dao<T> {

	/**
	 * <p>Describe: 将T对象持久化</p>
	 * <p>Using: </p>
	 * <p>How To Work: </p>
	 * <p>DevelopedTime: 2014年9月12日下午8:25:43 </p>
	 * <p>Author:Hope6537</p>
	 * @param obj 所装载对象 类型由子类进行定义
	 * @return
	 * @see
	 */
	public int save(T obj);

}
