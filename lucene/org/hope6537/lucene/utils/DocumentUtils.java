package org.hope6537.lucene.utils;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.hope6537.bean.Article;
import org.hope6537.bean.Law;

public class DocumentUtils {

	public static Document article2Doucment(Article article) {
		Document document = new Document();
		Field idField = new Field("id", article.getId().toString(), Store.YES,
				Index.NOT_ANALYZED);
		Field titleField = new Field("title", article.getTitle().toString(),
				Store.YES, Index.ANALYZED);
		Field contentField = new Field("content", article.getContent()
				.toString(), Store.YES, Index.ANALYZED);
		document.add(idField);
		document.add(titleField);
		document.add(contentField);
		return document;
	}

	public static Document law2Document(Law law) {
		Document document = new Document();
		Field titleField = new Field("title", law.getTitle().toString(),
				Store.YES, Index.ANALYZED);
		Field contentField = new Field("content", law.getContent().toString(),
				Store.YES, Index.ANALYZED);
		document.add(titleField);
		document.add(contentField);
		return document;
	}

	public static Law document2Law(Document document) {
		Law law = new Law();
		law.setTitle(document.get("title"));
		law.setContent(document.get("content"));
		return law;
	}

	public static Article document2Article(Document document) {
		Article article = new Article();
		article.setId(Long.parseLong(document.get("id")));
		article.setTitle(document.get("title"));
		article.setContent(document.get("content"));
		return article;
	}
}
