package org.hope6537.lucene.query;

import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.index.Term;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.NumericRangeQuery;
import org.apache.lucene.search.PhraseQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.WildcardQuery;
import org.hope6537.bean.Article;
import org.hope6537.lucene.utils.Document2ObjectUtils;
import org.hope6537.lucene.utils.LuceneUtils;
import org.junit.Test;

/** 
 *<pre>
 *Lucene查询
 *1、关键词查询
 *2、查询所有文档
 *3、范围查询
 *4、通配符查询 重要 用到最多的
 *5、短语查询
 *6、布尔查询
 *</pre>
 * <p>Describe: </p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年10月2日下午1:39:52</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class QueryTest {

	/**
	 * <p>Describe: 关键词查询</p>
	 * <p>Using: 因为没有分词器 所以无法区分大小写 自动将大写转为小写 所以都小写写吧关键字吧</p>
	 * <p>How To Work: </p>
	 * <p>DevelopedTime: 2014年10月2日下午1:42:59 </p>
	 * <p>Author:Hope6537</p>
	 * @see
	 */
	@Test
	public void TermQuery() {
		Term fld = new Term("title", "hope6537");
		Query query = new TermQuery(fld);
		try {
			showData(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 全部查询
	 * <p>Describe: 查询所有的文档</p>
	 * <p>Using: </p>
	 * <p>How To Work: </p>
	 * <p>DevelopedTime: 2014年10月2日下午1:49:22 </p>
	 * <p>Author:Hope6537</p>
	 * @throws Exception
	 * @see
	 */
	@Test
	public void allDocQuery() {
		Query query = new MatchAllDocsQuery();
		try {
			showData(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * <p>Describe: 通配符查询</p>
	 * <p>Using: *任意多个任意字符 ?代表一个任意字符</p>
	 * <p>How To Work: </p>
	 * <p>DevelopedTime: 2014年10月2日下午1:51:11 </p>
	 * <p>Author:Hope6537</p>
	 * @see
	 */
	@Test
	public void wildCartQuery() {
		Term term = new Term("title", "Hope6537");
		Query query = new WildcardQuery(term);
		try {
			this.showData(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * <p>Describe: 短语查询</p>
	 * <p>Using: </p>
	 * <p>How To Work: </p>
	 * <p>DevelopedTime: 2014年10月2日下午2:01:23 </p>
	 * <p>Author:Hope6537</p>
	 * @see
	 * 所有的关键词对象 必须针对同一个属性 真是鸡肋
	 * java.lang.IllegalArgumentException: All phrase terms must be in the same field: content:views
	 * 还需要限定分词后的位置position
	 * add(Term term, int position)
	 */
	@Test
	public void pharseQuery() {
		Term term = new Term("content", "hope6537");
		Term term2 = new Term("content", "views");
		PhraseQuery query = new PhraseQuery();
		query.add(term);
		query.add(term2, 2);
		try {
			showData(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * <p>Describe: 布尔查询</p>
	 * <p>Using: 几个查询的组合</p>
	 * <p>How To Work: </p>
	 * <p>DevelopedTime: 2014年10月2日下午2:05:45 </p>
	 * <p>Author:Hope6537</p>
	 * @see
	 */
	@Test
	public void booleanQuery() {
		Term term = new Term("title", "hope6537");
		BooleanQuery booleanQuery = new BooleanQuery();
		TermQuery query = new TermQuery(term);
		booleanQuery.add(query, Occur.MUST);// 必须有当前Term条件 &&
		// booleanQuery.add(query,Occur.MUST_NOT);//必须没有; !
		// booleanQuery.add(query,Occur.SHOULD);//可有可无 或的关系 ||
		try {
			this.showData(booleanQuery);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * <p>Describe: 范围查询</p>
	 * <p>Using: 在进行范围数字类型的时候需要转换</p>
	 * <p>How To Work: 
	 * 	// NumericUtils.longToPrefixCoded(id); id --> document对象的时候
	 *	// NumericUtils.prefixCodedToLong(document.get("id"));
	 *	// document对象转换为具体对象的时候才可用
	 * <p>DevelopedTime: 2014年10月2日下午2:27:50 </p>
	 * <p>Author:Hope6537</p>
	 * @see
	 */
	@Test
	public void rangeQuery() {
		Query query = NumericRangeQuery.newLongRange("id", 5L, 10L, true, true);

		try {
			this.showData(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void showData(Query query) throws Exception {
		IndexSearcher indexSearcher = new IndexSearcher(LuceneUtils.directory);
		TopDocs topDocs = indexSearcher.search(query, 10);
		ScoreDoc[] scoreDocs = topDocs.scoreDocs;
		System.out.println("Hits : " + topDocs.totalHits);
		List<Article> articleList = new ArrayList<Article>();
		for (ScoreDoc doc : scoreDocs) {
			int index = doc.doc;
			Article temp = new Article();
			temp = (Article) Document2ObjectUtils.document2Object(temp,
					indexSearcher.doc(index));
			articleList.add(temp);
		}
		for (Article article : articleList) {
			System.out.println(article);
		}
		indexSearcher.close();
	}

}
