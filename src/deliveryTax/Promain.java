package deliveryTax;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.*;

public class Promain extends JFrame {

	String[] location = {"서울", "인천", "경기",
			"부산", "울산", "경남",
			"대전", "세종", "충남",
			"충북",
			"광주", "전남",
			"대구", "경북",
			"전북",
			"강원",
	"제주"};

	Tax ta = new Tax();
	VisitTax vta = new VisitTax();

	JCheckBox home, out;
	JComboBox<String> sendLocation, receiveLocation;
	JTextField weight, height;
	Boolean bolHome = false;
	Boolean bolOut = false;

	Vector<String> name = new Vector<>();
	Vector<String> compareLoc= new Vector<>();
	Vector<String> collectDel = new Vector<>();
	Vector<String> standardWeight = new Vector<>();
	Vector<String> standardHeight = new Vector<>();
	Vector<String> cost = new Vector<>();

	public Promain() {
		Container c = getContentPane();

		JLabel sendLocation_name, receiveLocation_name, weight_name, height_name;
		ImageIcon home_icon, out_icon, sel_home_icon, sel_out_icon;
		JButton cal;

		Font font1 = new Font("바탕", Font.BOLD, 20);
		Font font2 = new Font("바탕", Font.BOLD, 15);

		sendLocation_name = new JLabel("보내는 분");
		sendLocation = new JComboBox<String>(location);
		receiveLocation_name = new JLabel("받는 분");
		receiveLocation = new JComboBox<String>(location);

		c.add(sendLocation_name);
		c.add(receiveLocation_name);
		c.add(sendLocation);
		c.add(receiveLocation);

		weight_name = new JLabel("무게(g)");
		weight = new JTextField(4);
		height_name = new JLabel("길이(cm)");
		height = new JTextField("가로 + 세로 + 높이", 4);

		c.add(weight_name);
		c.add(height_name);
		c.add(weight);
		c.add(height);

		home_icon = new ImageIcon("E:\\eclipse-workspace\\images/home.png");
		out_icon = new ImageIcon("E:\\eclipse-workspace\\images/out.png");
		sel_home_icon = new ImageIcon("E:\\eclipse-workspace\\images/home.png");
		sel_out_icon = new ImageIcon("E:\\eclipse-workspace\\images/out.png");
		home = new JCheckBox(home_icon);
		out = new JCheckBox(out_icon);
		home.setBorderPainted(true);
		out.setBorderPainted(true);
		home.setSelectedIcon(sel_home_icon);
		out.setSelectedIcon(sel_out_icon);

		home.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					bolHome = true;
				} else {
					bolHome = false;
				}
			}
		});

		out.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					bolOut = true;
				} else {
					bolOut = false;
				}
			}
		});

		c.add(home);
		c.add(out);

		cal = new JButton("계산");

		c.add(cal);

		sendLocation_name.setFont(font1);
		sendLocation.setFont(font2);
		receiveLocation_name.setFont(font1);
		receiveLocation.setFont(font2);

		weight_name.setFont(font1);
		weight.setFont(font2);
		height_name.setFont(font1);
		height.setFont(font2);

		cal.setFont(font1);
		cal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				CalWin cw = new CalWin();

				cw.calSendLocation.setText(getSendLocation());
				cw.calReceiveLocation.setText(getReceiveLocation());

				cw.calWeight.setText(getWeight());
				cw.calHeight.setText(getHeight1());

				cw.calHome.setSelected(homeCheckbox());
				cw.calOut.setSelected(outCheckbox());

				if(homeCheckbox()) {
					if(Integer.parseInt(getHeight1()) > 160) {

					}else {
						if(Integer.parseInt(getWeight()) > 30000) {

						}
						if((25000 <= Integer.parseInt(getWeight()) && Integer.parseInt(getWeight()) <= 30000) || Integer.parseInt(getWeight()) <= 30000) {
							cw.delivery.setListData(postDName());
							cw.region.setListData(postDSame());
							cw.kindsDel.setListData(postDKinds());
							cw.markWeight.setListData(postDMarkWeight());
							cw.markHeight.setListData(postDMarkHeight());
						}
						if((20000 <= Integer.parseInt(getWeight()) && Integer.parseInt(getWeight()) <= 25000) || Integer.parseInt(getWeight()) <= 25000) {
							cw.delivery.setListData(kakaoDName());
							cw.region.setListData(kakaoDSame());
							cw.kindsDel.setListData(kakaoDKinds());
							cw.markWeight.setListData(kakaoDMarkWeight());
							cw.markHeight.setListData(kakaoDMarkHeight());

							cw.delivery.setListData(cjDName());
							cw.region.setListData(cjDSame());
							cw.kindsDel.setListData(cjDKinds());
							cw.markWeight.setListData(cjDMarkWeight());
							cw.markHeight.setListData(cjDMarkHeight());
						}
						if(Integer.parseInt(getWeight()) <= 20000) {
							cw.delivery.setListData(hanjinDName());
							cw.region.setListData(hanjinDSame());
							cw.kindsDel.setListData(hanjinDKinds());
							cw.markWeight.setListData(hanjinDMarkWeight());
							cw.markHeight.setListData(hanjinDMarkHeight());
						}

						if(sameLocation()) {
							if(Integer.parseInt(getWeight()) > 30000) {

							}
							if((25000 <= Integer.parseInt(getWeight()) && Integer.parseInt(getWeight()) <= 30000) || Integer.parseInt(getWeight()) <= 30000) {
								cw.resPrice.setListData(postDPrice());
							}
							if((20000 <= Integer.parseInt(getWeight()) && Integer.parseInt(getWeight()) <= 25000) || Integer.parseInt(getWeight()) <= 25000) {
								cw.resPrice.setListData(kakaoDPrice());
								cw.resPrice.setListData(cjDPrice());
							}
							if(Integer.parseInt(getWeight()) <= 20000) {
								cw.resPrice.setListData(hanjinDPrice());
							}
						}
						else if(getSendLocation() == "제주" || getReceiveLocation() == "제주") {
							if(Integer.parseInt(getWeight()) > 30000) {

							}
							if((25000 <= Integer.parseInt(getWeight()) && Integer.parseInt(getWeight()) <= 30000) || Integer.parseInt(getWeight()) <= 30000) {
								cw.resPrice.setListData(postDPrice());
							}
							if((20000 <= Integer.parseInt(getWeight()) && Integer.parseInt(getWeight()) <= 25000) || Integer.parseInt(getWeight()) <= 25000) {
								cw.resPrice.setListData(kakaoDPrice());
								cw.resPrice.setListData(cjDPrice());
							}
							if(Integer.parseInt(getWeight()) <= 20000) {
								cw.resPrice.setListData(hanjinDPrice());
							}
						}else {

							if(Integer.parseInt(getWeight()) > 30000) {

							}
							if((25000 <= Integer.parseInt(getWeight()) && Integer.parseInt(getWeight()) <= 30000) || Integer.parseInt(getWeight()) <= 30000) {
								cw.resPrice.setListData(postDPrice());
							}
							if((20000 <= Integer.parseInt(getWeight()) && Integer.parseInt(getWeight()) <= 25000) || Integer.parseInt(getWeight()) <= 25000) {
								cw.resPrice.setListData(kakaoDPrice());
								cw.resPrice.setListData(cjDPrice());
							}
							if(Integer.parseInt(getWeight()) <= 20000) {
								cw.resPrice.setListData(hanjinDPrice());
							}
						}
					}
				}

				if(outCheckbox()) {
					if(Integer.parseInt(getHeight1()) > 160) {

					}else {
						if(Integer.parseInt(getWeight()) > 30000) {

						}
						if((25000 <= Integer.parseInt(getWeight()) && Integer.parseInt(getWeight()) <= 30000) || Integer.parseInt(getWeight()) <= 30000) {
							cw.delivery.setListData(postname());
							cw.region.setListData(postSame());
							cw.kindsDel.setListData(postKinds());
							cw.markWeight.setListData(postMarkWeight());
							cw.markHeight.setListData(postMarkHeight());

							cw.delivery.setListData(miniName());
							cw.region.setListData(miniSame());
							cw.kindsDel.setListData(miniKinds());
							cw.markWeight.setListData(miniMarkWeight());
							cw.markHeight.setListData(miniMarkHeight());
						}
						if((20000 <= Integer.parseInt(getWeight()) && Integer.parseInt(getWeight()) <= 25000) || Integer.parseInt(getWeight()) <= 25000) {
							cw.delivery.setListData(cuName());
							cw.region.setListData(cuSame());
							cw.kindsDel.setListData(cuKinds());
							cw.markWeight.setListData(cuMarkWeight());
							cw.markHeight.setListData(cuMarkHeight());

							cw.delivery.setListData(gsName());
							cw.region.setListData(gsSame());
							cw.kindsDel.setListData(gsKinds());
							cw.markWeight.setListData(gsMarkWeight());
							cw.markHeight.setListData(gsMarkHeight());

							cw.delivery.setListData(sevenName());
							cw.region.setListData(sevenSame());
							cw.kindsDel.setListData(sevenKinds());
							cw.markWeight.setListData(sevenMarkWeight());
							cw.markHeight.setListData(sevenMarkHeight());
						}
						if(Integer.parseInt(getWeight()) <= 20000) {
							cw.delivery.setListData(emartName());
							cw.region.setListData(emartSame());
							cw.kindsDel.setListData(emartKinds());
							cw.markWeight.setListData(emartMarkWeight());
							cw.markHeight.setListData(emartMarkHeight());
						}

						if(sameLocation()) {
							if(Integer.parseInt(getWeight()) > 30000) {

							}
							if((25000 <= Integer.parseInt(getWeight()) && Integer.parseInt(getWeight()) <= 30000) || Integer.parseInt(getWeight()) <= 30000) {
								cw.resPrice.setListData(postPrice());
								cw.resPrice.setListData(miniPrice());
							}
							if((20000 <= Integer.parseInt(getWeight()) && Integer.parseInt(getWeight()) <= 25000) || Integer.parseInt(getWeight()) <= 25000) {
								cw.resPrice.setListData(cuPrice());
								cw.resPrice.setListData(gsPrice());
								cw.resPrice.setListData(sevenPrice());
							}
							if(Integer.parseInt(getWeight()) <= 20000) {
								cw.resPrice.setListData(emartPrice());
							}	
						}
						else if(getSendLocation() == "제주" || getReceiveLocation() == "제주") {
							if(Integer.parseInt(getWeight()) > 30000) {

							}
							if((25000 <= Integer.parseInt(getWeight()) && Integer.parseInt(getWeight()) <= 30000) || Integer.parseInt(getWeight()) <= 30000) {
								cw.resPrice.setListData(postPrice());
								cw.resPrice.setListData(miniPrice());
							}
							if((20000 <= Integer.parseInt(getWeight()) && Integer.parseInt(getWeight()) <= 25000) || Integer.parseInt(getWeight()) <= 25000) {
								cw.resPrice.setListData(cuPrice());
								cw.resPrice.setListData(gsPrice());
								cw.resPrice.setListData(sevenPrice());
							}
							if(Integer.parseInt(getWeight()) <= 20000) {
								cw.resPrice.setListData(emartPrice());
							}
						}else {
							if(Integer.parseInt(getWeight()) > 30000) {

							}
							if((25000 <= Integer.parseInt(getWeight()) && Integer.parseInt(getWeight()) <= 30000) || Integer.parseInt(getWeight()) <= 30000) {
								cw.resPrice.setListData(postPrice());
								cw.resPrice.setListData(miniPrice());
							}
							if((20000 <= Integer.parseInt(getWeight()) && Integer.parseInt(getWeight()) <= 25000) || Integer.parseInt(getWeight()) <= 25000) {
								cw.resPrice.setListData(cuPrice());
								cw.resPrice.setListData(gsPrice());
								cw.resPrice.setListData(sevenPrice());
							}
							if(Integer.parseInt(getWeight()) <= 20000) {
								cw.resPrice.setListData(emartPrice());
							}
						}
					}
				}	
			}
		});

		sendLocation_name.setBounds(150, 25, 150, 30);
		sendLocation.setBounds(120, 55, 150, 30);
		receiveLocation_name.setBounds(450, 25, 150, 30);
		receiveLocation.setBounds(420, 55, 150, 30);

		weight_name.setBounds(50, 225, 200, 30);
		weight.setBounds(50, 255, 200, 30);
		height_name.setBounds(50, 425, 200, 30);
		height.setBounds(50, 455, 200, 30);

		home.setBounds(450, 225, 110, 110);
		out.setBounds(575, 225, 110, 110);

		cal.setBounds(475, 425, 200, 100);

		setTitle("택배 가격 비교 서비스");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setLayout(null);
		setSize(800, 600);
		setResizable(false);
		setVisible(true);
	}

	public String getSendLocation() {
		return (String) sendLocation.getSelectedItem();
	}

	public String getReceiveLocation() {
		return (String) receiveLocation.getSelectedItem();
	}

	public String getWeight() {

		return weight.getText();
	}

	public String getHeight1() {
		return height.getText();
	}

	public boolean sameLocation() {
		if(getSendLocation() == "서울" || getSendLocation() == "인천" || getSendLocation() == "경기") {
			if(getReceiveLocation() == "서울" || getReceiveLocation() == "인천" || getReceiveLocation() == "경기") {
				return true;
			}
		}
		else if(getSendLocation() == "부산" || getSendLocation() == "울산" || getSendLocation() == "경남") {
			if(getReceiveLocation() == "부산" || getReceiveLocation() == "울산" || getReceiveLocation() == "경남") {
				return true;
			}
		}
		else if(getSendLocation() == "대전" || getSendLocation() == "충남" || getSendLocation() == "세종") {
			if(getReceiveLocation() == "대전" || getReceiveLocation() == "충남" || getReceiveLocation() == "세종") {
				return true;
			}
		}
		else if(getSendLocation() == "대구" || getSendLocation() == "경북") {
			if(getReceiveLocation() == "대구" || getReceiveLocation() == "경북") {
				return true;
			}
		}
		else if(getSendLocation() == "광주" || getSendLocation() == "전남") {
			if(getReceiveLocation() == "광주" || getReceiveLocation() == "전남") {
				return true;
			}
		}
		else if(getSendLocation() == "전북") {
			if(getReceiveLocation() == "전북") {
				return true;
			}
		}
		else if(getSendLocation() == "충북") {
			if(getReceiveLocation() == "충북") {
				return true;
			}
		}
		else if(getSendLocation() == "강원") {
			if(getReceiveLocation() == "강원") {
				return true;
			}
		}
		else if(getSendLocation() == "제주") {
			if(getReceiveLocation() == "제주") {
				return true;
			}
		}
		return false;
	}

	public String sameLocationS() {
		if(sameLocation()) {
			return "X";
		}
		else {
			return "O";
		}
	}

	public boolean homeCheckbox() {
		return bolHome;
	}
	public boolean outCheckbox() {
		return bolOut;
	}

	public String homeDelivery() {

		return "방문 택배";
	}

	public String outDelivery() {

		return "현장 택배";
	}

	public int Psheight() {
		int result1 = 0;

		if(Integer.parseInt(getHeight1()) >= 120) {
			result1 = 7;
		}
		else if(Integer.parseInt(getHeight1()) < 80) {
			result1 = 0;
		}
		else if(80 <= Integer.parseInt(getHeight1()) && Integer.parseInt(getHeight1()) < 100) {
			result1 = 1;
		}
		else if(100 <= Integer.parseInt(getHeight1()) && Integer.parseInt(getHeight1()) < 120) {
			result1 = 3;
		}
		return result1;
	}

	public int PsmarkHeight() {
		int mark = 0;

		if(Integer.parseInt(getHeight1()) >= 120) {
			mark = 3;
		}
		else if(Integer.parseInt(getHeight1()) < 80) {
			mark = 0;
		}
		else if(80 <= Integer.parseInt(getHeight1()) && Integer.parseInt(getHeight1()) < 100) {
			mark = 1;
		}
		else if(100 <= Integer.parseInt(getHeight1()) && Integer.parseInt(getHeight1()) < 120) {
			mark = 2;
		}
		return mark;
	}

	public int Psweight() {
		int result2 = 0;

		for (int i = 1; i < ta.postWeight.length; i++) {
			if(ta.postWeight[i] <= Integer.parseInt(getWeight()) && Integer.parseInt(getWeight()) <  ta.postWeight[i+1]) {
				result2 = i;
			}
			else if(Integer.parseInt(getWeight()) == 30000) result2 = 7;
		}
		return result2;
	}

	public int PscallPost() {

		int result = 0;

		result = (Psheight() >= Psweight()) ? Psheight() : Psweight();

		return ta.postTax[result];
	}

	public int PscallJejuPost() {

		int result = 0;

		result = (Psheight() >= Psweight()) ? Psheight() : Psweight();

		return ta.postJejuTax[result];
	}

	public Vector<String> postname(){
		name.add("우체국");
		return name;
	}

	public Vector<String> postSame(){
		compareLoc.add(sameLocationS());
		return compareLoc;
	}

	public Vector<String> postKinds(){
		collectDel.add(outDelivery());
		return collectDel;
	}

	public Vector<String> postMarkWeight(){
		standardWeight.add("~" + Integer.toString(ta.postWeight[Psweight()]));
		return standardWeight;
	}

	public Vector<String> postMarkHeight(){
		standardHeight.add("~" + Integer.toString(ta.postHeight[PsmarkHeight()]));
		return standardHeight;
	}

	public Vector<String> postPrice(){
		if(sameLocation()) {
			cost.add(Integer.toString(PscallPost()));
		}
		else if(getSendLocation() == "제주" || getReceiveLocation() == "제주") {
			cost.add(Integer.toString(PscallJejuPost()));
		}
		else {
			cost.add(Integer.toString(PscallPost()));
		}

		return cost;
	}

	public int cuWeight() {
		if(Integer.parseInt(getWeight()) == 25000) {
			return 11;
		}
		for (int i = 0; i < ta.cuWeight.length; i++) {
			if(ta.cuWeight[i] <= Integer.parseInt(getWeight()) && Integer.parseInt(getWeight()) < ta.cuWeight[i + 1]) {
				return i;
			}

		}
		return 0;
	}

	public int cuSameCost() {
		return ta.cuSameLocation[cuWeight()];
	}

	public int cuDiffCost() {
		return ta.cuDiffLocation[cuWeight()];
	}

	public int cuJejuCost() {
		return ta.cuJejuLocation[cuWeight()];
	}

	public Vector<String> cuName(){
		name.add("CU");
		return name;
	}

	public Vector<String> cuSame(){
		compareLoc.add(sameLocationS());
		return compareLoc;
	}

	public Vector<String> cuKinds(){
		collectDel.add(outDelivery());
		return collectDel;
	}

	public Vector<String> cuMarkWeight(){
		standardWeight.add("~" + Integer.toString(ta.cuWeight[cuWeight() + 1]));
		return standardWeight;
	}

	public Vector<String> cuMarkHeight(){
		standardHeight.add("X");
		return standardHeight;
	}

	public Vector<String> cuPrice(){
		if(sameLocation()) {
			cost.add(Integer.toString(cuSameCost()));
		}
		else if(getSendLocation() == "제주" || getReceiveLocation() == "제주") {
			cost.add(Integer.toString(cuJejuCost()));
		}
		else {
			cost.add(Integer.toString(cuDiffCost()));
		}

		return cost;
	}

	public int gsWeight() {
		if(Integer.parseInt(getWeight()) == 25000) {
			return 18;
		}
		for (int i = 0; i < ta.gsWeight.length; i++) {
			if(ta.gsWeight[i] <= Integer.parseInt(getWeight()) && Integer.parseInt(getWeight()) < ta.gsWeight[i + 1]) {
				return i;
			}
		}
		return 0;
	}

	public int gsSameCost() {
		return ta.gsSameLocation[gsWeight()];
	}

	public int gsDiffCost() {
		return ta.gsDiffLocation[gsWeight()];
	}

	public int gsJejuCost() {
		return ta.gsJejuLocation[gsWeight()];
	}

	public Vector<String> gsName(){
		name.add("GS");
		return name;
	}

	public Vector<String> gsSame(){
		compareLoc.add(sameLocationS());
		return compareLoc;
	}

	public Vector<String> gsKinds(){
		collectDel.add(outDelivery());
		return collectDel;
	}

	public Vector<String> gsMarkWeight(){
		standardWeight.add("~" + Integer.toString(ta.gsWeight[gsWeight() + 1]));
		return standardWeight;
	}

	public Vector<String> gsMarkHeight(){
		standardHeight.add("X");
		return standardHeight;
	}

	public Vector<String> gsPrice(){
		if(sameLocation()) {
			cost.add(Integer.toString(gsSameCost()));
		}
		else if(getSendLocation() == "제주" || getReceiveLocation() == "제주") {
			cost.add(Integer.toString(gsJejuCost()));
		}
		else {
			cost.add(Integer.toString(gsDiffCost()));
		}

		return cost;
	}

	public int miniHeight() {
		if(Integer.parseInt(getHeight1()) == 160) {
			return 2;
		}
		for (int i = 0; i < ta.miniHeight.length; i++) {
			if(ta.miniHeight[i] <= Integer.parseInt(getHeight1()) && Integer.parseInt(getHeight1()) < ta.miniHeight[i + 1]) {
				return i;
			}
		}
		return 0;
	}

	public int miniCost() {
		return ta.miniTax[miniHeight()];
	}

	public int miniJejuCost() {
		return ta.miniJejuTax[miniHeight()];
	}

	public Vector<String> miniName(){
		name.add("MINI");
		return name;
	}

	public Vector<String> miniSame(){
		compareLoc.add(sameLocationS());
		return compareLoc;
	}

	public Vector<String> miniKinds(){
		collectDel.add(outDelivery());
		return collectDel;
	}

	public Vector<String> miniMarkWeight(){
		standardWeight.add("X");
		return standardWeight;
	}

	public Vector<String> miniMarkHeight(){

		standardHeight.add("~" + Integer.toString(ta.miniHeight[miniHeight() + 1]));
		return standardHeight;
	}

	public Vector<String> miniPrice(){
		if(sameLocation()) {
			cost.add(Integer.toString(miniCost()));
		}
		else if(getSendLocation() == "제주" || getReceiveLocation() == "제주") {
			cost.add(Integer.toString(miniJejuCost()));
		}
		else {
			cost.add(Integer.toString(miniCost()));
		}

		return cost;
	}

	public int sevenWeight() {
		if(Integer.parseInt(getWeight()) == 25000) {
			return 2;
		}
		for (int i = 0; i < ta.sevenWeight.length; i++) {
			if(ta.sevenWeight[i] <= Integer.parseInt(getWeight()) && Integer.parseInt(getWeight()) < ta.sevenWeight[i + 1]) {
				return i;
			}
		}
		return 0;
	}

	public int sevenHeight() {
		if(Integer.parseInt(getHeight1()) == 160) {
			return 2;
		}
		for (int i = 0; i < ta.sevenHeight.length; i++) {
			if(ta.sevenHeight[i] <= Integer.parseInt(getHeight1()) && Integer.parseInt(getHeight1()) < ta.sevenHeight[i + 1]) {
				return i;
			}
		}
		return 0;
	}

	public int sevenS() {

		int result = 0;

		result = (sevenWeight() >= sevenHeight()) ? sevenWeight() : sevenHeight();

		return result;
	}

	public int sevenSameCost() {
		return ta.sevenSameLocation[sevenS()];
	}

	public int sevenDiffCost() {
		return ta.sevenDiffLocation[sevenS()];
	}

	public int sevenJejuCost() {
		return ta.sevenJejuLocation[sevenS()];
	}

	public Vector<String> sevenName(){
		name.add("SEVEN");
		return name;
	}

	public Vector<String> sevenSame(){
		compareLoc.add(sameLocationS());
		return compareLoc;
	}

	public Vector<String> sevenKinds(){
		collectDel.add(outDelivery());
		return collectDel;
	}

	public Vector<String> sevenMarkWeight(){
		standardWeight.add("~" + Integer.toString(ta.sevenWeight[sevenS() + 1]));
		return standardWeight;
	}

	public Vector<String> sevenMarkHeight(){
		standardHeight.add("~" + Integer.toString(ta.sevenHeight[sevenS() + 1]));
		return standardHeight;
	}

	public Vector<String> sevenPrice(){
		if(sameLocation()) {
			cost.add(Integer.toString(sevenSameCost()));
		}
		else if(getSendLocation() == "제주" || getReceiveLocation() == "제주") {
			cost.add(Integer.toString(sevenJejuCost()));
		}
		else {
			cost.add(Integer.toString(sevenDiffCost()));
		}

		return cost;
	}


	public int emartCost() {
		return 3500;
	}

	public int emartJejuCost() {
		return 6500;
	}

	public Vector<String> emartName(){
		name.add("EMART");
		return name;
	}

	public Vector<String> emartSame(){
		compareLoc.add(sameLocationS());
		return compareLoc;
	}

	public Vector<String> emartKinds(){
		collectDel.add(outDelivery());
		return collectDel;
	}

	public Vector<String> emartMarkWeight(){
		standardWeight.add("~20000");
		return standardWeight;
	}

	public Vector<String> emartMarkHeight(){
		standardHeight.add("~160");
		return standardHeight;
	}

	public Vector<String> emartPrice(){
		if(sameLocation()) {
			cost.add(Integer.toString(emartCost()));
		}
		else if(getSendLocation() == "제주" || getReceiveLocation() == "제주") {
			cost.add(Integer.toString(emartJejuCost()));
		}
		else {
			cost.add(Integer.toString(emartCost()));
		}

		return cost;
	}

	public int postDWeight() {
		if(Integer.parseInt(getWeight()) == 30000) {
			return 3;
		}
		for (int i = 0; i < vta.postDWeight.length; i++) {
			if(vta.postDWeight[i] <= Integer.parseInt(getWeight()) && Integer.parseInt(getWeight()) < vta.postDWeight[i + 1]) {
				return i;
			}
		}
		return 0;
	}

	public int postDHeight() {
		if(Integer.parseInt(getHeight1()) == 160) {
			return 3;
		}
		for (int i = 0; i < vta.postDHeight.length; i++) {
			if(vta.postDHeight[i] <= Integer.parseInt(getHeight1()) && Integer.parseInt(getHeight1()) < vta.postDHeight[i + 1]) {
				return i;
			}
		}
		return 0;
	}

	public int postDS() {

		int result = 0;

		result = (postDWeight() >= postDHeight()) ? postDWeight() : postDHeight();

		return result;
	}

	public int postCost() {
		return vta.postDTax[postDS()];
	}

	public int postJejuCost() {
		return vta.postDJejuTax[postDS()];
	}

	public Vector<String> postDName(){
		name.add("우체국");
		return name;
	}

	public Vector<String> postDSame(){
		compareLoc.add(sameLocationS());
		return compareLoc;
	}

	public Vector<String> postDKinds(){
		collectDel.add(homeDelivery());
		return collectDel;
	}

	public Vector<String> postDMarkWeight(){
		standardWeight.add("~" + Integer.toString(vta.postDWeight[postDWeight() + 1]));
		return standardWeight;
	}

	public Vector<String> postDMarkHeight(){
		standardHeight.add("~" + Integer.toString(vta.postDHeight[postDHeight() + 1]));
		return standardHeight;
	}

	public Vector<String> postDPrice(){
		if(sameLocation()) {
			cost.add(Integer.toString(postCost()));
		}
		else if(getSendLocation() == "제주" || getReceiveLocation() == "제주") {
			cost.add(Integer.toString(postJejuCost()));
		}
		else {
			cost.add(Integer.toString(postCost()));
		}

		return cost;
	}

	public int kakaoDWeight() {
		if(Integer.parseInt(getWeight()) == 25000) {
			return 2;
		}
		for (int i = 0; i < vta.kakaoDWeight.length; i++) {
			if(vta.kakaoDWeight[i] <= Integer.parseInt(getWeight()) && Integer.parseInt(getWeight()) < vta.kakaoDWeight[i + 1]) {
				return i;
			}
		}
		return 0;
	}

	public int kakaoDHeight() {
		if(Integer.parseInt(getHeight1()) == 160) {
			return 2;
		}
		for (int i = 0; i < vta.kakaoDHeight.length; i++) {
			if(vta.kakaoDHeight[i] <= Integer.parseInt(getHeight1()) && Integer.parseInt(getHeight1()) < vta.kakaoDHeight[i + 1]) {
				return i;
			}
		}
		return 0;
	}

	public int kakaoDS() {

		int result = 0;

		result = (kakaoDWeight() >= kakaoDHeight()) ? kakaoDWeight() : kakaoDHeight();

		return result;
	}

	public int kakaoDSameCost() {
		return vta.kakaoDSameLocation[kakaoDS()];
	}
	public int kakaoDDiffCost() {
		return vta.kakaoDDiffLocation[kakaoDS()];
	}

	public int kakaoDJejuCost() {
		return vta.kakaoDJejuLocation[kakaoDS()];
	}

	public Vector<String> kakaoDName(){
		name.add("카카오");
		return name;
	}

	public Vector<String> kakaoDSame(){
		compareLoc.add(sameLocationS());
		return compareLoc;
	}

	public Vector<String> kakaoDKinds(){
		collectDel.add(homeDelivery());
		return collectDel;
	}

	public Vector<String> kakaoDMarkWeight(){
		standardWeight.add("~" + Integer.toString(vta.kakaoDWeight[kakaoDWeight() + 1]));
		return standardWeight;
	}

	public Vector<String> kakaoDMarkHeight(){
		standardHeight.add("~" + Integer.toString(vta.kakaoDHeight[kakaoDHeight() + 1]));
		return standardHeight;
	}

	public Vector<String> kakaoDPrice(){
		if(sameLocation()) {
			cost.add(Integer.toString(kakaoDSameCost()));
		}
		else if(getSendLocation() == "제주" || getReceiveLocation() == "제주") {
			cost.add(Integer.toString(kakaoDJejuCost()));
		}
		else {
			cost.add(Integer.toString(kakaoDDiffCost()));
		}

		return cost;
	}

	public int cjDWeight() {
		if(Integer.parseInt(getWeight()) == 25000) {
			return 3;
		}
		for (int i = 0; i < vta.cjDWeight.length; i++) {
			if(vta.cjDWeight[i] <= Integer.parseInt(getWeight()) && Integer.parseInt(getWeight()) < vta.cjDWeight[i + 1]) {
				return i;
			}
		}
		return 0;
	}

	public int cjDHeight() {
		if(Integer.parseInt(getHeight1()) == 160) {
			return 3;
		}
		for (int i = 0; i < vta.cjDHeight.length; i++) {
			if(vta.cjDHeight[i] <= Integer.parseInt(getHeight1()) && Integer.parseInt(getHeight1()) < vta.cjDHeight[i + 1]) {
				return i;
			}
		}
		return 0;
	}

	public int cjDS() {

		int result = 0;

		result = (cjDWeight() >= cjDHeight()) ? cjDWeight() : cjDHeight();

		return result;
	}

	public int cjCost() {
		return vta.cjDLocation[cjDS()];
	}

	public int cjDJejuCost() {
		return vta.cjDJejuLocation[cjDS()];
	}

	public Vector<String> cjDName(){
		name.add("CJ대한통운");
		return name;
	}

	public Vector<String> cjDSame(){
		compareLoc.add(sameLocationS());
		return compareLoc;
	}

	public Vector<String> cjDKinds(){
		collectDel.add(homeDelivery());
		return collectDel;
	}

	public Vector<String> cjDMarkWeight(){
		standardWeight.add("~" + Integer.toString(vta.cjDWeight[cjDWeight() + 1]));
		return standardWeight;
	}

	public Vector<String> cjDMarkHeight(){
		standardHeight.add("~" + Integer.toString(vta.cjDHeight[cjDHeight() + 1]));
		return standardHeight;
	}

	public Vector<String> cjDPrice(){
		if(sameLocation()) {
			cost.add(Integer.toString(cjCost()));
		}
		else if(getSendLocation() == "제주" || getReceiveLocation() == "제주") {
			cost.add(Integer.toString(cjDJejuCost()));
		}
		else {
			cost.add(Integer.toString(cjCost()));
		}

		return cost;
	}

	public int hanjinDWeight() {
		if(Integer.parseInt(getWeight()) == 20000) {
			return 3;
		}
		for (int i = 0; i < vta.hanjinDWeight.length; i++) {
			if(vta.hanjinDWeight[i] <= Integer.parseInt(getWeight()) && Integer.parseInt(getWeight()) < vta.hanjinDWeight[i + 1]) {
				return i;
			}
		}
		return 0;
	}

	public int hanjinDHeight() {
		if(Integer.parseInt(getHeight1()) == 160) {
			return 3;
		}
		for (int i = 0; i < vta.hanjinDHeight.length; i++) {
			if(vta.hanjinDHeight[i] <= Integer.parseInt(getHeight1()) && Integer.parseInt(getHeight1()) < vta.hanjinDHeight[i + 1]) {
				return i;
			}
		}
		return 0;
	}

	public int hanjinDS() {

		int result = 0;

		result = (hanjinDWeight() >= hanjinDHeight()) ? hanjinDWeight() : hanjinDHeight();

		return result;
	}

	public int hanjinCost() {
		return vta.hanjinDLocation[hanjinDWeight()];
	}

	public int hanjinDJejuCost() {
		return vta.hanjinDJejuLocation[hanjinDHeight()];
	}

	public Vector<String> hanjinDName(){
		name.add("한진택배");
		return name;
	}

	public Vector<String> hanjinDSame(){
		compareLoc.add(sameLocationS());
		return compareLoc;
	}

	public Vector<String> hanjinDKinds(){
		collectDel.add(homeDelivery());
		return collectDel;
	}

	public Vector<String> hanjinDMarkWeight(){
		standardWeight.add("~" + Integer.toString(vta.hanjinDWeight[hanjinDS() + 1]));
		return standardWeight;
	}

	public Vector<String> hanjinDMarkHeight(){
		standardHeight.add("~" + Integer.toString(vta.hanjinDHeight[hanjinDS() + 1]));
		return standardHeight;
	}

	public Vector<String> hanjinDPrice(){
		if(sameLocation()) {
			cost.add(Integer.toString(hanjinCost()));
		}
		else if(getSendLocation() == "제주" || getReceiveLocation() == "제주") {
			cost.add(Integer.toString(hanjinDJejuCost()));
		}
		else {
			cost.add(Integer.toString(hanjinCost()));
		}

		return cost;
	}
}