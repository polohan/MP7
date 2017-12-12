import java.util.Arrays;
import java.util.Scanner;

public class Game {
	public static boolean is24(double[] gg, String x, boolean print) {
		/* base case */
		if ((gg[1] == 0 && gg[2] == 0 && gg[3] == 0) || gg[0] == 0) {
			if (gg[0] == 24) {
				if (print)
					System.out.println(x + "=24");
				return true;
			}
			return false;
		}
		boolean is24In1stCase = false;
		boolean is24In2ndCase = false;
		if (gg[3] == 0) {
			is24In1stCase = false;
			for (int i = 1; i <= 4; i++) {
				if (is24(support.createArray(i, gg, gg[0], gg[1]), support.functionHolder(i, "" + x, "" + gg[1]),
						print)) {
					is24In1stCase = true;
				}
			}
		} else {
			for (int i = 1; i <= 4; i++) {
				if (is24(support.createArray(i, gg, gg[0], gg[1]), support.functionHolder(i, "" + gg[0], "" + gg[1]),
						print)) {
					is24In1stCase = true;
				}
			}
			for (int i = 1; i <= 4; i++) {
				for (int j = 1; j <= 4; j++) {
					if (is24Special(support.createArray(i, j, gg[0], gg[1], gg[2], gg[3]),
							support.functionHolder(i, "" + gg[0], "" + gg[1]),
							support.functionHolder(j, "" + gg[2], "" + gg[3]))) {
						is24In2ndCase = true;
					}
				}
			}

		}
		return (is24In1stCase || is24In2ndCase);
	}

	public static boolean is24Special(double[] gg, String x, String y) {
		for (int i = 1; i <= 4; i++) {
			if (support.function(i, gg[0], gg[1]) == 24) {
				System.out.println(support.functionHolder(i, x, y) + "=24");
				return true;
			}
		}
		return false;
	}

	/* test */
	public static void main(String[] args) {
		double[][] z = support.permutation(getNumber());
		System.out.println("The solution for 24 games with the number you enter is:");
		for (int i = 0; i < 24; i++) {
			if (is24(z[i], "", false)) {
			}
		}
	}

	public static double[] getNumber() {
		double[] x = new double[4];
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the first number");
		x[0] = in.nextInt();
		ifxIsWrong(x[0]);
		System.out.println("Enter the second number");
		x[1] = in.nextInt();
		ifxIsWrong(x[1]);
		System.out.println("Enter the third number");
		x[2] = in.nextInt();
		ifxIsWrong(x[2]);
		System.out.println("Enter the fourth number");
		x[3] = in.nextInt();
		ifxIsWrong(x[3]);
		return x;
	}

	public static double ifxIsWrong(double a) {
		if (a > 10)
			foraWrongA(a);
		if (a < 1)
			foraWrongA(a);
		return (a);
	}

	static double foraWrongA(double s) {
		if (s > 10) {
			System.out.println("num>10,Re-enter");
			Scanner in = new Scanner(System.in);
			s = in.nextInt();
			ifxIsWrong(s);
		}
		if (s < 1) {
			System.out.println("num<1,Re-enter");
			Scanner in = new Scanner(System.in);
			s = in.nextInt();
			ifxIsWrong(s);
		}
		return s;
	}
}
