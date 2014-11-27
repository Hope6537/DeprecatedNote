/** 
 *<pre>
 *Lucene全文搜索测试教程
 *{@link org.hope6537.lucene.test.HelloWorld}
 *一、存储过程
 *1、创建一个IndexWriter
 *	1)directory -- 指向索引库的位置
 *	2)analyzer -- 录入的内容切分成关键词，放入到目录库中
 *	3)MaxFieldLength --限制字段的值的大小
 *2、indexWriter.addDocument(document);
 *	1)先把内容放到内容库中，同时分词放入到目录库
 *		1--Store向不向内容存储？ 
 *			YES 存储 NO 不存储
 *		2--Index要不要向目录库存储
 *			NO 不存储目录 NOT_ANALYZED 存储但不分词 ANALYZED 存储并分词
 * <hr>
 *二、搜索过程
 *1、创建一个IndexSearch
 *	1)Directory -- 指定索引库的位置
 *2、indexSearcher.search(query, 2); -->提取出前两条数据（匹配度排序？）
 *	1)QueryParse -- Version3.0
 *	2)field --在此字段中进行检索
 *	3)analyzer --分词的作用
 *3、该方法将返回TopDocs目录库的引用
 *	1)totalHits 总的记录数
 *	2)ScoreDoc[] doc 每个doc代表一条目录数据 有两个属性
 *		1 score 为该关键词的得分
 *		2 doc 就是所索引的正文(Content)的id
 *4、调用indexSearcher.doc(index);
 *	1)将通过doc(index)去内容库中查找内容 -- Document对象
 *	2)Document对象转换为实例 -- 例如Article
 *5、输出Article
 *</pre>
 */
package org.hope6537.lucene.test;

