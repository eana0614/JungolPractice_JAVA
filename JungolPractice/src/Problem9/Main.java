package Problem9;

import java.util.Scanner;

/*
 * Problem 9. sumset
 *  
 * When input number N, find out if there are some case where the sum of squares of 2 is N.
 * 	If N == 7,
 * 		1+1+1+1+1+1+1
 * 		1+1+1+1+1+2
 * 		1+1+1+2+2
 * 		1+2+2+2
 * 		1+2+4
 * 		1+1+1+4
 * 		>> answer : 6
 * 		
 * Input : T (test case : 1 <= T <= 64), N (<= 64)
 * 
 */

public class Main {

	static int [] squares = {1, 2, 4, 8, 16, 32, 64};
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int t = scanner.nextInt();
		
		for(int i=0; i<t; i++) {
			int n = scanner.nextInt();
			
			int count = recursive(0, 0, n);
			
			System.out.println(count);
		}
	}

	private static int recursive(int sum, int i, int n) {
		int count = 0;
		
		if(sum < n) {
			for(; i < squares.length; i++) {
				count += recursive(sum+squares[i], i, n);
			}
		}
		
		if(sum == n) {
			count++;
		}
		
		return count;

	}

}
