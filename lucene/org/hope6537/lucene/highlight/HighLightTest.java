package org.hope6537.lucene.highlight;

import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.util.Version;
import org.hope6537.bean.Article;
import org.hope6537.lucene.utils.Document2ObjectUtils;
import org.hope6537.lucene.utils.LuceneUtils;
import org.junit.Test;

/** 
 *<pre>
 *高亮
 *使关键字变色
 *	1、设置
 *	2、使用
 *控制摘要的大小
 *</pre>
 * @see
 */
public class HighLightTest {

	@Test
	public void searchIndex() throws Exception {
		IndexSearcher indexSearcher = new IndexSearcher(LuceneUtils.directory);
		QueryParser queryParser = new MultiFieldQueryParser(Version.LUCENE_30,
				new String[] { "title", "content" }, LuceneUtils.analyzer);
		Query query = queryParser.parse("views");// 关键字
		TopDocs topDocs = indexSearcher.search(query, 100);
		ScoreDoc[] scoreDocs = topDocs.scoreDocs;
		/**新增***************************************************************************/
		/*// 关键字左右添加前缀后缀
		Formatter formatter = new SimpleHTMLFormatter("<font color = 'red'>",
				"</font>");
		// 封装了关键字
		Scorer scorer = new QueryScorer(query);
		Highlighter highlighter = new Highlighter(formatter, scorer);
		// 创建一个摘要 控制摘要大小
		Fragmenter fragmenter = new SimpleFragmenter(20);
		highlighter.setTextFragmenter(fragmenter);*/
		/**新增结束***************************************************************************/
		
		List<Article> articleList = new ArrayList<Article>();
		for (ScoreDoc doc : scoreDocs) {
			System.out.println("相关度得分+" + doc.score);
			int index = doc.doc;
			Document document = indexSearcher.doc(index);
			/**将查询结果高亮**和前面的query关键字的域一样*************************************************************************/
			//String title = highlighter.getBestFragment(LuceneUtils.analyzer, "content",document.get("content"));
			//使用工具进行封装
			String title = HighLightUtils.setLightData(query, document.get("content"), 20);
			/**将查询结果高亮结束***************************************************************************/
			Article temp = new Article();
			temp = (Article) Document2ObjectUtils.document2Object(temp, document);
			temp.setTitle(title);
			articleList.add(temp);
		}
		for (Article article : articleList) {
			System.out.println(article);
		}
		indexSearcher.close();
	}
}
