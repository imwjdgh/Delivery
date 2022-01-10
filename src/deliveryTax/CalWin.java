package deliveryTax;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class CalWin extends JFrame{
	
	JLabel calSendLocation_name, calReceiveLocation_name, calWeight_name, calHeight_name;
	JLabel calSendLocation, calReceiveLocation, calWeight, calHeight;
	JButton deliveryName, checkRegion, price, checkHomeOut, standardWeight, standardHeight, back;
	JCheckBox calHome, calOut;
	ImageIcon home_icon, out_icon, sel_home_icon, sel_out_icon;
	JList<String> delivery, region, kindsDel, markWeight, markHeight, resPrice;
	
	Promain pm = new Promain();
	
	public CalWin() {
		setTitle("가격 비교");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		
		c.setLayout(null);
		
		Font font1 = new Font("바탕", Font.BOLD, 20);
		Font font2 = new Font("바탕", Font.BOLD, 15);
		Font font3 = new Font("바탕", Font.BOLD, 25);
		
		calSendLocation_name = new JLabel("보내는 분");
		calSendLocation = new JLabel();
		calReceiveLocation_name = new JLabel("받는 분");
		calReceiveLocation = new JLabel();
		
		c.add(calSendLocation_name);
		c.add(calReceiveLocation_name);
		c.add(calSendLocation);
		c.add(calReceiveLocation);
		
		calWeight_name = new JLabel("무게(g)");
		calWeight = new JLabel();
		
		calHeight_name = new JLabel("길이(cm)");
		calHeight = new JLabel();
		 
		c.add(calWeight_name);
		c.add(calHeight_name);
		c.add(calWeight);
		c.add(calHeight);
		
		home_icon = new ImageIcon("E:\\eclipse-workspace\\images/home.png");
		out_icon = new ImageIcon("E:\\eclipse-workspace\\images/out.png");
		sel_home_icon = new ImageIcon("E:\\eclipse-workspace\\images/home.png");
		sel_out_icon = new ImageIcon("E:\\eclipse-workspace\\images/out.png");
		calHome = new JCheckBox(home_icon);
		calOut = new JCheckBox(out_icon);
		calHome.setBorderPainted(true);
		calOut.setBorderPainted(true);
		calHome.setSelectedIcon(sel_home_icon);
		calOut.setSelectedIcon(sel_out_icon);
		
		c.add(calHome);
		c.add(calOut);
		
		back = new JButton("다시하기");
		
		c.add(back);
		
		deliveryName = new JButton("택배사");
		checkRegion = new JButton("타권");
		price = new JButton("가격(원)");
		checkHomeOut = new JButton("택배종류");
		standardWeight = new JButton("무게기준(kg)");
		standardHeight = new JButton("길이기준(cm)");
		
		c.add(deliveryName);
		c.add(checkRegion);
		c.add(price);
		c.add(checkHomeOut);
		c.add(standardWeight);
		c.add(standardHeight);
		
		delivery = new JList<>();
		region = new JList<>();
		kindsDel = new JList<>();
		markWeight = new JList<>();
		markHeight = new JList<>();
		resPrice = new JList<>();
				
		c.add(delivery);
		c.add(region);
		c.add(kindsDel);
		c.add(markWeight);
		c.add(markHeight);
		c.add(resPrice);
		
		calSendLocation_name.setFont(font1);
		calSendLocation.setFont(font2);
		calReceiveLocation_name.setFont(font1);
		calReceiveLocation.setFont(font2);
		
		calWeight_name.setFont(font1);
		calWeight.setFont(font2);
		calHeight_name.setFont(font1);
		calHeight.setFont(font2);
		
		delivery.setFont(font3);
		region.setFont(font3);
		kindsDel.setFont(font3);
		markWeight.setFont(font3);
		markHeight.setFont(font3);
		resPrice.setFont(font3);
		
		
		back.setFont(font1);
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Promain();
			}
		});

		calSendLocation_name.setBounds(150, 25, 150, 30);
		calSendLocation.setBounds(120, 55, 150, 30);
		calReceiveLocation_name.setBounds(450, 25, 150, 30);
		calReceiveLocation.setBounds(420, 55, 150, 30);
		
		calWeight_name.setBounds(50, 225, 200, 30);
		calWeight.setBounds(50, 255, 200, 30);
		calHeight_name.setBounds(50, 425, 200, 30);
		calHeight.setBounds(50, 455, 200, 30);
		
		calHome.setBounds(450, 225, 110, 110);
		calOut.setBounds(575, 225, 110, 110);
		
		back.setBounds(475, 425, 200, 100);
		
		deliveryName.setBounds(0, 550, 137, 50);
		checkRegion.setBounds(137, 550, 113, 50);
		checkHomeOut.setBounds(250, 550, 137, 50);
		standardWeight.setBounds(387, 550, 137, 50);
		standardHeight.setBounds(524, 550, 139, 50);
		price.setBounds(663, 550, 137, 50);
		
		delivery.setBounds(0, 600, 137, 400);
		region.setBounds(137, 600, 113, 400);
		kindsDel.setBounds(250, 600, 137, 400);
		markWeight.setBounds(387, 600, 137, 400);
		markHeight.setBounds(524, 600, 139, 400);
		resPrice.setBounds(663, 600, 137, 400);
		
		setSize(800, 1000);
		setResizable(false);
		setVisible(true);
	}
}