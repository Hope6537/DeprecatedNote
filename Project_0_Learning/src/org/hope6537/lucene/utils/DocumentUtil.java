package org.hope6537.lucene.utils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;

public class DocumentUtil {

	/**
	 * <p>Describe: 将Document对象反射成Object对象</p>
	 * <p>Using: 将对象所有的属性映射</p>
	 * <p>How To Work: 使用Java的反射机制完成工作</p>
	 * <pre>
	 * 工作机理：
	 * 1、通过赋予的obj对象的obj.getClass()方法完成Class对象的获取
	 * 2、使用该Class的getDeclaredFields();方法获取到所有的属性域，包括private域
	 * 3、迭代属性对象 for (Field field : fields) 然后通过 PropertyDescriptor的构造方法赋值属性名称和对象
	 * 4、通过PropertyDescriptor的getWriteMethod()方法获取到set方法
	 * 5、由于是属性的set方法，参数只会有一个，获取到参数的类型Class, Class<?> setClz = setMethod.getParameterTypes()[0];
	 * 6、获取到value = document.get(fieldName); 这是该Document保存域的对象值
	 * 7、进行setClz的类型判断，由于Lucene是文本搜素，所以以字符串为主，可能会有标识（ID）这样的数型对象，转换之
	 * 8、使用invoke方法驱动反射赋值
	 * 9、返回obj
	 * </pre>
	 * <p>DevelopedTime: 2014年9月26日下午8:09:55 </p>
	 * <p>Author:Hope6537</p>
	 * @param obj 要被注入赋值的对象
	 * @param document 保存数据的document
	 * @return obj 装有数据的对象
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IntrospectionException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @see
	 */
	public static Object document2Object(Object obj, Document document)
			throws InstantiationException, IllegalAccessException,
			IntrospectionException, IllegalArgumentException,
			InvocationTargetException {
		if (obj == null) {
			return null;
		} else {
			Class<?> clz = obj.getClass();
			Field[] fields = clz.getDeclaredFields();
			for (Field field : fields) {
				PropertyDescriptor pd = new PropertyDescriptor(field.getName(),
						clz);
				Method setMethod = pd.getWriteMethod();
				Class<?> setClz = setMethod.getParameterTypes()[0];
				String fieldName = field.getName();
				Object value = document.get(fieldName);
				if (setClz.equals(java.lang.Integer.class)) {
					setMethod.invoke(obj, Integer.parseInt(value.toString()));
				} else if (setClz.equals(java.lang.Long.class)) {
					setMethod.invoke(obj, Long.parseLong(value.toString()));
				} else if (setClz.equals(java.lang.Double.class)) {
					setMethod.invoke(obj, Double.parseDouble(value.toString()));
				} else {
					setMethod.invoke(obj, setClz.cast(value));
				}
			}
			return obj;
		}
	}

	/**
	 * <p>Describe: 将Object对象映射成Document对象</p>
	 * <p>Using: 用于转换对象并生成索引和正文</p>
	 * <p>How To Work: 使用Java的反射机制获取对象内部的值</p>
	 * <pre>
	 * 工作机理：
	 * 1、获取到对象的类型
	 * 2、获取到对象的方法数组
	 * 3、迭代并找出Read即get方法
	 * 4、获取到当前Field对象的属性名 即document对象的fieldId
	 * 5、通过invoke获取value
	 * 6、fieldId, value.toString(), Store.YES, Index.ANALYZED 以全存储，分词存储格式进行该属性索引和正文的保存
	 * 7、添加进document
	 * 8、全部迭代完毕后返回document
	 * </pre>
	 * <p>DevelopedTime: 2014年9月26日下午8:19:55 </p>
	 * <p>Author:Hope6537</p>
	 * @param object 待记录的对象
	 * @return document 装有当前对象的document
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws IntrospectionException
	 * @see
	 */
	public static Document object2Document(Object object)
			throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, IntrospectionException {
		Document document = new Document();
		Class<?> clz = object.getClass();
		Field[] fields = clz.getDeclaredFields();
		for (Field field : fields) {
			PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clz);
			Method getMethod = pd.getReadMethod();
			String fieldId = field.getName();
			Object value = getMethod.invoke(object);
			org.apache.lucene.document.Field luceneField = new org.apache.lucene.document.Field(
					fieldId, value.toString(), Store.YES, Index.ANALYZED);
			document.add(luceneField);
		}
		return document;
	}

}
