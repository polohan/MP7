import java.util.Arrays;
import java.util.Scanner;

public class Game {
	public static boolean is24(double[] gg, String x, boolean print) {
		/*
		 * Base case When the there is only one number left in the array, the
		 * number with index 0
		 */
		if ((gg[1] == 0 && gg[2] == 0 && gg[3] == 0)) {
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
			for (int operator = 1; operator <= 4; operator++) {
				if (is24(support.createArray(operator, gg, gg[0], gg[1]),
						support.functionHolder(operator, "" + x, "" + (int) gg[1]), print)) {
					is24In1stCase = true;
				}
			}
		} else {
			for (int operator = 1; operator <= 4; operator++) {
				if (is24(support.createArray(operator, gg, gg[0], gg[1]),
						support.functionHolder(operator, "" + (int) gg[0], "" + (int) gg[1]), print)) {
					is24In1stCase = true;
				}
			}
			/**
			 * Special case of operation, where we have to add(minus) the first
			 * two number and last two number first, then do
			 * multiplication(division). Example: (a+b)*(c-d) or (a*b)+(c/d)
			 */
			for (int i = 1; i <= 4; i++) {
				for (int j = 1; j <= 4; j++) {
					if (is24Special(support.createArray(i, j, gg[0], gg[1], gg[2], gg[3]),
							support.functionHolder(i, "" + (int) gg[0], "" + (int) gg[1]),
							support.functionHolder(j, "" + (int) gg[2], "" + (int) gg[3]), print)) {
						is24In2ndCase = true;
					}
				}
			}

		}
		return (is24In1stCase || is24In2ndCase);
	}

	public static boolean is24Special(double[] gg, String x, String y, boolean print) {
		for (int i = 1; i <= 4; i++) {
			if (support.function(i, gg[0], gg[1]) == 24) {
				if (print)
					System.out.println(support.functionHolder(i, x, y) + "=24");
				return true;
			}
		}
		return false;
	}

	public static double[] generate() {
		double[] temp = new double[4];
		temp[0] = (int) (Math.random() * 10 + 1);
		temp[1] = (int) (Math.random() * 10 + 1);
		temp[2] = (int) (Math.random() * 10 + 1);
		temp[3] = (int) (Math.random() * 10 + 1);
		if (is24(temp, "", false)) {
			final int[] intArray = new int[temp.length];
			for (int i = 0; i < intArray.length; ++i) {
				intArray[i] = (int) temp[i];
			}
			System.out.println(Arrays.toString(intArray));
			return temp;
		} else {
			return generate();
		}
	}

	public static void check(double[] input, String playOrCheck) {
		double[][] z = support.permutation(input);
		System.out.println("The solution for 24 games with the number you " + playOrCheck + " is:");
		for (int i = 0; i < 24; i++) {
			if (is24(z[i], "", true)) {
			}
		}
	}
	
	public static void play() {
		Scanner in = new Scanner(System.in);
		System.out.println("Play or Check? 1 to play and 2 to check. :)");
		int playOrCheck = in.nextInt();
		if (playOrCheck == 1) {
			double[] temp = generate();
			System.out.println("Wanna see the answer?");
			if (in.hasNext()) {
				check(temp, "play with");
			}
		} else {
			check(getNumber(), "enter");
		}
	}
	/* test */
	public static void main(String[] args) {
	boolean anotherGame = true;
	while (anotherGame) {
		play();
		System.out.println("Wanna quit? Type \"quit\" if so.");
		Scanner in = new Scanner(System.in);
		String temp = in.next();
		if (temp.equals("quit")) anotherGame = false;
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
