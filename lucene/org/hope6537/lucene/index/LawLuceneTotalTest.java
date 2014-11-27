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
import org.hope6537.bean.Law;
import org.hope6537.lucene.highlight.HighLightUtils;
import org.hope6537.lucene.utils.Document2ObjectUtils;
import org.hope6537.lucene.utils.DocumentUtils;
import org.hope6537.lucene.utils.LuceneUtils;
import org.junit.Test;

public class LawLuceneTotalTest {

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

		Law law = new Law();
		law.setTitle("道路法律顾问");
		law.setContent("设置道路建设时的法律问题如下");
		IndexWriter indexWriter = new IndexWriter(LuceneUtils.directory,
				LuceneUtils.analyzer, MaxFieldLength.LIMITED);
		Document document = DocumentUtils.law2Document(law);
		document.setBoost(1000);// 设置命中倍率
		indexWriter.addDocument(document);
		indexWriter.close();
	}

	@Test
	public void createIndexBatch() throws Exception {
		IndexWriter indexWriter = new IndexWriter(LuceneUtils.directory,
				LuceneUtils.analyzer, MaxFieldLength.LIMITED);
		/*
		 * for (int i = 0; i < 2; i++) { Law law = new Law();
		 * law.setTitle("学校法律顾问"); law.setContent("设置学校管理的法律问题如下");
		 * indexWriter.addDocument(DocumentUtils.law2Document(law)); } for (int
		 * i = 0; i < 2; i++) { Law law = new Law(); law.setTitle("网站法律顾问");
		 * law.setContent("设置网站上线的法律问题如下");
		 * indexWriter.addDocument(DocumentUtils.law2Document(law)); } for (int
		 * i = 0; i < 2; i++) { Law law = new Law(); law.setTitle("汽车法律顾问");
		 * law.setContent("设置汽车上路的法律问题如下");
		 * indexWriter.addDocument(DocumentUtils.law2Document(law)); }
		 */
		for (int i = 0; i < 2; i++) {
			Law law = new Law();
			law.setTitle("道路法律顾问");
			law.setContent("设置道路建设时的法律问题如下");
			indexWriter.addDocument(DocumentUtils.law2Document(law));
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
		Query query = queryParser.parse("道路");// 关键字
		TopDocs topDocs = indexSearcher.search(query, 100);
		ScoreDoc[] scoreDocs = topDocs.scoreDocs;
		List<Law> laws = new ArrayList<Law>();
		for (ScoreDoc doc : scoreDocs) {
			// System.out.println("相关度得分+" + doc.score);
			int index = doc.doc;
			Document document = indexSearcher.doc(index);
			String title = HighLightUtils.setLightData(query,
					document.get("title"), 20);
			Law temp = (Law) DocumentUtils.document2Law(document);
			temp.setTitle(title);
			laws.add(temp);
		}
		for (Law law : laws) {
			System.out.println(law.toString());
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
		Query query = queryParser.parse("道路");// 关键字
		TopDocs topDocs = indexSearcher.search(query, 100);
		ScoreDoc[] scoreDocs = topDocs.scoreDocs;
		List<Law> laws = new ArrayList<Law>();
		for (int i = firstResult; i < maxResult + firstResult
				&& i < scoreDocs.length; i++) {
			int index = scoreDocs[i].doc;
			// 在这里进行高亮 例子是将title进行高亮
			Document document = indexSearcher.doc(index);
			String title = HighLightUtils.setLightData(query,
					document.get("title"), 20);
			Law temp = (Law) DocumentUtils.document2Law(document);
			temp.setTitle(title);
			laws.add(temp);
		}
		for (Law law : laws) {
			System.out.println(law.toString());
		}
		indexSearcher.close();
	}

	@Test
	public void testDispage() throws Exception {
		this.searchIndexDispage(0, 10);
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
