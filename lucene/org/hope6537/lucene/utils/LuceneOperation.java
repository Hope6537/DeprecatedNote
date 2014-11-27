package org.hope6537.lucene.utils;

import java.beans.IntrospectionException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.index.IndexWriter.MaxFieldLength;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.LockObtainFailedException;
import org.apache.lucene.util.Version;
import org.hope6537.bean.Article;

public class LuceneOperation {

	private Directory directory;
	private Analyzer analyzer;

	public LuceneOperation(Directory directory, Analyzer analyzer) {
		this.directory = directory;
		this.analyzer = analyzer;
	}

	public LuceneOperation(String path) {
		try {
			this.directory = FSDirectory.open(new File(path));
			this.analyzer = new StandardAnalyzer(Version.LUCENE_30);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public LuceneOperation() {
		this("classpath:./indexDir");
	}

	public void createIndex(Object object) throws CorruptIndexException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, IOException, IntrospectionException {
		IndexWriter indexWriter = new IndexWriter(directory, analyzer,
				MaxFieldLength.LIMITED);
		indexWriter.addDocument(Document2ObjectUtils.object2Document(object));
		indexWriter.close();
	}

	public void deleteIndex(String key, String pattern)
			throws CorruptIndexException, LockObtainFailedException,
			IOException {
		IndexWriter indexWriter = new IndexWriter(directory, analyzer,
				MaxFieldLength.LIMITED);
		Term term = new Term(key, pattern);// 关键词对象
		indexWriter.deleteDocuments(term);// 删除以该关键字对象为主的所有索引
		indexWriter.close();
	}

	public void updateIndex(String key, String pattern, Object replace)
			throws CorruptIndexException, LockObtainFailedException,
			IOException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, IntrospectionException {
		IndexWriter indexWriter = new IndexWriter(directory, analyzer,
				MaxFieldLength.LIMITED);
		Term term = new Term("title", "lucene");// 关键词对象
		indexWriter.updateDocument(term, Document2ObjectUtils.object2Document(replace));// 修改以该关键字对象为主的所有索引
		indexWriter.close();
	}

	public ScoreDoc[] searchIndex(String[] keys, String pattern)
			throws CorruptIndexException, IOException, ParseException,
			InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			IntrospectionException {
		IndexSearcher indexSearcher = new IndexSearcher(directory);
		QueryParser queryParser = new MultiFieldQueryParser(Version.LUCENE_30,
				keys, LuceneUtils.analyzer);
		Query query = queryParser.parse(pattern);
		TopDocs topDocs = indexSearcher.search(query, 10);
		ScoreDoc[] scoreDocs = topDocs.scoreDocs;
		/*
		 * List<> articleList = new ArrayList<clz>(); for (ScoreDoc doc :
		 * scoreDocs) { int index = doc.doc; Object temp = new Object(); temp =
		 * DocumentUtil.document2Object(temp, indexSearcher.doc(index));
		 * articleList.add(temp); }
		 */
		indexSearcher.close();
		return scoreDocs;
	}

	/**
	 * <p>Describe: 优化索引</p>
	 * <p>Using: </p>
	 * <p>How To Work: </p>
	 * <p>DevelopedTime: 2014年9月27日下午5:15:57 </p>
	 * <p>Author:Hope6537</p>
	 * @throws IOException 
	 * @throws CorruptIndexException 
	 * @see
	 */
	public void optimizeIndex(IndexWriter indexWriter, boolean isClose)
			throws CorruptIndexException, IOException {
		indexWriter.optimize();
		if (isClose) {
			indexWriter.close();
		}
	}

}
