package org.hope6537.lucene.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriter.MaxFieldLength;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.hope6537.bean.Article;
import org.hope6537.bean.Law;
import org.hope6537.lucene.utils.DocumentUtils;
import org.junit.Test;

/** 
 * <p>Describe: Lucene测试</p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年9月26日下午2:47:44</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class LuceneTotalTest {

	/**
	 *<pre>
	 *1、创建Article对象，并且把信息存放进去
	 *2、创建一个IndexWriter，将信息放入索引中
	 *3、关闭IndexWriter
	 *</pre>
	 * <p>Describe: </p>
	 * <p>Using: </p>
	 * <p>How To Work: </p>
	 * <p>DevelopedTime: 2014年9月26日下午2:48:43 </p>
	 * <p>Author:Hope6537</p>
	 * @throws IOException 
	 * @throws CorruptIndexException 
	 * @see
	 */
	@Test
	public void testCreateIndex() throws CorruptIndexException, IOException {
		// 1
		Article article = new Article();
		article.setId(1L);
		article.setTitle("lucene搜索引擎");
		article.setContent("百度和谷歌都是好的搜索引擎");
		// 2、创建一个IndexWriter 需要3个参数
		/*
		 * 1、索引库 -- 指向索引库的位置 Directory 2、分词器 -- 指定分词器版本号 Analyzer
		 */
		Directory directory = FSDirectory.open(new File("./searchIndexDir"));
		Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_30);
		IndexWriter indexWriter = new IndexWriter(directory, analyzer,
				MaxFieldLength.LIMITED);
		// 把一个Article对象转化为Document
		Document document = new Document();
		// 设定Field
		Field idField = new Field("id", article.getId().toString(), Store.YES,
				Index.NOT_ANALYZED);
		Field titleField = new Field("title", article.getTitle().toString(),
				Store.YES, Index.ANALYZED);
		Field contextField = new Field("content", article.getContent()
				.toString(), Store.YES, Index.ANALYZED);
		document.add(idField);
		document.add(titleField);
		document.add(contextField);
		indexWriter.addDocument(document);
		// 3
		indexWriter.close();
	}

	/**
	 *<pre>
	 *1、创建一个IndexSearch对象
	 *2、调用search方法进行检索
	 *3、输出内容
	 *</pre>
	 * <p>Describe: </p>
	 * <p>Using: </p>
	 * <p>How To Work: </p>
	 * <p>DevelopedTime: 2014年9月26日下午3:25:08 </p>
	 * <p>Author:Hope6537</p>
	 * @throws IOException 
	 * @throws ParseException 
	 * @see
	 */
	@SuppressWarnings({ "unused", "resource" })
	@Test
	public void searchLaw() throws IOException, ParseException {
		Directory directory = FSDirectory.open(new File("./lawIndex"));
		IndexSearcher indexSearcher = new IndexSearcher(directory);
		Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_30);
		QueryParser queryParser = new QueryParser(Version.LUCENE_30, "title",
				analyzer);
		// 这里面放的是关键词
		Query query = queryParser.parse("网站");
		TopDocs topDocs = indexSearcher.search(query, 10);
		// 根据关键词查询出来的总的记录数
		int count = topDocs.totalHits;
		ScoreDoc[] scoreDocs = topDocs.scoreDocs;
		List<Article> articleList = new ArrayList<Article>();
		for (ScoreDoc doc : scoreDocs) {
			// 关键词得分
			float score = doc.score;
			// 索引的下标
			int index = doc.doc;
			Document document = indexSearcher.doc(index);
			Article article = new Article();
			article.setId(Long.parseLong(document.get("id")));
			article.setTitle(document.get("title"));
			article.setContent(document.get("content"));
			articleList.add(article);
		}
		for (Article article : articleList) {
			System.out.println(article);
		}
	}

	/**
	 *<pre>
	 *1、创建一个IndexSearch对象
	 *2、调用search方法进行检索
	 *3、输出内容
	 *</pre>
	 * <p>Describe: </p>
	 * <p>Using: </p>
	 * <p>How To Work: </p>
	 * <p>DevelopedTime: 2014年9月26日下午3:25:08 </p>
	 * <p>Author:Hope6537</p>
	 * @throws IOException 
	 * @throws ParseException 
	 * @see
	 */
	@SuppressWarnings({ "unused", "resource" })
	@Test
	public void searchIndex() throws IOException, ParseException {
		Directory directory = FSDirectory.open(new File("./searchIndexDir"));
		IndexSearcher indexSearcher = new IndexSearcher(directory);
		Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_30);
		QueryParser queryParser = new QueryParser(Version.LUCENE_30, "title",
				analyzer);
		// 这里面放的是关键词
		Query query = queryParser.parse("lucene");
		TopDocs topDocs = indexSearcher.search(query, 10);
		// 根据关键词查询出来的总的记录数
		int count = topDocs.totalHits;
		ScoreDoc[] scoreDocs = topDocs.scoreDocs;
		List<Article> articleList = new ArrayList<Article>();
		for (ScoreDoc doc : scoreDocs) {
			// 关键词得分
			float score = doc.score;
			// 索引的下标
			int index = doc.doc;
			Document document = indexSearcher.doc(index);
			Article article = new Article();
			article.setId(Long.parseLong(document.get("id")));
			article.setTitle(document.get("title"));
			article.setContent(document.get("content"));
			articleList.add(article);
		}
		for (Article article : articleList) {
			System.out.println(article);
		}
	}
}
