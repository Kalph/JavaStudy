package com.my.controller;

import java.util.Arrays;

import com.my.model.vo.Basic;

public class StartController {
	public static final int SIZE = 21;
	private Basic[] ba = {new Basic(), new Basic("�����", 1), new Basic("����", 2), 	
			new Basic("���.1", 3), new Basic("���.2", 4), new Basic("���.3", 5),
			new Basic("�˹�.1", 6), new Basic("�˹�.2", 7), new Basic("�˹�.3", 8),
			new Basic("�˹�.4", 9), new Basic("������.1", 10), new Basic("������.2", 11),
			new Basic("������.3", 12), new Basic("������.4", 13), new Basic("������.5", 14),
			new Basic("CEO.1", 15), new Basic("CEO.2", 16), new Basic("CEO.3", 17),
			new Basic("��ġ��.1", 18), new Basic("��ġ��.2", 19), new Basic("�����", 20) };
	private int count=1;
	
//	private Basic[] ba = new Basic[SIZE];
//	{
//		ba[0] = new Basic(); ba[1] = new Basic("�����", 1); ba[2] = new Basic("����", 2);
//		ba[3] = new Basic("���.1", 3); ba[4] = new Basic("���.2", 4); ba[5] = new Basic("���.3", 5);
//		ba[6] = new Basic("�˹�.1", 6); ba[7] = new Basic("�˹�.2", 7); ba[8] = new Basic("�˹�.3", 8);
//		ba[9] = new Basic("�˹�.4", 9); ba[10] = new Basic("������.1", 10); ba[11] = new Basic("������.2", 11);
//		ba[12]= new Basic("������.3", 12); ba[13]= new Basic("������.4", 13); ba[14]= new Basic("������.5", 14);
//		ba[15]= new Basic("CEO.1", 15); ba[16]= new Basic("CEO.2", 16); ba[17]= new Basic("CEO.3", 17); 
//		ba[18]= new Basic("��ġ��.1", 18); ba[19]= new Basic("��ġ��.2", 19); ba[20]= new Basic("�����", 20);
//	}
	
	public void setStart(String userName, int level) {
		ba[0].setUserName(userName);
		ba[0].setLevel(level);
		count = level;
	}

	public int getCount() {
		return count;
	}


	public int judge() {
		int chk = 0;
		int result = (int)(Math.random() * (count+1)) + 0;
		
		if(count==0) {
			return 1;
		}
		
		if(result==1) {
			return 1;
		} else {
			return 0;
		}
		
	}
	
	public void reinforce(int num) {

		if(num==1) {
			count++;
//			ba[0].setLevel(count);
			return;
		}else {
			count--;
//			ba[0].setLevel(count);
			return;
		}
	}
	
	public Basic printMenu() {
		Basic ba = new Basic();
		ba=this.ba[count];
		return ba;
	}

//	public String toString() {
//		return "\n-------------\n" + "   ����� :  " + ba[0].getName() + "\n   ���� : " + 
//			ba[count].getLevel() 	+ "\n   ��ȭ ��� :  " + ba[count].getName() + "\n-------------";
//	}
	
	

}
