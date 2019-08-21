package com.my.model.vo;

public class TopLevel extends Basic {
	private int topLevel = 15;
	
	public TopLevel() {}

	public TopLevel(String name, int level) {
		super(name);
		this.topLevel = level;
	}

	public int getTopLevel() {
		return topLevel;
	}

	public void setTopLevel(int topLevel) {
		this.topLevel = topLevel;
	}

	@Override
	public String toString() {
		return " [ TopLevel �ڵ� :  " + topLevel + "���� ���� �����մϴ�. ] ";
	}
	
	
}
