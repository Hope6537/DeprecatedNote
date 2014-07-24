package org.hope6537.thinking_in_java.eighteen;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

/**
 * @describe ���뼯
 * @author Hope6537(����)
 * @signdate 2014��7��24������5:44:10
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class AvailableCharSets {

	public static void main(String[] args) {
		SortedMap<String, Charset> charSets = Charset.availableCharsets();
		Iterator<String> iterator = charSets.keySet().iterator();
		while (iterator.hasNext()) {
			String csName = iterator.next();
			System.out.print(csName);
			Iterator<String> aliases = charSets.get(csName).aliases()
					.iterator();
			if (aliases.hasNext()) {
				System.out.print(" : ");
			}
			while (aliases.hasNext()) {
				System.out.print(aliases.next());
				if (aliases.hasNext()) {
					System.out.print(" , ");
				}
			}
			System.out.println();
		}
	}
}
