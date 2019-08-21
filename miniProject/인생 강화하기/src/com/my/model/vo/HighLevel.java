package com.my.model.vo;

public class HighLevel extends Basic {
	private int highlevel = 10 ;
	
	public HighLevel() {}

	public HighLevel(String name, int level) {
		super(name);
		this.highlevel= level;
	}

	public int getLevel() {
		return highlevel;
	}

	public void setLevel(int level) {
		this.highlevel = level;
	}

	@Override
	public String toString() {
		return " [ HighLevel 코드 :  " + highlevel + "레벨 부터 시작합니다. ] ";
	}
	
	
	
	
}
