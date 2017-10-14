package Problem3;

import java.util.Scanner;

/*
 * The 369 game is a game where you clap the specially number contains 3, 6, 9.
 * But change the rules of the game so that players clap when the number is a prime number.
 * 
 * Input : the number of the participant of the game, the number which is called at the end,
 * 	and the number of the specific person index
 * Output : Clap number.
 * 
 */

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int participantNum = scanner.nextInt();
		int lastNum = scanner.nextInt();
		int person = scanner.nextInt();
		
		int [] clapNum = runClapNum(participantNum, lastNum);
		
		System.out.println(clapNum[person]);
	}

	private static int[] runClapNum(int participantNum, int lastNum) {
		
		int[] result = new int[participantNum];
		int indexs = 0;
		
		for(int i=1; i<=lastNum; i++) {
			
			boolean prime = checkPrimeNum(i);
			
			if(prime) {
				result[indexs]++;
			}
			
			if(indexs == participantNum-1) {
				indexs = 0;
			}else {
				indexs++;
			}
		}
		
		return result;
	}

	private static boolean checkPrimeNum(int num) {
		
		if(num  <= 2) {
			return true;
		}
		
		for(int i=2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) {
				return false;
			}
		}
		
		return true;
	}

}
