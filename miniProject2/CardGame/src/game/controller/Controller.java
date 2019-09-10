package game.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JOptionPane;

import game.model.dao.GameDao;
import game.model.vo.player;
import game.model.vo.card;
import game.model.vo.com;

public class Controller {
	
	GameDao gd = new GameDao();
	com c = new com();
	player p = new player();
	
	private int yuS = 0;
	private int kaS = 0;
	private int joS = 0;
	private int chS = 0;
	
	
	private int cLife = c.getLifePoint();
	private static int count;
	private static int pLife;
	private static int setP;
	
	private static ArrayList<player> p1 = new ArrayList<player>();
	private TreeMap<String, card> p3 = new TreeMap<>();
	
	{
		p3.put("0",new card("cheet",4000));
		p3.put("1",new card("blueEyesDragon",3000));
		p3.put("2",new card("blackmagician",2500));
		p3.put("3",new card("DevilGuy",600));
		p3.put("4",new card("dragonD-end",3000));
		p3.put("5",new card("Exodia",1000));
		p3.put("6",new card("gigantess",1900));
		p3.put("7",new card("guardPenguin",0));
		p3.put("8",new card("MagicalBreaker",1600));
		p3.put("9",new card("redEyesDragon",2400));
		
	}
	

	public void player(int player) {
		// 트리맵으로 객체 할당. 
		switch (player) {
		case 1:
			p1.add(new player(4000,1));
			System.out.println("유희를 선택하셨습니다.");
			count=1;

			p.setLifeP(p1.get(0).getLifeP());
			pLife = p.getLifeP();
			break;
		case 2:
			p1.add(new player(15000,2));
			System.out.println("조이를 선택하셨습니다.");
			count=2;
			
			p.setLifeP(p1.get(0).getLifeP());
			pLife = p.getLifeP();
			System.out.println(pLife);
			break;
		case 3:
			p1.add(new player(4000,3));
			System.out.println("카이바를 선택하셨습니다.");
			count=3;
			
			p.setLifeP(p1.get(0).getLifeP());
			pLife = p.getLifeP();
			break;
		case 4:
			p1.add(new player(99999,4));
			System.out.println("치트를 선택하셨습니다.");
			count=4;
			
			p.setLifeP(p1.get(0).getLifeP());
			System.out.println(p.getLifeP());
			pLife = p.getLifeP();
			break;
		}
	}

	public int getClife() {
		return cLife;
	}
	
	
	public int getPlife() {
		return pLife;
	}
	
	public int getCount() {
		return count;
	}
	
	public void yuhiSkill() {
		yuS=1;
	}
	
	public void joiSkill() {
		joS=1;
	}
	
	public void kaibarSkill() {
		kaS=1;
	}
	
	public void cheetSkill() {
		chS=1;
	}

	
	// 컴퓨터 카드 인식 및 공격력 설정
	public int setCard1(int cmg) {
		int atk=0;
		String key = null;
		
		Set<String> keySet = p3.keySet();
		Iterator<String> it = keySet.iterator();
		for(int i=0; i<=cmg; i++) {
			key = it.next();
		}
		atk = p3.get(key).getAtk();
		
		System.out.println("컴퓨터 카드의 공격력 : " +atk);
		return atk;
	}
	
	// 플레이어 카드 인식 및 공격력 설정
	public int setCard2(int cmg) {
		// 유희 스킬 구현
		if(yuS==1) {
			yuS=0;
			return 2500;
		}
		
		// 카이바 스킬 구현
		if(kaS==1) {
			kaS=0;
			int num = (int)(Math.random() * 2);
			if(num==0) {
				return 3000;
			}else {
				return 0;
			}
		}
		
		// 조이 스킬 구현 - 생명력 1000증가
		if(joS==1) {
			joS=0;
			System.out.println("생명력 늘리기");
			pLife+=1000;
		}
		
		// 사기 스킬 구현 - 4000 몬스터 드로우
		if(chS==1) {
			chS=0;
			return 4000;
		}
		
		int atk=0;
		String key = null;
		
		Set<String> keySet = p3.keySet();
		Iterator<String> it = keySet.iterator();
		for(int i=0; i<=cmg; i++) {
			key = it.next();
		}
		atk = p3.get(key).getAtk();
		
		System.out.println("플레이어 카드의 공격력 : " + atk);
		return atk;
	}
	
	// 컴퓨터와 플레이어의 카드 공격력 비교
	public void lifeChk(int car1, int car2) {
		
		System.out.println("====lifechk====");
		
		// 컴퓨터 승리 조건 및 플레이어 라이프 차감
		if(car1>car2) {
			System.out.println("컴퓨터 승리");
			int fin = car1-car2;
			// 생명력이 -로 출력되는 경우를 방지
			if((pLife-fin)<=0) {
				JOptionPane.showMessageDialog(null, "플레이어가 패배했습니다.");
				System.exit(0);
			}else {
				pLife-=fin;
				System.out.println("플레이어 현재 생존점수 : " + pLife);
			}
			
			
		// 플레이어 승리 조건 및 컴퓨터 라이프 차감
		}else if(car2>car1){
			System.out.println("플레이어 승리");
			int fin = car2-car1;
			// 생명력이 -로 출력되는 경우를 방지
			if((cLife-fin)<=0) {
				JOptionPane.showMessageDialog(null, "플레이어가 승리했습니다.");
				System.exit(0);
			}else {
				cLife-=fin;
				System.out.println("컴퓨터 현재 생존점수 : " + cLife);
			}
		}
	}
	
	public ArrayList<player> getp1(){
		return p1;
	}
	
	
	// 저장 오류?
	public void gameSave() {
		System.out.println(p1 + "를 저장합니다.");
		gd.fileSave(p1);
	}

	public void gameOpen() {
		ArrayList<player> tree = gd.fileOpen();
		if(tree != null) {
			p1=tree;
			pLife = p1.get(0).getLifeP();
			count = p1.get(0).getSkill();
		}
		
	}
}
