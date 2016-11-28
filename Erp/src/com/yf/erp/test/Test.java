package com.yf.erp.test;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Test extends JFrame{
	private static final long serialVersionUID = 1L;
	//Õº∆¨¥Ê¥¢Œª÷√
	private static  final String filePath="D:\\screen\\";
	private Robot robot;
	public Test() {
		Toolkit.getDefaultToolkit();
		setBounds(new Rectangle(500, 500));
		JButton creat= new JButton();
		creat.setText("ΩÿÕº");
		JButton stop=new JButton();
		stop.setText("Õ£÷π");
		this.add(stop);
		add(creat);
		creat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					autoTask(3000,false);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		stop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					autoTask(1000*2, true);
				} catch (Exception e1) {
					e1.printStackTrace();
				} 
			}
		});
		
		
	}
	
	
	public  void autoTask(int time,boolean isStop) throws AWTException, IOException{
		if(robot==null){
			robot=new Robot();
		}
		while (!isStop) {
			robot.delay(time);
			BufferedImage image=robot.createScreenCapture(new Rectangle(800, 800));
			String name=filePath+UUID.randomUUID().toString()+"."+"jpg";
			File file=new File(name);
			ImageIO.write(image, "jpg", file);
		}
	}
	
	
	public static void main(String[] args) {
		Test test=new Test();
		test.setVisible(true);
		test.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}

}
