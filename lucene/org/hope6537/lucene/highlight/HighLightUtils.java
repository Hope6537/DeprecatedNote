package org.hope6537.lucene.highlight;

import org.apache.lucene.search.Query;
import org.apache.lucene.search.highlight.Formatter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.Scorer;
import org.apache.lucene.search.highlight.SimpleFragmenter;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.hope6537.lucene.utils.LuceneUtils;

/** 
 * <p>Describe: Lucene高亮工具</p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年10月4日下午2:18:07</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class HighLightUtils {

	private static Formatter formatter = null;
	private static Scorer scorer = null;

	static {
		formatter = new SimpleHTMLFormatter("<b>", "</b>");
	}

	public static String setLightData(Query query, String value, int size) {
		String result = null;
		scorer = new QueryScorer(query);
		Highlighter highlighter = new Highlighter(formatter, scorer);
		highlighter.setTextFragmenter(new SimpleFragmenter(size));
		try {
			result = highlighter.getBestFragment(LuceneUtils.analyzer, null,
					value);
			if (result == null) {
				if (value.length() > size) {
					result = value.substring(0, size);
				} else {
					result = value;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
}
