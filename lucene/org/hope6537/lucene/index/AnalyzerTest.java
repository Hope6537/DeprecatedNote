package org.hope6537.lucene.index;

import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cjk.CJKAnalyzer;
import org.apache.lucene.analysis.cn.ChineseAnalyzer;
import org.apache.lucene.analysis.tokenattributes.TermAttribute;
import org.apache.lucene.util.Version;
import org.hope6537.lucene.utils.LuceneUtils;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

/** 
 * <p>Describe: 分词器测试</p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年9月27日下午7:38:23</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class AnalyzerTest {

	private void testAnalyzer(Analyzer analyzer, String text) throws Exception {
		TokenStream stream = analyzer.tokenStream("content", new StringReader(text));
		stream.addAttribute(TermAttribute.class);
		while(stream.incrementToken()){
			TermAttribute termAttribute = stream.getAttribute(TermAttribute.class);
			System.out.println(termAttribute.term());
		}
	}
	
	@Test
	public void testEN() throws Exception{
		new AnalyzerTest().testAnalyzer(LuceneUtils.analyzer, "sfjafuqwefjdqwhf qd qwdqwg dqwdghqwjkhdgqwhdqw");
	}
	@Test
	public void testZH() throws Exception{
		//Analyzer analyzer = new ChineseAnalyzer();//逗比的分词器
		//Analyzer analyzer = new CJKAnalyzer(Version.LUCENE_30);
		Analyzer analyzer = new IKAnalyzer();
		String text = "";
		testAnalyzer(analyzer, text);
	}

}
