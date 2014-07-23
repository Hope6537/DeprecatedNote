package org.hope6537.thinking_in_java.fifteen;

import java.util.HashSet;
import java.util.Set;

public class Sets {

	/**
	 * @Descirbe ���ϵĲ�����
	 * @Author Hope6537(����)
	 * @Params @param <T>
	 * @Params @param a
	 * @Params @param b
	 * @Params @return
	 * @SignDate 2014-7-19����02:21:41
	 * @Version 0.9
	 */
	public static <T> Set<T> union(Set<T> a, Set<T> b) {
		Set<T> result = new HashSet<T>(a);
		result.addAll(b);
		return result;
	}
	/**
	 * @Descirbe ���ϵĽ�����
	 * @Author Hope6537(����)
	 * @Params @param <T>
	 * @Params @param a
	 * @Params @param b
	 * @Params @return
	 * @SignDate 2014-7-19����02:22:25
	 * @Version 0.9
	 */
	public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
		Set<T> result = new HashSet<T>(a);
		result.retainAll(b);
		return result;
	} 
	
	/**
	 * @Descirbe ���ϵĲ����
	 * @Author Hope6537(����)
	 * @Params @param <T>
	 * @Params @param superset
	 * @Params @param subset
	 * @Params @return
	 * @SignDate 2014-7-19����02:23:08
	 * @Version 0.9
	 */
	public static <T> Set<T> difference(Set<T> superset, Set<T> subset) {
		Set<T> result = new HashSet<T>(superset);
		result.removeAll(subset);
		return result;
	} 
	
	/**
	 * @Descirbe ���س��˽���֮�������Ԫ��
	 * @Author Hope6537(����)
	 * @Params @param <T>
	 * @Params @param a
	 * @Params @param b
	 * @Params @return
	 * @SignDate 2014-7-19����02:23:53
	 * @Version 0.9
	 */
	public static <T> Set<T> complement(Set<T> a, Set<T> b) {
		return difference(union(a, b), intersection(a, b));
	} 

}
