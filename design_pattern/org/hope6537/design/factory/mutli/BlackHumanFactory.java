package org.hope6537.design.factory.mutli;

import org.hope6537.design.factory.human.BlackHuman;
import org.hope6537.design.factory.human.Human;

/** 
 * <p>Describe: 人种的创建工厂实现</p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年9月9日下午2:34:46</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class BlackHumanFactory extends AbstractHumanFactory {

	@Override
	public Human createHuman() {
		return new BlackHuman();
	}

}
