package org.hope6537.thinking_in_java.seventeen;

import java.util.LinkedHashMap;

import org.hope6537.thinking_in_java.fifteen.Generator;

/**
 * @describe MapÉú³ÉÆ÷
 * @author Hope6537(ÕÔÅô)
 * @signdate 2014-7-22ÏÂÎç03:35:16
 * @version 0.9
 * @company Changchun University&SHXT
 * @param <K>
 * @param <V>
 */
public class MapData<K, V> extends LinkedHashMap<K, V> {
	/**
	 * @describe
	 */
	private static final long serialVersionUID = -2083780903878303606L;

	public MapData(Generator<Pair<K, V>> gen, int quantity) {
		for (int i = 0; i < quantity; i++) {
			Pair<K, V> p = gen.next();
			put(p.key, p.value);
		}
	}

	public MapData(Generator<K> key, Generator<V> value, int quantity) {
		for (int i = 0; i < quantity; i++) {
			put(key.next(), value.next());
		}
	}

	public MapData(Generator<K> key, V value, int quantity) {
		for (int i = 0; i < quantity; i++) {
			put(key.next(), value);
		}
	}

	public MapData(Iterable<K> genK, Generator<V> genV) {
		for (K key : genK) {
			put(key, genV.next());
		}
	}

	public MapData(Iterable<K> genK, V value) {
		for (K key : genK) {
			put(key, value);
		}
	}

	public static <K, V> MapData<K, V> map(Generator<Pair<K, V>> gen,
			int quantity) {
		return new MapData<K, V>(gen, quantity);
	}

	public static <K, V> MapData<K, V> map(Generator<K> genK,
			Generator<V> genV, int quantity) {
		return new MapData<K, V>(genK, genV, quantity);
	}

	public static <K, V> MapData<K, V> map(Generator<K> genK, V value,
			int quantity) {
		return new MapData<K, V>(genK, value, quantity);
	}

	public static <K, V> MapData<K, V> map(Iterable<K> genK, Generator<V> genV) {
		return new MapData<K, V>(genK, genV);
	}

	public static <K, V> MapData<K, V> map(Iterable<K> genK, V value) {
		return new MapData<K, V>(genK, value);
	}

}
