package org.hope6537.design.abstract_factory.human;

/** 
 * <p>Describe: 抽象工厂定义</p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年9月10日下午2:25:55</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public interface HumanFactory {

	public Human createYellowHuman();

	public Human createWhiteHuman();

	public Human createBlackHuman();

}
