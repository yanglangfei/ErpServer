package com.yf.erp.test;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MyVideo extends JFrame {
	private JPanel contentPane;
	private JTextField etAccount;
	private JTextField etPwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyVideo frame = new MyVideo();
					frame.setVisible(true);
					Point position = frame.getLocationOnScreen();
					int x = position.x;
					int y=position.y;
					System.out.println("frame position=("+x+","+y+")");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyVideo() {
		setTitle("\u767B\u5F55");
		setForeground(Color.GRAY);
		setBackground(Color.WHITE);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8D26\u53F7");
		label.setBounds(111, 53, 37, 15);
		contentPane.add(label);
		
		etAccount = new JTextField();
		etAccount.setBounds(169, 50, 150, 21);
		contentPane.add(etAccount);
		etAccount.setColumns(40);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setBounds(111, 91, 37, 15);
		contentPane.add(label_1);
		
		etPwd = new JTextField();
		etPwd.setColumns(10);
		etPwd.setBounds(169, 88, 150, 21);
		contentPane.add(etPwd);
		
		JButton btnLogin = new JButton("\u767B\u5F55");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//µÇÂ¼
				String account = etAccount.getText();
				String pwd = etPwd.getText();
				if(account!=null){
					if(pwd!=null){
						etAccount.setText("");
						etPwd.setText("");
						System.out.println("Login...");
						MyVideo.this.setVisible(false);
						JMain main=new JMain();
						main.setVisible(true);
					}
				}
			}
		});
		btnLogin.setBounds(111, 146, 93, 23);
		contentPane.add(btnLogin);
		
		JButton btnRegin = new JButton("\u6CE8\u518C");
		btnRegin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//×¢²á
				MyVideo.this.setVisible(false);
				MyRegin regin=new MyRegin();
				regin.setVisible(true);
				
			}
		});
		btnRegin.setBounds(237, 146, 93, 23);
		contentPane.add(btnRegin);
		
		JCheckBox checkBox = new JCheckBox("\u8BB0\u4F4F\u5BC6\u7801");
		checkBox.setBounds(111, 117, 103, 23);
		contentPane.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("\u81EA\u52A8\u767B\u5F55");
		checkBox_1.setBounds(249, 117, 103, 23);
		contentPane.add(checkBox_1);
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((size.width-this.getWidth())/2, (size.height-this.getHeight())/2);
	}
}
