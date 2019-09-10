package game.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import game.controller.Controller;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JLabel;

public class StartMenu extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5240735992845750019L;
	// º¯¼ö »ý¼º
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	
	private JButton btnNewButton_1;
	Controller ct = new Controller();
	gameMenu gm = new gameMenu();
	

	public StartMenu() {
		
		// ÇÁ·Î±×·¥ ÁÂ »ó´Ü ¹× ±âº» ¸ð¾ç ÀÌ¹ÌÁö ¼³Á¤
		setIconImage(Toolkit.getDefaultToolkit().getImage(StartMenu.class.getResource("/game/image/mainImage/mainImage.jpg")));
		setTitle("\uAC8C\uC784 \uC2DC\uC791");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 938, 580);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// ¹öÆ° »ý¼º ¹× ÆùÆ® ¼³Á¤
		JButton btnNewButton = new JButton("\uC720\uD76C");
		btnNewButton.setFont(new Font("³ª´®°íµñ", Font.BOLD, 18));
		btnNewButton.setBounds(73, 327, 104, 43);
		contentPane.add(btnNewButton);
		
		// ÅØ½ºÆ® ¹× ÆùÆ® ¼³Á¤
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("³ª´®°íµñ", Font.BOLD, 12));
		textField.setText("\uBC11\uC7A5 \uBE7C\uAE30\uC758 \uC7A5\uC778");
		textField.setBounds(73, 245, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("³ª´®°íµñ", Font.BOLD, 12));
		textField_1.setText("\uD48D\uBD80\uD55C \uC0DD\uBA85\uB825");
		textField_1.setBounds(279, 245, 116, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setFont(new Font("³ª´®°íµñ", Font.BOLD, 12));
		textField_2.setText("\uC58D\uC0BD\uC774");
		textField_2.setBounds(508, 245, 116, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setFont(new Font("³ª´®°íµñ", Font.BOLD, 12));
		textField_3.setText("cheet");
		textField_3.setBounds(722, 245, 116, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		// ¹öÆ° »ý¼º ¹× ÆùÆ® ¼³Á¤
		JButton button = new JButton("\uC870\uC774");
		button.setFont(new Font("³ª´®°íµñ", Font.BOLD, 18));
		button.setBounds(291, 327, 104, 43);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\uCE74\uC774\uBC14");
		button_1.setFont(new Font("³ª´®°íµñ", Font.BOLD, 18));
		button_1.setBounds(508, 327, 104, 43);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\uC0AC\uAE30");
		button_2.setFont(new Font("³ª´®°íµñ", Font.BOLD, 18));
		button_2.setBounds(734, 327, 104, 43);
		contentPane.add(button_2);
		
		// ¿À·ù.
////		JLabel ImgLabel = new JLabel("");
//		Image mImg = new ImageIcon(this.getClass().getResource("/game/image/mainImage/mainImage2.jpg")).getImage();
//		label.setIcon(new ImageIcon(mImg));
//		label.setBounds(12, 10, 919, 547);
//		contentPane.add(ImgLabel);
		
		// À¯Èñ Á¶ÀÌ Ä«ÀÌ¹Ù cheet ÀÌ¹ÌÁö »ðÀÔ
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/game/image/charImage/yuhi.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(22, 55, 222, 180);
		contentPane.add(lblNewLabel);
		
		label = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/game/image/charImage/joi.jpg")).getImage();
		label.setIcon(new ImageIcon(img2));
		label.setBounds(237, 55, 222, 180);
		contentPane.add(label);
		
		label_1 = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/game/image/charImage/kaibar.jpg")).getImage();
		label_1.setIcon(new ImageIcon(img3));
		label_1.setBounds(458, 55, 222, 180);
		contentPane.add(label_1);
		
		label_2 = new JLabel("");
		Image img4 = new ImageIcon(this.getClass().getResource("/game/image/charImage/cheet.jpg")).getImage();
		label_2.setIcon(new ImageIcon(img4));
		label_2.setBounds(679, 55, 222, 180);
		contentPane.add(label_2);
		

		// ÅØ½ºÆ® ¼³Á¤
		textField_4 = new JTextField();
		textField_4.setFont(new Font("³ª´®°íµñ", Font.BOLD, 14));
		textField_4.setEditable(false);
		textField_4.setText("\uBC11\uC7A5 \uBE7C\uAE30 \uB2A5\uB825\uC744 \uC18C\uC720 ");
		textField_4.setBounds(22, 276, 212, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("³ª´®°íµñ", Font.BOLD, 14));
		textField_5.setText("15000ÀÇ »ý¸í·Â");
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(246, 276, 200, 21);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("³ª´®°íµñ", Font.BOLD, 14));
		textField_6.setEditable(false);
		textField_6.setText("\uBC18\uC758 \uD655\uB960\uB85C \uACE0\uC720 \uCE74\uB4DC\uB97C \uB4DC\uB85C\uC6B0");
		textField_6.setColumns(10);
		textField_6.setBounds(458, 276, 222, 21);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("³ª´®°íµñ", Font.BOLD, 14));
		textField_7.setEditable(false);
		textField_7.setText("\uAC00\uC7A5 \uAC15\uB825\uD55C \uCE74\uB4DC\uB97C \uB4DC\uB85C\uC6B0\uD55C\uB2E4");
		textField_7.setColumns(10);
		textField_7.setBounds(692, 276, 209, 21);
		contentPane.add(textField_7);
		
		// ¼±ÅÃÇÑ Ä³¸¯ÅÍ¿¡ µû¶ó ¸Þ¼­µå È£Ãâ
		ActionListener e = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnNewButton) {
					setVisible(false);
					ct.player(1);
					gm.mainMenu();
				}else if(e.getSource() == button) { 
					setVisible(false);
					ct.player(2);
					gm.mainMenu();
				}else if(e.getSource() == button_1){
					setVisible(false);
					ct.player(3);
					gm.mainMenu();
				}else {
					setVisible(false);
					ct.player(4);
					gm.mainMenu();
				}
			}
		};	
		
		btnNewButton.addActionListener(e);
		button.addActionListener(e);
		button_1.addActionListener(e);
		button_2.addActionListener(e);
	}

	public void setMenu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartMenu frame = new StartMenu();
					
					// GUI Ã¢ »ý¼º
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
