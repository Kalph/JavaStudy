package com.my.model.vo;

public class Basic {
//	private String userId;
//	private String userPwd;
//	private String userName;
//	private int startLevel;
	
	private String userName;
	private int level;
	private String name;

	public Basic() {}

	public Basic(String name) {
		this.name = name;
	}

	public Basic(String name, int level) {
		this(name);
		this.level = level;
	}
	
	public Basic(String userName, int level, String name) {
		this(name, level);
		this.userName=userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String toString() {
		return "\n-------------\n" + "   ����� :  " + getName() + "\n   ���� : " + 
				getLevel() 	+ "\n   ��ȭ ��� :  " + getName() + "\n-------------";
	}
	
	
	
	
	
}
