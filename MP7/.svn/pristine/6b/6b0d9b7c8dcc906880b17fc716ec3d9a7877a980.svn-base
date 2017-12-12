
public class support {
	public static double function(int x, double a, double b) {
		if (x == 1) return a + b;
		if (x == 2) return a - b;
		if (x == 3) return a * b;
		if (x == 4) {
			if (b != 0) {
				return a / b;
			} else {
				return 0;
			}
		}
		return 0;
	}
	
	public static double[] forward(double [] x) {
		double [] output = new double[4];
		for (int i = 1; i < 3; i++) {
			output[i] = x[i + 1];
		}
		return output;
	}
	
	public static double [] createArray(int x, double[] arr, double a, double b) {
		double [] output = support.forward(arr);
		output[0] = function(x, a, b);
		return output;
	}
	
	public static double [] createArray(int x, int y, double a, double b, double c, double d) {
		double [] output = new double [4];
		double temp1 = function(x, a, b);
		double temp2 = function(y, c, d);
		output[0] = temp1;
		output[1] = temp2;
		return output;
	}
	
	public static String functionHolder (int x, String a, String b) {
		if (x == 1) return "(" + a + "+" + b + ")" ;
		if (x == 2) return "(" + a + "-" + b + ")" ;
		if (x == 3) return a + "*" + b;
		if (x == 4) return a + "/" + b;
		return null;
	}
	
	public static double [][] permutation(double[] no) {
		double [][] output = new double [24][];
		for (int w = 0; w < 4; w++) {
			for (int x = 0; x < 4; x++) {
				if ( x != w) {
					for (int y = 0; y < 4; y++) {
						if (y != w && y != x) {
							for (int z = 0; z < 4; z++) {
								if (z != w && z != x && z != y) {
									double[] temp = new double[4];
									temp[0] = no[w];
									temp[1] = no[x];
									temp[2] = no[y];
									temp[3] = no[z];
									for (int p = 0; p < 24; p++) {
										if (output[p] == null) {
											output[p] = temp;
											break;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return output;
	}
}
