package game.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import game.controller.Controller;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class firstMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3163963101378102755L;
	private JPanel contentPane;
	Controller ct = new Controller();


	// 초기 화면 구성 ( 생성자 ) 
	public firstMenu() {
		setResizable(false);
		// 프로그램 최상단 바 이름 설정 "유희왕"
		setTitle("\uC720\uD76C\uC655");

		// 프로그램 좌 상단 및 기본 모양 이미지 설정
		setIconImage(Toolkit.getDefaultToolkit().getImage(firstMenu.class.getResource("/game/image/mainImage/mainImage.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 559);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// 버튼 및 폰트, 위치 조절
		JButton btnNewButton = new JButton("\uAC8C\uC784 \uC2DC\uC791");
		btnNewButton.setFont(new Font("나눔고딕", Font.BOLD, 16));
		btnNewButton.setBounds(278, 355, 152, 42);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("\uC774\uC5B4\uC11C \uD558\uAE30");
		button.setFont(new Font("나눔고딕", Font.BOLD, 16));
		button.setBounds(278, 396, 152, 42);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\uAC8C\uC784 \uC885\uB8CC");
		button_1.setForeground(Color.RED);
		button_1.setFont(new Font("나눔고딕", Font.BOLD, 16));
		button_1.setBounds(278, 436, 152, 42);
		contentPane.add(button_1);
		
		JLabel label = new JLabel("");
		// 배경 이미지 설장
		Image img = new ImageIcon(this.getClass().getResource("/game/image/mainImage/mainImage.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(12, 10, 713, 413);
		contentPane.add(label);
		
		// 인식된 버튼에 따라서 반복문 이동
		ActionListener e = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnNewButton) {
					remove(contentPane);
					// 게임 시작을 눌렀을 경우 startFrame() 메서드 호출
					startFrame();
					setVisible(false);
				}else if(e.getSource() == button) { 
					setVisible(false);
					ContienueFrame();
				}else {
					System.out.printf("게임 종료");
					System.exit(0);
				}
			}
		};	
		
		// 버튼 인식
		btnNewButton.addActionListener(e);
		button.addActionListener(e);
		button_1.addActionListener(e);
	}
	
	// StarMenu 클래스의 setMenu() 메서드 호출
	public void startFrame()  {
		StartMenu st = new StartMenu();
		st.setMenu();
		
	}
	
	public void ContienueFrame() {
		ct.gameOpen();
		gameMenu gm = new gameMenu();
		gm.mainMenu();
	}
	
	public void setMenu(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					firstMenu frame = new firstMenu();
					
					// GUI 창 생성
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
