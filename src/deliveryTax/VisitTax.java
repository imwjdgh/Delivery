package deliveryTax;


public class VisitTax {
	int[] postDWeight = {0, 5000, 10000, 20000, 30000};
	int[] postDHeight = {0, 80, 100, 120, 160};
	int[] postDTax = {5000, 8000, 10000, 12000};
	int[] postDJejuTax = {7500, 10500, 12500, 14500};
	
	int[] kakaoDWeight = {0, 3000, 10000, 25000};
	int[] kakaoDHeight = {0, 80, 120, 160};
	int[] kakaoDSameLocation = {4500, 5000, 5500};
	int[] kakaoDDiffLocation = {5000, 5500, 6000};
	int[] kakaoDJejuLocation = {7500, 8000, 8500};
	
	int[] cjDWeight = {0, 2000, 5000, 15000, 25000};
	int[] cjDHeight = {0, 80, 100, 120, 160};
	int[] cjDLocation = {5000, 6000, 7000, 9000};
	int[] cjDJejuLocation = {8000, 9000, 10000, 12000};
	
	int[] hanjinDWeight = {0, 2000, 5000, 10000, 20000};
	int[] hanjinDHeight = {0, 80, 100, 120, 160};
	int[] hanjinDLocation = {4000, 4500, 5900, 8500};
	int[] hanjinDJejuLocation = {7000, 7500, 8900, 11500};
	
	public int[] getPostDWeight() {
		return postDWeight;
	}
	public int[] getPostDHeight() {
		return postDHeight;
	}
	public int[] getPostDTax() {
		return postDTax;
	}
	public int[] getKakaoDWeight() {
		return kakaoDWeight;
	}
	public int[] getKakaoDHeight() {
		return kakaoDHeight;
	}
	public int[] getKakaoDSameLocation() {
		return kakaoDSameLocation;
	}
	public int[] getKakaoDDiffLocation() {
		return kakaoDDiffLocation;
	}
	public int[] getKakaoDJejuLocation() {
		return kakaoDJejuLocation;
	}
	public int[] getCjDWeight() {
		return cjDWeight;
	}
	public int[] getCjDHeight() {
		return cjDHeight;
	}
	public int[] getCjDLocation() {
		return cjDLocation;
	}
	public int[] getCjDJejuLocation() {
		return cjDJejuLocation;
	}
	public int[] getHanjinDWeight() {
		return hanjinDWeight;
	}
	public int[] getHanjinDHeight() {
		return hanjinDHeight;
	}
	public int[] getHanjinDLocation() {
		return hanjinDLocation;
	}
	public int[] getHanjinDJejuLocation() {
		return hanjinDJejuLocation;
	}
}