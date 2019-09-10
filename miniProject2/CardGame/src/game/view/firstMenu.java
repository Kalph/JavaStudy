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


	// �ʱ� ȭ�� ���� ( ������ ) 
	public firstMenu() {
		setResizable(false);
		// ���α׷� �ֻ�� �� �̸� ���� "�����"
		setTitle("\uC720\uD76C\uC655");

		// ���α׷� �� ��� �� �⺻ ��� �̹��� ����
		setIconImage(Toolkit.getDefaultToolkit().getImage(firstMenu.class.getResource("/game/image/mainImage/mainImage.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 559);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// ��ư �� ��Ʈ, ��ġ ����
		JButton btnNewButton = new JButton("\uAC8C\uC784 \uC2DC\uC791");
		btnNewButton.setFont(new Font("�������", Font.BOLD, 16));
		btnNewButton.setBounds(278, 355, 152, 42);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("\uC774\uC5B4\uC11C \uD558\uAE30");
		button.setFont(new Font("�������", Font.BOLD, 16));
		button.setBounds(278, 396, 152, 42);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\uAC8C\uC784 \uC885\uB8CC");
		button_1.setForeground(Color.RED);
		button_1.setFont(new Font("�������", Font.BOLD, 16));
		button_1.setBounds(278, 436, 152, 42);
		contentPane.add(button_1);
		
		JLabel label = new JLabel("");
		// ��� �̹��� ����
		Image img = new ImageIcon(this.getClass().getResource("/game/image/mainImage/mainImage.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(12, 10, 713, 413);
		contentPane.add(label);
		
		// �νĵ� ��ư�� ���� �ݺ��� �̵�
		ActionListener e = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnNewButton) {
					remove(contentPane);
					// ���� ������ ������ ��� startFrame() �޼��� ȣ��
					startFrame();
					setVisible(false);
				}else if(e.getSource() == button) { 
					setVisible(false);
					ContienueFrame();
				}else {
					System.out.printf("���� ����");
					System.exit(0);
				}
			}
		};	
		
		// ��ư �ν�
		btnNewButton.addActionListener(e);
		button.addActionListener(e);
		button_1.addActionListener(e);
	}
	
	// StarMenu Ŭ������ setMenu() �޼��� ȣ��
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
					
					// GUI â ����
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
