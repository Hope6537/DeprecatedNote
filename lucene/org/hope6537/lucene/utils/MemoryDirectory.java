package org.hope6537.lucene.utils;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriter.MaxFieldLength;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;
import org.hope6537.bean.Article;
import org.junit.Test;

/** 
 *<pre>
 *1、能不能设置很多个索引库
 *2、索引库能不能合并起来
 *3、应用程序能不能在内存中和索引库进行交互
 *</pre>
 */
public class MemoryDirectory {

	/*
	 * 内存库 速度比较快 数据是暂时的 内存索引库和磁盘索引库的特点正好互补
	 */
	@Test
	public void testRam() throws Exception {
		Directory directory = new RAMDirectory();
		IndexWriter indexWriter = new IndexWriter(directory,
				LuceneUtils.analyzer, MaxFieldLength.LIMITED);
		Article article = new Article();
		article.setId(2L);
		article.setTitle("Hope6537");
		article.setContent("Commits, compare views, and pull requests now highlight individual changed words instead of the entire changed section, making it easier for you to see exactly what’s been added or removed.");
		indexWriter.addDocument(Document2ObjectUtils.object2Document(article));
		indexWriter.close();// 关闭io流，释放锁的资源
		this.showData(directory);
	}

	protected void showData(Directory directory) throws CorruptIndexException,
			IOException, ParseException, InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, IntrospectionException {
		IndexSearcher indexSearcher = new IndexSearcher(directory);
		QueryParser queryParser = new MultiFieldQueryParser(Version.LUCENE_30,
				new String[] { "title", "content" }, LuceneUtils.analyzer);
		org.apache.lucene.search.Query query = queryParser.parse("views");
		TopDocs docs = indexSearcher.search(query, 10);
		ScoreDoc[] scoreDocs = docs.scoreDocs;
		List<Article> articleList = new ArrayList<Article>();
		for (ScoreDoc scoreDoc : scoreDocs) {
			Document document = indexSearcher.doc(scoreDoc.doc);
			Article obj = new Article();
			articleList.add((Article) Document2ObjectUtils.document2Object(obj,
					document));
		}
		for (Article article : articleList) {
			System.out.println(article.toString());
		}
		indexSearcher.close();
	}

	/**
	 *<pre>
	 *1、当应用程序启动的时候，把文件索引库的内容复制到内存库中
	 *2、让内存索引库和应用程序交互
	 *3、把内存索引库的内容同步到文件索引库
	 *</pre>
	 */
	public void testRamAndFile(Directory d) throws Exception {
		Directory ramDirectory = new RAMDirectory(d);
		IndexWriter ramIndexWriter = new IndexWriter(ramDirectory,
				LuceneUtils.analyzer, MaxFieldLength.LIMITED);
		IndexWriter fileIndexWriter = new IndexWriter(d, LuceneUtils.analyzer,
				MaxFieldLength.LIMITED);
		/*
		 * 索引库中查询
		 */
		System.out.println("From MemoryIndex");
		this.showData(ramDirectory);
		/*
		 * 添加
		 */
		Article article = new Article();
		article.setId(2L);
		article.setTitle("Hope6537");
		article.setContent("Commits, compare views, and pull requests now highlight individual changed words instead of the entire changed section, making it easier for you to see exactly what’s been added or removed.");
		/*
		 * 插入到内存索引库中
		 */
		ramIndexWriter.addDocument(Document2ObjectUtils.object2Document(article));
		ramIndexWriter.close();
		/*
		 * 同步到文件索引库中
		 */
		fileIndexWriter.addIndexesNoOptimize(ramDirectory);
		fileIndexWriter.close();
		System.out.println("From I/OIndex");
		this.showData(d);
	}

	@Test
	public void testRamAndFile() throws Throwable {
		Directory fileDirectory = LuceneUtils.directory;
		Directory ramDirectory = new RAMDirectory(fileDirectory);
		IndexWriter ramIndexWriter = new IndexWriter(ramDirectory,
				LuceneUtils.analyzer, MaxFieldLength.LIMITED);
		IndexWriter fileIndexWriter = new IndexWriter(fileDirectory,
				LuceneUtils.analyzer, MaxFieldLength.LIMITED);
		/*
		 * 索引库中查询
		 */
		System.out.println("From MemoryIndex");
		this.showData(ramDirectory);
		/*
		 * 添加
		 */
		Article article = new Article();
		article.setId(3L);
		article.setTitle("512781864");
		article.setContent("Commits, compare views, and pull requests now highlight individual changed words instead of the entire changed section, making it easier for you to see exactly what’s been added or removed.");
		/*
		 * 插入到内存索引库中
		 */
		ramIndexWriter.addDocument(Document2ObjectUtils.object2Document(article));
		ramIndexWriter.close();
		/*
		 * 同步到文件索引库中
		 */
		fileIndexWriter.addIndexesNoOptimize(ramDirectory);
		fileIndexWriter.close();
		System.out.println("From I/OIndex");
		this.showData(fileDirectory);
	}
}
