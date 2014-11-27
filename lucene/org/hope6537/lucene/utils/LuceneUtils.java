package org.hope6537.lucene.utils;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.standard.StandardFilter;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class LuceneUtils {

	public static Directory directory;
	/**
	 * <p>Describe: 默认分词器，全部转小写</p>
	 * <p>Using: </p>
	 */
	public static Analyzer analyzer;

	static {
		try {
			directory = FSDirectory.open(new File("./lawIndex"));
			analyzer = new IKAnalyzer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
