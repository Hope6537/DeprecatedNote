package org.hope6537.springtest.aop;

import org.apache.log4j.Logger;
import org.hope6537.utils.DateFormat_Jisuan;

/** 
 * <p>Describe: 我们假定这是日志记录对象</p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年9月14日下午12:28:26</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class LoggerService implements Interceptor {

	private static Logger logger = Logger.getLogger("Spring Looger "
			+ DateFormat_Jisuan.createNowTime());

	public LoggerService() {
		if (logger == null) {
			Logger.getLogger("Spring Looger Reboot on "
					+ DateFormat_Jisuan.createNowTime());
		}
		logger.info("Logger Started!");
	}

	public Logger getLogger() {
		return logger;
	}

	@Override
	public void interceptor() {
		System.out.println("Logger");
	}
}
