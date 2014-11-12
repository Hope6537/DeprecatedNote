package org.hope6537.design.proxy.field;

import org.hope6537.design.proxy.normal.GamePlayerProxy;

public class GamePlayer implements IGamePlayer {

	private IGamePlayer proxy = null;

	private String name = "";

	public GamePlayer(String name) {
		super();
		this.name = name;
	}

	private boolean isProxy() {
		if (proxy == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void login(String username, String password) {
		if (isProxy()) {
			System.out.println(name + " Login");
		} else {
			System.err.println("Using Proxy Please");
		}
	}

	@Override
	public void killBoss() {
		if (isProxy()) {
			System.out.println(name + " killBoss");
		} else {
			System.err.println("Using Proxy Please");
		}
	}

	@Override
	public void upgrade() {
		if (isProxy()) {
			System.out.println(name + " upgrade");
		} else {
			System.err.println("Using Proxy Please");
		}
	}

	@Override
	public IGamePlayer getProxy() {
		this.proxy = new org.hope6537.design.proxy.field.GamePlayerProxy(this);
		return this.proxy;
	}

}
