package com.yf.erp.test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyRegin extends JFrame {

	private JPanel contentPane;
	private JTextField etAccount;
	private JLabel label_1;
	private JTextField etPwd;
	private JLabel label_2;
	private JTextField etPwd2;
	private JButton button;
	private JButton button_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyRegin frame = new MyRegin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyRegin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8D26\u53F7");
		label.setBounds(84, 52, 54, 15);
		contentPane.add(label);
		
		etAccount = new JTextField();
		etAccount.setBounds(148, 49, 158, 21);
		contentPane.add(etAccount);
		etAccount.setColumns(10);
		
		label_1 = new JLabel("\u5BC6\u7801");
		label_1.setBounds(84, 94, 54, 15);
		contentPane.add(label_1);
		
		etPwd = new JTextField();
		etPwd.setColumns(10);
		etPwd.setBounds(148, 91, 158, 21);
		contentPane.add(etPwd);
		
		label_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		label_2.setBounds(84, 139, 54, 15);
		contentPane.add(label_2);
		
		etPwd2 = new JTextField();
		etPwd2.setColumns(10);
		etPwd2.setBounds(148, 136, 158, 21);
		contentPane.add(etPwd2);
		
		button = new JButton("\u6CE8\u518C");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// ×¢²á
				String account = etAccount.getText();
				String pwd = etPwd.getText();
				String pwd2 = etPwd2.getText();
				if(account!=null){
					if(pwd!=null){
						if(pwd2!=null){
							if(pwd.equals(pwd2)){
								//Çå¿ÕÊäÈë¿ò
								etAccount.setText("");
								etPwd.setText("");
								etPwd2.setText("");
								System.out.println("Regin...");
							}
						}
						
					}
					
					
				}
				
			}
		});
		button.setBounds(84, 190, 93, 23);
		contentPane.add(button);
		
		button_1 = new JButton("\u767B\u5F55");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//µÇÂ¼
				MyRegin.this.setVisible(false);
				MyVideo video=new MyVideo();
				video.setVisible(true);
				
			}
		});
		button_1.setBounds(210, 190, 93, 23);
		contentPane.add(button_1);
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((size.width-this.getWidth())/2, (size.height-this.getHeight())/2);
	}

}
