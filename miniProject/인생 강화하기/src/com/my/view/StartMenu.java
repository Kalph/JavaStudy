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
			System.out.println("*      인생 강화하기             * ");
			for(int i=0; i<2; i++) {
				System.out.println("*                      *");
			}
			System.out.println(" ======================");
			
			System.out.println("");
			System.out.println("  ◆ 시작하기(1) \n  ◆ 이어서 하기(2) \n  ◆ 프로그램 종료(3) ");
			System.out.print("입력 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
			case 1: startMenu(); break;
			case 2: continueMenu(); break;
			case 3: System.out.println("프로그램을 종료합니다."); return;
			default: System.out.println("잘못된 입력입니다."); break;
			}
		}
	}
	
	public void mainMenu2() {
		printMenu = st.printMenu();
		System.out.println(printMenu);
//		System.out.println(st);
		while(true) {
			System.out.printf("강화 확률 : %.4f\n", (100/(double)(st.getCount()+1)));
			System.out.print("강화 하시겠습니까? ( Y / N ) : ");
			String num = sc.nextLine();
			if(num.toUpperCase().equals("Y")) {
				reinforce();
				
				if(st.getCount()==20) {
					return;
				}
				
			}else {
				System.out.print("이전 화면으로 돌아가시겠습니까?  ( Y / N ):  ");
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
		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine();
		System.out.print("시작할 레벨을 선택하십시오 (1~3) : ");
		int level = sc.nextInt();
		sc.nextLine();
		if(level < 0 || level > 3 ) {
			System.out.println("잘못된 레벨을 입력하였습니다. 다시 입력하세요.");
			startMenu();
		}
		st.setStart(name, level);
		mainMenu2();
	}
	
	public void continueMenu() {
		Basic b1 = new HighLevel();
		Basic b2 = new LowLevel();
		Basic b3 = new TopLevel();
		
		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine();
		System.out.print("코드를 입력하세요 : ");
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
			System.out.println("잘못된 코드가 입력되었습니다. 이전 화면으로 돌아갑니다.");
			return; 
		}
		
		mainMenu2();
		
	}
	
	public void reinforce() {
		if(st.judge()==1) {
			st.reinforce(1);
			System.out.println("\n\n■■■ 강화 성공! ■■■");
			
			if(st.getCount()==5) {
				System.out.println("\n코드 : Low");
			} 
			if(st.getCount()==10) {
				System.out.println("\n코드 : High");
			} 
			if(st.getCount()==15) {
				System.out.println("\n코드 : Top");
			}
			
			if(st.getCount()==20) {
				System.out.println(st);
				System.out.println("축하드립니다 모든 강화에 성공하셨습니다.");
				return;
			}
			printMenu= st.printMenu();
			System.out.println(printMenu);
		}else {
			st.reinforce(0);
			System.out.println("\n\n■■■ 강화 실패! ■■■");
			if(st.getCount()==0) {
				st.reinforce(1);
			}
			printMenu= st.printMenu();
			System.out.println(printMenu);
		}
		return;
	}
}
