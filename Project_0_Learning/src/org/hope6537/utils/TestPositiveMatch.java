package org.hope6537.utils;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/** 
 * <p>Describe: 基于词典的分词</p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年9月12日下午1:27:42</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class TestPositiveMatch {

	@Test
	public void test() {

		String str = "我爱中华人民共和国大家庭";
		List<String> normalDict = new ArrayList<String>();
		normalDict.add("");
		normalDict.add("爱");
		normalDict.add("中华");
		// 测试词库的添加
		normalDict.add("中华人民共和国");
		// 传入字符串的长度
		int strLen = str.length();
		int j = 0;
		// 根据词库里的数据所识别出来的词
		String matchWord = "";
		// 识别出来的词在当前句子中的位置
		int matchPos = 0;
		// 从0字符匹配到字符串结束
		while (j < strLen) {
			// 截取字符串的位置
			int matchPosTmp = 0;
			int i = 1;
			// 从当前位置直到整句结束，匹配最大长度
			while (matchPosTmp < strLen) {
				matchPosTmp = i + j;
				// 将字符串的最长单词切出,也就是所谓的切出最大字符串（最大匹配）
				String keyTmp = str.substring(j, matchPosTmp);
				// 如果当前字符串在字典中
				if (normalDict.contains(keyTmp)) {
					// 匹配上了就赋值
					matchWord = keyTmp;
					// 保存好匹配位置
					matchPos = matchPosTmp;
				}
				i++;
			}
			if (!matchWord.isEmpty()) {
				// 有匹配结果就输出最大长度匹配字符串
				j = matchPos;
				// 保存位置,下次从当前位置向后截取
				System.out.println(matchWord + " ");
			} else {
				// 如果没有匹配上的词，那么单字切分
				System.out.println(str.substring(j, ++j) + " ");
			}
			matchWord = "";

		}

	}
}
