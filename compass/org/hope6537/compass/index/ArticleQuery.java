package org.hope6537.compass.index;

import org.compass.core.Compass;
import org.compass.core.CompassHits;
import org.compass.core.CompassQuery;
import org.compass.core.CompassQueryBuilder;
import org.compass.core.CompassSession;
import org.compass.core.config.CompassConfiguration;
import org.hope6537.compass.bean.Article;
import org.junit.Test;

/** 
 * <p>Describe: Compass的各种查询</p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年10月4日下午12:22:16</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class ArticleQuery {
	@Test
	public void testQuery() {
		CompassConfiguration compassConfiguration = new CompassConfiguration()
				.configure();
		Compass compass = compassConfiguration.buildCompass();
		CompassSession session = compass.openSession();// 打开session域
		CompassQueryBuilder queryBulider = session.queryBuilder();
		// 范围查询queryBulider.between(arg0, arg1, arg2, arg3);
		// 通配符查询queryBulider.wildcard(arg0, arg1);
		CompassQuery compassQuery = queryBulider.matchAll();// 查询所有
		CompassHits compassHits = compassQuery.hits();
		for (int i = 0; i < compassHits.length(); i++) {
			Article article = (Article) compassHits.data(i);
			System.out.println(article);
		}

	}

}
