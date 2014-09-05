package org.hope6537.design.factory.human;

public class HumanFactory extends AbstractHumanFactory {

	/* (non-Javadoc)
	 * @see org.hope6537.design.classicfactory.AbstractHumanFactory#createHuman(java.lang.Class)
	 * @Change:Hope6537
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Human> T createHuman(Class<T> cls) {

		Human human = null;

		try {
			human = (T) Class.forName(cls.getName()).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (T) human;
	}
}
