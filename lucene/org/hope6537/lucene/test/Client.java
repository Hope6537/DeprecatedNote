package org.hope6537.lucene.test;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriter.MaxFieldLength;
import org.apache.lucene.store.LockObtainFailedException;
import org.hope6537.bean.Article;
import org.hope6537.lucene.utils.Document2ObjectUtils;
import org.hope6537.lucene.utils.LuceneOperation;
import org.hope6537.lucene.utils.LuceneUtils;
import org.junit.Test;

public class Client {

	@Test
	public void test() throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, IntrospectionException,
			CorruptIndexException, LockObtainFailedException, IOException {
		IndexWriter indexWriter = new IndexWriter(LuceneUtils.directory,
				LuceneUtils.analyzer, MaxFieldLength.LIMITED);
		indexWriter.optimize();//优化索引集
		indexWriter.close();
	}
}
