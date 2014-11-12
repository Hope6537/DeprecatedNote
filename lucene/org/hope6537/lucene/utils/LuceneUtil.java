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

public class LuceneUtil {

	private Directory directory;
	private Analyzer analyzer;

	public LuceneUtil(Directory directory, Analyzer analyzer) {
		this.directory = directory;
		this.analyzer = analyzer;
	}

	public LuceneUtil(String path) {
		try {
			this.directory = FSDirectory.open(new File(path));
			this.analyzer = new StandardAnalyzer(Version.LUCENE_30);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public LuceneUtil() {
		this("classpath:./indexDir");
	}

	public void createIndex(Object object) throws CorruptIndexException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, IOException, IntrospectionException {
		IndexWriter indexWriter = new IndexWriter(directory, analyzer,
				MaxFieldLength.LIMITED);
		indexWriter.addDocument(DocumentUtil.object2Document(object));
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
		indexWriter.updateDocument(term, DocumentUtil.object2Document(replace));// 修改以该关键字对象为主的所有索引
		indexWriter.close();
	}

	/*public List<Object> searchIndex(String[] keys, String pattern,
			Class<? extends T> clz) throws CorruptIndexException, IOException,
			ParseException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			IntrospectionException {
		IndexSearcher indexSearcher = new IndexSearcher(directory);
		QueryParser queryParser = new MultiFieldQueryParser(Version.LUCENE_30,
				keys, LuceneUtils.analyzer);
		Query query = queryParser.parse(pattern);
		TopDocs topDocs = indexSearcher.search(query, 10);
		ScoreDoc[] scoreDocs = topDocs.scoreDocs;
		List<Article> articleList = new ArrayList<Article>();
		for (ScoreDoc doc : scoreDocs) {
			int index = doc.doc;
			Article temp = new Article();
			temp = (Article) DocumentUtil.document2Object(temp,
					indexSearcher.doc(index));
			articleList.add(temp);
		}
		for (Article article : articleList) {
			System.out.println(article);
		}
		indexSearcher.close();

	}*/

}
