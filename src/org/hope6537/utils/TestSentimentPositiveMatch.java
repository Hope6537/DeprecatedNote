package org.hope6537.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/** 
 *<pre>
 
 *</pre>
 * <p>Describe: 对词组进行脱机分类</p>
 * <p>Using: 使用关系数组进行词组映射</p>
 * <p>DevelopedTime: 2014年9月12日下午3:40:29</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class TestSentimentPositiveMatch {
	
	@Test
	public void test(){
		String str = "你假如上午没给我吃冰淇淋，我绝对会不happy的。";

		// 语义映射
		Map<String, String> sentimentMap = new HashMap<String, String>();
		sentimentMap.put("happy", "高兴");

		// 情感词库
		List<String> sentimentDict = new ArrayList<String>();
		sentimentDict.add("happy");

		// 修饰词
		List<String> decorativeDict = new ArrayList<String>();
		decorativeDict.add("不");
		decorativeDict.add("没");

		// 修饰词衡量分数
		Map<String, Double> decorativeScoreMap = new HashMap<String, Double>();
		decorativeScoreMap.put("不", -0.5);
		decorativeScoreMap.put("没", -0.5);

		List<String> decorativeWordList = new ArrayList<String>(); // 修饰词
		String sentimentResult = ""; // 情感结果

		int strLen = str.length(); // 传入字符串的长度
		int j = 0;
		String matchSentimentWord = ""; // 根据词库里识别出来的情感词
		String matchDecorativeWord = ""; // 根据词库里识别出来的修饰词
		int matchPos = 0; // 根据词库里识别出来词后当前句子中的位置
		while (j < strLen) { // 从0字符匹配到字符串结束
			int matchPosTmp = 0; // 截取字符串的位置
			int i = 1;
			while (matchPosTmp < strLen) { // 从当前位置直到整句结束，匹配最大长度
				matchPosTmp = i + j;
				String keyTmp = str.substring(j, matchPosTmp);// 切出最大字符串
				if (sentimentDict.contains(keyTmp)) { // 判断当前字符串是否在词典中
					matchSentimentWord = keyTmp; // 如果在词典中匹配上了就赋值
					matchPos = matchPosTmp; // 同时保存好匹配位置
				}
				if (decorativeDict.contains(keyTmp)) { // 判断当前字符串是否在词典中
					matchDecorativeWord = keyTmp; // 如果在词典中匹配上了就赋值
					matchPos = matchPosTmp; // 同时保存好匹配位置
				}
				i++;
			}
			if (!matchSentimentWord.isEmpty()) {
				// 有匹配结果就输出最大长度匹配字符串
				j = matchPos;
				// 保存位置，下次从当前位置继续往后截取
				System.out.print(matchSentimentWord + " ");
				sentimentResult = sentimentMap.get(matchSentimentWord);
			}
			if (!matchDecorativeWord.isEmpty()) {
				// 有匹配结果就输出最大长度匹配字符串
				j = matchPos;
				// 保存位置，下次从当前位置继续往后截取
				System.out.print(matchDecorativeWord + " ");
				decorativeWordList.add(matchDecorativeWord);
			} else {
				// 从当前词开始往后都没有能够匹配上的词，则按照单字切分的原则切分
				System.out.print(str.substring(j, ++j) + " ");
			}
			matchSentimentWord = "";
			matchDecorativeWord = "";
		}

		double totalScore = 1;
		for (String decorativeWord : decorativeWordList) {
			Double scoreTmp = decorativeScoreMap.get(decorativeWord);
			totalScore *= scoreTmp;
		}

		System.out.print("\r\n");
		if (totalScore > 0) {
			System.out.println("当前心情是：" + sentimentResult);
		} else {
			System.out.println("当前心情是：不" + sentimentResult);
		}
	}
	
	public static void main(String[] args) {
		String str = "你假如上午没给我吃冰淇淋，我绝对会不happy的。";

		// 语义映射
		Map<String, String> sentimentMap = new HashMap<String, String>();
		sentimentMap.put("happy", "高兴");

		// 情感词库
		List<String> sentimentDict = new ArrayList<String>();
		sentimentDict.add("happy");

		// 修饰词
		List<String> decorativeDict = new ArrayList<String>();
		decorativeDict.add("不");
		decorativeDict.add("没");

		// 修饰词衡量分数
		Map<String, Double> decorativeScoreMap = new HashMap<String, Double>();
		decorativeScoreMap.put("不", -0.5);
		decorativeScoreMap.put("没", -0.5);

		List<String> decorativeWordList = new ArrayList<String>(); // 修饰词
		String sentimentResult = ""; // 情感结果

		int strLen = str.length(); // 传入字符串的长度
		int j = 0;
		String matchSentimentWord = ""; // 根据词库里识别出来的情感词
		String matchDecorativeWord = ""; // 根据词库里识别出来的修饰词
		int matchPos = 0; // 根据词库里识别出来词后当前句子中的位置
		while (j < strLen) { // 从0字符匹配到字符串结束
			int matchPosTmp = 0; // 截取字符串的位置
			int i = 1;
			while (matchPosTmp < strLen) { // 从当前位置直到整句结束，匹配最大长度
				matchPosTmp = i + j;
				String keyTmp = str.substring(j, matchPosTmp);// 切出最大字符串
				if (sentimentDict.contains(keyTmp)) { // 判断当前字符串是否在词典中
					matchSentimentWord = keyTmp; // 如果在词典中匹配上了就赋值
					matchPos = matchPosTmp; // 同时保存好匹配位置
				}
				if (decorativeDict.contains(keyTmp)) { // 判断当前字符串是否在词典中
					matchDecorativeWord = keyTmp; // 如果在词典中匹配上了就赋值
					matchPos = matchPosTmp; // 同时保存好匹配位置
				}
				i++;
			}
			if (!matchSentimentWord.isEmpty()) {
				// 有匹配结果就输出最大长度匹配字符串
				j = matchPos;
				// 保存位置，下次从当前位置继续往后截取
				System.out.print(matchSentimentWord + " ");
				sentimentResult = sentimentMap.get(matchSentimentWord);
			}
			if (!matchDecorativeWord.isEmpty()) {
				// 有匹配结果就输出最大长度匹配字符串
				j = matchPos;
				// 保存位置，下次从当前位置继续往后截取
				System.out.print(matchDecorativeWord + " ");
				decorativeWordList.add(matchDecorativeWord);
			} else {
				// 从当前词开始往后都没有能够匹配上的词，则按照单字切分的原则切分
				System.out.print(str.substring(j, ++j) + " ");
			}
			matchSentimentWord = "";
			matchDecorativeWord = "";
		}

		double totalScore = 1;
		for (String decorativeWord : decorativeWordList) {
			Double scoreTmp = decorativeScoreMap.get(decorativeWord);
			totalScore *= scoreTmp;
		}

		System.out.print("\r\n");
		if (totalScore > 0) {
			System.out.println("当前心情是：" + sentimentResult);
		} else {
			System.out.println("当前心情是：不" + sentimentResult);
		}
	}
}