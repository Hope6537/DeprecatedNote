package org.hope6537.datastructs.Tree;

import java.util.*;

/**
 * @Describe ʹ��Java�Դ���Set �� Map������ֵ�ģ��
 * @Author Hope6537(����)
 * @Signdate 2014-3-27����08:41:52
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class Dictionary {
	/**
	 * @Descirbe ��ӡ�������ֵ����ֵ
	 * @Author Hope6537(����)
	 * @Params @param adjWords
	 * @Params @param minWords
	 * @SignDate 2014-3-27����08:52:13
	 * @Version 0.9
	 * @param adjWords
	 * @param minWords
	 */
	public static void printHighChangeables(Map<String, List<String>> adjWords,
			int minWords) {
		for (Map.Entry<String, List<String>> entry : adjWords.entrySet()) {
			List<String> words = entry.getValue();
			if (words.size() >= minWords) {
				System.out.print(""+entry.getKey() + " (");
				System.out.print(words.size() + ") ");
				for (String w : words) {
					System.out.print(" " + w);
				}
				System.out.println();
			}
		}
	}

	/**
	 * @Descirbe �Ƚ����������Ƿ�ֻ��һ����ĸ��ͬ
	 * @Author Hope6537(����)
	 * @Params @param word1
	 * @Params @param word2
	 * @Params @return
	 * @SignDate 2014-3-27����08:55:17
	 * @Version 0.9
	 * @param word1
	 * @param word2
	 * @return
	 */
	private static boolean oneCharOff(String word1, String word2) {
		if (word1.length() != word2.length()) {// ���Ȳ��� ֱ����
			return false;
		}
		int diff = 0;// ��ͬ������
		for (int i = 0; i < word1.length(); i++) {// ��ʼ������ĸ����
			if (word1.charAt(i) != word2.charAt(i)) {
				if (++diff > 1) {
					;// ������ֲ����� ��һ�λ�diff+1 diff=1 �������� �����������ѭ�����ֳ��ֲ�ͬ
					return false;// diff=2 > 1 ������
				}
			}
		}
		return diff == 1;// ��󷵻��Ƿ���һ����ͬ ����Ϊ�п��ܶ���ͬ û�о����������ת��
	}

	/**
	 * @Descirbe ���ַ����һ���ĵ�����ӽ�Map���ϵķ����� ��һ������Ϊ�ؼ��֣����Ժ���һ����ĸ�������һ������Ϊֵ
	 * @Author Hope6537(����)
	 * @Params @param <KeyType> �ؼ��ֵı�ʾ��ʽ
	 * @Params @param m Map���� ���ֵ�
	 * @Params @param key �׵���
	 * @Params @param value ����ĵ���
	 * @SignDate 2014-3-27����09:06:43
	 * @Version 0.9
	 * @param <KeyType>
	 * @param m
	 * @param key
	 * @param value
	 */
	private static <KeyType> void update(Map<KeyType, List<String>> m,
			KeyType key, String value) {
		List<String> list = m.get(key);
		if (list == null) {
			list = new ArrayList<String>();
			m.put(key, list);
		}
		list.add(value);

	}

	/**
	 * @Descirbe ������� ���� 89000 ������ ��Ҫ96��
	 * @Author Hope6537(����)
	 * @Params @param theWords
	 * @Params @return
	 * @SignDate 2014-3-27����09:09:49
	 * @Version 0.9
	 * @param theWords
	 * @return 
	 */
	public static Map<String, List<String>> computeAdjacentWords(
			List<String> theWords) {
		Map<String, List<String>> adjWords = new TreeMap<String, List<String>>();// �������򼯺�
		String[] words = new String[theWords.size()];// ����Ϊ����
		theWords.toArray(words);
		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words.length; j++) {
				// ��ͷ��ʼ ���������ȶ�
				if (oneCharOff(words[i], words[j])) {
					// ����������� �������
					update(adjWords, words[i], words[j]);
					update(adjWords, words[j], words[i]);
				}
			}
		}
		return adjWords;
	}

	/**
	 * @Descirbe ����ͬ���г���Ϊ�ؼ��ֵ��ֵ������ ����89000���� 51��
	 * @Author Hope6537(����)
	 * @Params @param theWords
	 * @Params @return
	 * @SignDate 2014-3-27����09:11:24
	 * @Version 0.9
	 * @param theWords
	 * @return
	 */
	public static Map<String, List<String>> computeAdjacentWords_length(
			List<String> theWords) {
		Map<String, List<String>> adjWords = new TreeMap<String, List<String>>();

		Map<Integer, List<String>> wordsByLength = new TreeMap<Integer, List<String>>();

		for (String w : theWords) {// �����ʵĳ��Ƚ���һһ�Ƚ�����,Ȼ���γ�����
			update(wordsByLength, w.length(), w);
		}

		for (List<String> groupsWords : wordsByLength.values()) {// �����ں���һ�����ʳ��ȵ����иó��ȵ��ʵļ���
			// ͨ�����ʵĳ��� ��2��ʼ����ѭ�� ÿ�ζ����ó��ȵĵ��ʽ������黯
			String[] words = new String[groupsWords.size()];
			groupsWords.toArray(words);
			// Ȼ�����ȶ�
			for (int i = 0; i < words.length; i++) {
				for (int j = i + 1; j < words.length; j++) {
					// ��ͷ��ʼ ���������ȶ�
					if (oneCharOff(words[i], words[j])) {
						// ����������� �������
						update(adjWords, words[i], words[j]);
						update(adjWords, words[j], words[i]);
					}
				}
			}
		}
		return adjWords;
	}

	/**
	 * @Descirbe �Ե�����Ϊ�ؼ��ֵ��ֵ������ ����160000������ 4791����
	 * @Author Hope6537(����)
	 * @Params @param theWords
	 * @Params @return
	 * @SignDate 2014-3-27����09:19:39
	 * @Version 0.9
	 * @param theWords
	 * @return
	 */
	public static Map<String, List<String>> computeAdjacentWords_word(
			List<String> theWords) {
		Map<String, List<String>> adjWords = new TreeMap<String, List<String>>();

		Map<Integer, List<String>> wordsByLength = new TreeMap<Integer, List<String>>();

		for (String w : theWords) {
			update(wordsByLength, w.length(), w);
		}
		// ֮ǰ�ĺ�����computeAdjacentWords_lengthһ��
		for (Map.Entry<Integer, List<String>> entry : wordsByLength.entrySet()) {
			//��������Գ���Ϊ�ؼ��ֵĵ��ʼ��ϰ���ѭ�� ��һ��������������Ϊ���ȵ��ַ��������ʣ�
			List<String> groupWords = entry.getValue();// ���ǵ��ʼ�
			int groupNum = entry.getKey();// ����������ʼ��ĵ��ʳ���
			
			for (int i = 0; i < groupNum; i++) {
				//���±�0��ʼ ����һ��ѭ����set���ϵĵ��ʳ��� �� �ⲿѭ��ÿ�θ�����set groupNumҲ��֮�仯
				Map<String, List<String>> repToWord = new TreeMap<String, List<String>>();
				//�����Ե���Ϊ�ؼ��� ���쵥�ʱ�Ϊֵ��ӳ��
				for (String str : groupWords) {
					//������ĵ��ʼ���ʼ�������е�String���� 
					String rep = str.substring(0, i) + str.substring(i + 1);
					//�����еĵ������νش� Ȼ���ٲ���repToWordӳ���� ��i�㱻���µ�ʣ�൥����Ϊ�ؼ��� ������Ϊ����
					//���� inat inbt inct indt
					//��� i=3 ʱ �ѵ������ַ��ص�  �򱾴�ѭ����Ϻ� repToWord������Ϊ <int,inat>,<int,inbt>.... 
					update(repToWord, rep, str);
				}
				for (List<String> wordClique : repToWord.values()) {
					//��һ������Ƭ��������ĵ�������ѭ��
					if (wordClique.size() >= 2) {
						//������Ƭ�εĵ��ʴ���2
						for (String s1 : wordClique) {
							for (String s2 : wordClique) {
								//s1��s2 ����ͬ ����s1Ϊ�ؼ��� �����adjWords�ֵ�����
								if (s1 != s2) {
									update(adjWords, s1, s2);
								}
							}
						}
					}
				}
			}
		}

		return adjWords;
	}
	
	public static void main(String[] args) {
		Dictionary d = new Dictionary();
		List<String> list = new ArrayList<String>();
		for(int i = 65 ; i < 82 ; i++){
			for(int j = 65 ; j < 82 ; j++){
				for(int k = 65 ; k < 82 ; k++){
					for(int n = 65 ; n < 82 ; n++){
					list.add((char)i+"K"+(char)i+(char)j+(char)k+(char)n);
					}
				}
				
			}
			
		}
		Map<String, List<String>> a = Dictionary.computeAdjacentWords_word(list);
		Dictionary.printHighChangeables(a,1);
		/*int count = 0;
		for(String s : list){
			System.out.print(s+" ");
			count++;
			if(count % 20 == 0){
				System.out.println();
			}
		}*/
		
	}

}
