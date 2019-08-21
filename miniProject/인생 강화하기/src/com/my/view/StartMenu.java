package com.my.view;

import java.util.Scanner;

import com.my.controller.StartController;
import com.my.model.vo.Basic;
import com.my.model.vo.HighLevel;
import com.my.model.vo.LowLevel;
import com.my.model.vo.TopLevel;

public class StartMenu {
	private Scanner sc = new Scanner(System.in);
	private StartController st = new StartController();
	private Basic printMenu;
	
	public void mainMenu() {
		while(true) {
			System.out.println(" ======================");
			for(int i=0; i<2; i++) {
				System.out.println("*                      *");
			}
			System.out.println("*      �λ� ��ȭ�ϱ�             * ");
			for(int i=0; i<2; i++) {
				System.out.println("*                      *");
			}
			System.out.println(" ======================");
			
			System.out.println("");
			System.out.println("  �� �����ϱ�(1) \n  �� �̾ �ϱ�(2) \n  �� ���α׷� ����(3) ");
			System.out.print("�Է� : ");
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
			case 1: startMenu(); break;
			case 2: continueMenu(); break;
			case 3: System.out.println("���α׷��� �����մϴ�."); return;
			default: System.out.println("�߸��� �Է��Դϴ�."); break;
			}
		}
	}
	
	public void mainMenu2() {
		printMenu = st.printMenu();
		System.out.println(printMenu);
//		System.out.println(st);
		while(true) {
			System.out.printf("��ȭ Ȯ�� : %.4f\n", (100/(double)(st.getCount()+1)));
			System.out.print("��ȭ �Ͻðڽ��ϱ�? ( Y / N ) : ");
			String num = sc.nextLine();
			if(num.toUpperCase().equals("Y")) {
				reinforce();
				
				if(st.getCount()==20) {
					return;
				}
				
			}else {
				System.out.print("���� ȭ������ ���ư��ðڽ��ϱ�?  ( Y / N ):  ");
				num = sc.nextLine();
				if(num.toUpperCase().equals("Y")) {
					return;
				}else {
					continue;
				}
			}
		}
	}


	public void startMenu() {
		System.out.print("�̸��� �Է��ϼ��� : ");
		String name = sc.nextLine();
		System.out.print("������ ������ �����Ͻʽÿ� (1~3) : ");
		int level = sc.nextInt();
		sc.nextLine();
		if(level < 0 || level > 3 ) {
			System.out.println("�߸��� ������ �Է��Ͽ����ϴ�. �ٽ� �Է��ϼ���.");
			startMenu();
		}
		st.setStart(name, level);
		mainMenu2();
	}
	
	public void continueMenu() {
		Basic b1 = new HighLevel();
		Basic b2 = new LowLevel();
		Basic b3 = new TopLevel();
		
		System.out.print("�̸��� �Է��ϼ��� : ");
		String name = sc.nextLine();
		System.out.print("�ڵ带 �Է��ϼ��� : ");
		String code = sc.nextLine();
		System.out.println();
		
		if(code.equals("High")) {
			System.out.println(b1);
			st.setStart(name, 10);
		}else if(code.equals("Low")) {
			System.out.println(b2/*.toString()*/);
			st.setStart(name, 5);
		}else if(code.equals("Top")) {
			System.out.println(b3);
			st.setStart(name, 15);
		}else {
			System.out.println("�߸��� �ڵ尡 �ԷµǾ����ϴ�. ���� ȭ������ ���ư��ϴ�.");
			return; 
		}
		
		mainMenu2();
		
	}
	
	public void reinforce() {
		if(st.judge()==1) {
			st.reinforce(1);
			System.out.println("\n\n���� ��ȭ ����! ����");
			
			if(st.getCount()==5) {
				System.out.println("\n�ڵ� : Low");
			} 
			if(st.getCount()==10) {
				System.out.println("\n�ڵ� : High");
			} 
			if(st.getCount()==15) {
				System.out.println("\n�ڵ� : Top");
			}
			
			if(st.getCount()==20) {
				System.out.println(st);
				System.out.println("���ϵ帳�ϴ� ��� ��ȭ�� �����ϼ̽��ϴ�.");
				return;
			}
			printMenu= st.printMenu();
			System.out.println(printMenu);
		}else {
			st.reinforce(0);
			System.out.println("\n\n���� ��ȭ ����! ����");
			if(st.getCount()==0) {
				st.reinforce(1);
			}
			printMenu= st.printMenu();
			System.out.println(printMenu);
		}
		return;
	}
}
