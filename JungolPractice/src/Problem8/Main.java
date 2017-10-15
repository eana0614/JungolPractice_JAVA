package Problem8;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Problem 8. Mass
 * 
 * Calculate the mass by inputting the molecular formula.
 * 
 * Restrictions
 * 		>> The types if atoms are C, H, O, N.
 * 		>> Molecular formula has several elements.
 * 		>> Mass of Element : C (12.01), H(1.008), O(16.00), N(14.01)
 * 
 * Input : Molecular formula.
 * Output : All Mass. (To the third decimal place)
 * 
 */

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String formula = scanner.nextLine();

		double result = runCalculateMass(formula);
		System.out.printf("%.3f\n",result);

	}

	private static double runCalculateMass(String formula) {

		int[] num = new int[4];
		char c;
		int n;

		String regex = "[C|H|O|N][0-9]*";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(formula);

		while (matcher.find()) {
			String a;

			a = matcher.group();
			c = a.charAt(0);

			if (a.length() >= 2) {
				String str = a.substring(1);
				n = Integer.parseInt(str);
			} else {
				n = 1;
			}
			
			switch (c) {
			case 'C':
				num[0] += n;
				break;
			case 'H':
				num[1] += n;
				break;
			case 'O':
				num[2] += n;
				break;
			case 'N':
				num[3] += n;
				break;

			}
		}
		return sumMass(num);

	}

	private static double sumMass(int[] num) {
		double sum = 0;

		sum += (num[0] * 12.01) + (num[1] * 1.008) + (num[2] * 16) + (num[3] * 14.01);

		return sum;
	}

}
