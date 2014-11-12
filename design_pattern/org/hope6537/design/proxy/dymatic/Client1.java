package org.hope6537.design.proxy.dymatic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.hope6537.design.proxy.example1.IGamePlayer;
import org.hope6537.design.proxy.field.GamePlayer;
import org.junit.*;

public class Client1 {

	@Test
	public void test() {
		IGamePlayer gamePlayer = new GamePlayer("张三");
		InvocationHandler handler = new DymaticGamePlay(gamePlayer);
		ClassLoader classLoader = gamePlayer.getClass().getClassLoader();
		IGamePlayer proxy = (IGamePlayer) Proxy.newProxyInstance(classLoader,
				new Class[] { IGamePlayer.class }, handler);
		proxy.login("", "");
		proxy.killBoss();
		proxy.upgrade();
	}

}
