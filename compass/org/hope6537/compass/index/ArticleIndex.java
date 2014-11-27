package org.hope6537.compass.index;

import org.compass.core.Compass;
import org.compass.core.CompassHits;
import org.compass.core.CompassSession;
import org.compass.core.config.CompassConfiguration;
import org.hope6537.compass.bean.Article;
import org.junit.Test;

/** 
 * <p>Describe: 完成增删改查</p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年10月4日下午12:02:30</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class ArticleIndex {
	/**
	 *<pre>
	 * create就是往索引库中加入一条数据，不管ID值是否重复
	 * save如果id值已经存在了就覆盖，否则添加
	 *</pre>
	 * @see
	 */
	@Test
	public void createIndex() {
		CompassConfiguration compassConfiguration = new CompassConfiguration()
				.configure();
		Compass compass = compassConfiguration.buildCompass();
		CompassSession compassSession = compass.openSession();// 打开session域
		Article article = new Article();
		article.setId(1L);
		article.setTitle("hope6537");
		article.setContent("changchun unviersity jichuang team");
		compassSession.create(article);
		// 需要关闭才能提交事务
		compassSession.commit();
		compassSession.close();
	}

	@Test
	public void searchIndex() {
		CompassConfiguration compassConfiguration = new CompassConfiguration()
				.configure();
		Compass compass = compassConfiguration.buildCompass();
		CompassSession compassSession = compass.openSession();// 打开session域
		CompassHits compassHits = compassSession.find("1");
		for (int i = 0; i < compassHits.length(); i++) {
			Article article = (Article) compassHits.data(i);
			System.out.println(article);
		}
		compassSession.close();
	}

	@Test
	public void deleteIndex() {// 删除
		CompassConfiguration compassConfiguration = new CompassConfiguration()
				.configure();
		Compass compass = compassConfiguration.buildCompass();
		CompassSession compassSession = compass.openSession();// 打开session域

		Article article = (Article) compassSession.get(Article.class, 1L);
		compassSession.delete(article);
		compassSession.close();// commit
	}

	@Test
	public void updateIndex() {// 修改，使用save方法
		CompassConfiguration compassConfiguration = new CompassConfiguration()
				.configure();
		Compass compass = compassConfiguration.buildCompass();
		CompassSession compassSession = compass.openSession();// 打开session域
		Article article = new Article();
		/*
		 * article.setId(1L); article.setTitle("hope6537");
		 * article.setContent("changchun unviersity jichuang team");
		 */
		compassSession.save(article);
		// 需要关闭才能提交事务
		compassSession.commit();
		compassSession.close();
	}

}
