package deliveryTax;

public class Tax {
	int[] postWeight = {0, 3000, 5000, 7000, 10000, 15000, 20000, 25000, 30000};
	int[] postHeight = {0, 80, 100, 120, 160};
	int[] postTax = {4000, 4500, 5000, 6000, 7000, 8000, 10000, 12000};
	int[] postJejuTax = {6500, 7000, 7500, 8500, 9500, 10500, 12500, 14500};
	
	int[] cuWeight = {0, 350, 500, 700, 1000, 1500, 2000, 3000, 4000, 5000, 10000, 20000, 25000};
	int[] cuSameLocation = {2900, 3200, 3600, 3900, 4400, 4600, 4800, 5100, 5400, 6800, 8500, 10000};
	int[] cuDiffLocation = {3400, 3700, 4100, 4400, 4900, 5100, 5300, 5600, 5900, 7800, 9500, 11000};
	int[] cuJejuLocation = {6100, 6400, 7100, 7400, 7900, 8100, 8300, 8600, 8900, 10300, 11500, 13000};
	
	int[] gsWeight = {0, 350, 400, 450, 500, 600, 700, 800, 900, 1000, 1500, 2000, 3000, 4000, 5000, 7000, 10000, 15000, 20000, 25000};
	int[] gsSameLocation = {2900, 3100, 3200, 3400, 3600, 3700, 3800, 3900, 4000, 4300, 4600, 4900, 5000, 5400, 6500, 7000, 7800, 8800, 10000};
	int[] gsDiffLocation = {3400, 3600, 3700, 3900, 4100, 4200, 4300, 4400, 4500, 4800, 5100, 5400, 5500, 5900, 7500, 8000, 8800, 9800, 11000};
	int[] gsJejuLocation = {6100, 6300, 6400, 6600, 7100, 7200, 7300, 7400, 7500, 7300, 8100, 8400, 8500, 8900, 10500, 10500, 11800, 11800, 13000};
	
	int[] miniHeight = {0, 80, 100, 160};
	int[] miniTax = {3500, 5000, 6000};
	int[] miniJejuTax = {6500, 8000, 9000};
	
	int[] sevenWeight = {0, 5000, 15000, 25000};
	int[] sevenHeight = {0, 110, 130, 160};
	int[] sevenSameLocation = {5000, 6000, 7000};
	int[] sevenDiffLocation = {6000, 7000, 8000};
	int[] sevenJejuLocation = {8000, 9000, 10000};
	
	int emartWeight = 20000;
	int emartHeight = 160;
	int emartTax = 3500;
	int emartJejuTax = 6500;
	
	public int[] getPostWeight() {
		return postWeight;
	}
	
	public int[] getPostHeight() {
		return postHeight;
	}

	public int[] getPostTax() {
		return postTax;
	}

	public int[] getPostJejuTax() {
		return postJejuTax;
	}

	public int[] getCuWeight() {
		return cuWeight;
	}

	public int[] getCuSameLocation() {
		return cuSameLocation;
	}

	public int[] getCuDiffLocation() {
		return cuDiffLocation;
	}

	public int[] getCuJejuLocation() {
		return cuJejuLocation;
	}

	public int[] getGsWeight() {
		return gsWeight;
	}

	public int[] getGsSameLocation() {
		return gsSameLocation;
	}

	public int[] getGsDiffLocation() {
		return gsDiffLocation;
	}

	public int[] getGsJejuLocation() {
		return gsJejuLocation;
	}

	public int[] getMiniHeight() {
		return miniHeight;
	}

	public int[] getMiniTax() {
		return miniTax;
	}

	public int[] getMiniJejuTax() {
		return miniJejuTax;
	}

	public int[] getSevenWeight() {
		return sevenWeight;
	}

	public int[] getSevenHeight() {
		return sevenHeight;
	}

	public int[] getSevenSameLocation() {
		return sevenSameLocation;
	}

	public int[] getSevenDiffLocation() {
		return sevenDiffLocation;
	}

	public int[] getSevenJejuLocation() {
		return sevenJejuLocation;
	}

	public int getEmartWeight() {
		return emartWeight;
	}

	public int getEmartHeight() {
		return emartHeight;
	}

	public int getEmartTax() {
		return emartTax;
	}

	public int getEmartJejuTax() {
		return emartJejuTax;
	}

}