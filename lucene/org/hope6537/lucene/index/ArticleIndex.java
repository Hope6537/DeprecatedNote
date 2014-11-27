package org.hope6537.lucene.index;

import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriter.MaxFieldLength;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.util.Version;
import org.hope6537.bean.Article;
import org.hope6537.lucene.utils.Document2ObjectUtils;
import org.hope6537.lucene.utils.DocumentUtils;
import org.hope6537.lucene.utils.LuceneUtils;
import org.junit.Test;

/** 
 *<pre>
 *
 *</pre>
 * <p>Describe: </p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年9月26日下午6:36:09</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class ArticleIndex {

	/**
	 * <p>Describe: 添加索引对象 存入数据</p>
	 * <p>Using: </p>
	 * <p>How To Work: </p>
	 * <p>DevelopedTime: 2014年10月2日下午1:17:00 </p>
	 * <p>Author:Hope6537</p>
	 * @throws Exception
	 * @see
	 */
	@Test
	public void createIndex() throws Exception {

		/*
		 * Article article = new Article(); article.setId(1L);
		 * article.setTitle("lucene搜索引擎"); article.setContent("百度和谷歌都是好的搜索引擎");
		 */

		Article article = new Article();
		article.setId(40L);
		article.setTitle("Hope6537");
		article.setContent("Commits, asdsad views, and pull requests now highlight individual changed words instead of the entire changed section, making it easier for you to see exactly what’s been added or removed.");

		IndexWriter indexWriter = new IndexWriter(LuceneUtils.directory,
				LuceneUtils.analyzer, MaxFieldLength.LIMITED);
		Document document = Document2ObjectUtils.object2Document(article);
		document.setBoost(1000);//设置命中倍率
		indexWriter.addDocument(document);
		indexWriter.close();
	}

	@Test
	public void createIndexBatch() throws Exception {
		IndexWriter indexWriter = new IndexWriter(LuceneUtils.directory,
				LuceneUtils.analyzer, MaxFieldLength.LIMITED);
		for (int i = 0; i < 39; i++) {
			Article article = new Article();
			article.setId(0L + i);
			article.setTitle("Hope6537");
			article.setContent("Commits, compare views, and pull requests now highlight individual changed words instead of the entire changed section, making it easier for you to see exactly what’s been added or removed.");
			indexWriter.addDocument(Document2ObjectUtils.object2Document(article));
		}
		indexWriter.close();
	}

	/**
	 * 查询结果的排序
	 * 1、相同的结构，相同的关键词，得分一样
	 * 2、相同的结构，不同的关键词，得分不一样，一般来说中文较高
	 * 3、不同的结构，关键词出现的次数越多，得分越高
	 * <p>Describe: 通过关键字多重搜索</p>
	 * <p>Using: </p>
	 * <p>How To Work: </p>
	 * <p>DevelopedTime: 2014年10月2日下午1:17:12 </p>
	 * <p>Author:Hope6537</p>
	 * @throws Exception
	 * @see
	 */
	@Test
	public void searchIndex() throws Exception {
		IndexSearcher indexSearcher = new IndexSearcher(LuceneUtils.directory);
		QueryParser queryParser = new MultiFieldQueryParser(Version.LUCENE_30,
				new String[] { "title", "content" }, LuceneUtils.analyzer);
		Query query = queryParser.parse("views");//关键字
		TopDocs topDocs = indexSearcher.search(query, 100);
		ScoreDoc[] scoreDocs = topDocs.scoreDocs;
		List<Article> articleList = new ArrayList<Article>();
		for (ScoreDoc doc : scoreDocs) {
			System.out.println("相关度得分+" + doc.score);
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

	/**
	 * <p>Describe: 分页查询</p>
	 * <p>Using: </p>
	 * <p>How To Work: </p>
	 * <p>DevelopedTime: 2014年10月2日下午1:28:33 </p>
	 * <p>Author:Hope6537</p>
	 * @param firstResult 当前页的第一行在集合中的位置
	 * @param maxResult	每页显示的最大行数
	 * @throws Exception
	 * @see
	 */
	public void searchIndexDispage(int firstResult, int maxResult)
			throws Exception {
		IndexSearcher indexSearcher = new IndexSearcher(LuceneUtils.directory);
		QueryParser queryParser = new MultiFieldQueryParser(Version.LUCENE_30,
				new String[] { "title", "content" }, LuceneUtils.analyzer);
		Query query = queryParser.parse("views");
		TopDocs topDocs = indexSearcher.search(query, 100);
		ScoreDoc[] scoreDocs = topDocs.scoreDocs;
		List<Article> articleList = new ArrayList<Article>();
		for (int i = firstResult; i < maxResult + firstResult
				&& i < scoreDocs.length; i++) {
			int index = scoreDocs[i].doc;
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

	@Test
	public void testDispage() throws Exception {
		this.searchIndexDispage(10, 10);
	}

	/**
	 * <p>Describe: 在索引中匹配的数据全部删除</p>
	 * <p>Using: </p>
	 * <p>How To Work: </p>
	 * <p>DevelopedTime: 2014年10月2日下午1:17:29 </p>
	 * <p>Author:Hope6537</p>
	 * @throws Exception
	 * @see
	 */
	@Test
	public void deleteIndex() throws Exception {
		IndexWriter indexWriter = new IndexWriter(LuceneUtils.directory,
				LuceneUtils.analyzer, MaxFieldLength.LIMITED);
		Term term = new Term("title", "lucene");// 关键词对象
		indexWriter.deleteDocuments(term);// 删除以该关键字对象为主的所有索引
		indexWriter.close();
	}

	/**
	 * <p>Describe: 更新索引相匹配的数据</p>
	 * <p>Using: </p>
	 * <p>How To Work: </p>
	 * <p>DevelopedTime: 2014年10月2日下午1:17:48 </p>
	 * <p>Author:Hope6537</p>
	 * @throws Exception
	 * @see
	 */
	@Test
	public void updateIndex() throws Exception {
		IndexWriter indexWriter = new IndexWriter(LuceneUtils.directory,
				LuceneUtils.analyzer, MaxFieldLength.LIMITED);
		Term term = new Term("title", "lucene");// 关键词对象
		Article article = new Article();
		article.setId(1L);
		article.setTitle("lucene搜索引擎");
		article.setContent("修改后");
		indexWriter.updateDocument(term,
				DocumentUtils.article2Doucment(article));// 修改以该关键字对象为主的所有索引
		indexWriter.close();
	}

}
