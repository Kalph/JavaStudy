package com.my.model.vo;

public class LowLevel extends Basic {
	private int lowLevel = 5;
	
	public LowLevel() {}

	public LowLevel(String name, int level) {
		super(name);
		this.lowLevel = level;
	}

	public int getLowLevel() {
		return lowLevel;
	}

	public void setLowLevel(int lowLevel) {
		this.lowLevel = lowLevel;
	}

	@Override
	public String toString() {
		return " [ LowLevel �ڵ� :  " + lowLevel + "���� ���� �����մϴ�. ] ";
	}
	
	
}
