package game.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import game.controller.Controller;
import game.model.vo.com;
import game.model.vo.player;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

public class gameMenu extends JFrame {
	public gameMenu() {
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 3367867120800711298L;
	
	Controller ct = new Controller();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

//	public void setMenu() {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					gameMenu frame = new gameMenu();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	
	public void mainMenu(){
		
		// 이미지 모두 삽입
		Image[] cImg = new Image[13];
		cImg[0] = new ImageIcon(this.getClass().getResource("/game/image/monImage/cheet.jpg")).getImage();
		cImg[1] = new ImageIcon(this.getClass().getResource("/game/image/monImage/blueEyesDragon.jpg")).getImage();
		cImg[2] = new ImageIcon(this.getClass().getResource("/game/image/monImage/blackmagician.gif")).getImage();
		cImg[3] = new ImageIcon(this.getClass().getResource("/game/image/monImage/DevilGuy.jpg")).getImage();
		cImg[4] = new ImageIcon(this.getClass().getResource("/game/image/monImage/dragonD-end.jpg")).getImage();
		cImg[5] = new ImageIcon(this.getClass().getResource("/game/image/monImage/Exodia.jpg")).getImage();
		cImg[6] = new ImageIcon(this.getClass().getResource("/game/image/monImage/gigantess.jpg")).getImage();
		cImg[7] = new ImageIcon(this.getClass().getResource("/game/image/monImage/guardPenguin.jpg")).getImage();
		cImg[8] = new ImageIcon(this.getClass().getResource("/game/image/monImage/MagicalBreaker.jpg")).getImage();
		cImg[9] = new ImageIcon(this.getClass().getResource("/game/image/monImage/redEyesDragon.jpg")).getImage();
		

		// 랜덤 함수 설정
		// 배경 색 설정
		setBackground(Color.BLACK);
		
		// 프로그램 좌 상단 및 기본 모양 이미지 설정
		setIconImage(Toolkit.getDefaultToolkit().getImage(StartMenu.class.getResource("/game/image/mainImage/mainImage.jpg")));
		setTitle("\uAC8C\uC784 \uC2DC\uC791");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 938, 580);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		int num1 = (int)(Math.random() * 9) +1;
		int num2 = (int)(Math.random() * 9) +1;
		
		Image cmg = cImg[num1];
		Image cmg2 =cImg[num2];
		
		// 위 카드
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(cmg));
		label_4.setBounds(331, 32, 186, 187);
		contentPane.add(label_4);
		
		
		// 아래 카드
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(cmg2));
		label_1.setBounds(331, 275, 186, 187);
		contentPane.add(label_1);
		
		// 캐릭터 스킬 구분
		int car1 = ct.setCard1(num1);
		int car2 = ct.setCard2(num2);
		
		if(car2==2500){
			label_1.setIcon(new ImageIcon(cImg[2]));
			label_1.setBounds(331, 275, 186, 187);
			contentPane.add(label_1);
		}else if(car2==3000) {
			label_1.setIcon(new ImageIcon(cImg[1]));
			label_1.setBounds(331, 275, 186, 187);
			contentPane.add(label_1);
		}else if(car2 == 4000){
			label_1.setIcon(new ImageIcon(cImg[0]));
			label_1.setBounds(331, 275, 186, 187);
			contentPane.add(label_1);
		}
		
		ct.lifeChk(car1,car2);
		

		String data = "\uC0DD\uC874\uC810\uC218 : " + ct.getPlife();
		String data2 = "\uC0DD\uC874\uC810\uC218 : " + ct.getClife();
		
		textField = new JTextField();
		textField.setFont(new Font("나눔고딕", Font.PLAIN, 13));
		textField.setEditable(false);
		textField.setText(data2);
		textField.setBounds(45, 94, 116, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("나눔고딕", Font.PLAIN, 13));
		textField_1.setEditable(false);
		textField_1.setText(data);
		textField_1.setBounds(733, 333, 126, 43);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("\uC2A4\uD0AC \uC0AC\uC6A9");
		button.setFont(new Font("나눔고딕", Font.BOLD, 14));
		button.setBounds(45, 303, 116, 43);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\uB2E4\uC74C \uAC8C\uC784");
		button_1.setFont(new Font("나눔고딕", Font.BOLD, 12));
		button_1.setBounds(704, 393, 97, 23);
		contentPane.add(button_1);
				
		JButton button_2 = new JButton("\uAC8C\uC784 \uC800\uC7A5");
		button_2.setFont(new Font("나눔고딕", Font.BOLD, 14));
		button_2.setBounds(748, 32, 130, 23);
		contentPane.add(button_2);
		
		JLabel label = new JLabel("");
		label.setBackground(Color.BLACK);
		Image img = new ImageIcon(this.getClass().getResource("/game/image/mainImage/mainImage.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(111, 52, 713, 413);
		contentPane.add(label);
		
		setVisible(true);
		
		ActionListener e = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button) {
					if(ct.getCount()==1) {
						System.out.println("유희 스킬 사용");
						ct.yuhiSkill();
					}else if(ct.getCount()==2) {
						System.out.println("조이 스킬 사용");
						ct.joiSkill();
					}else if(ct.getCount()==3) {
						System.out.println("카이바 스킬 사용");
						ct.kaibarSkill();
					}else {
						System.out.println("사기 스킬 사용");
						ct.cheetSkill();
					}
				}else if(e.getSource() == button_1) {
					setVisible(false);
					mainMenu();
				}else {
					ct.gameSave();
				}
			}
		};		
		
		button.addActionListener(e);
		button_1.addActionListener(e);
		button_2.addActionListener(e);
		
	}
}
