package Problem1;

import java.util.ArrayList;
import java.util.Scanner;


/*
 * Problem1. Line up.
 * 줄은 선 순서대로 각각 0에서 자신의 앞에 있는 사람수보다 적은 숫자 사이의 숫자를 뽑아 뽑은 수만큼
 * 앞으로가 줄을 선다.
 * 
 * 입력 : 줄을 서는 사람 수, 각자 뽑은 숫자
 * 출력 : 문제를 바탕으로 구현하여 줄을 선 학생들이 줄을 선 순서
 */

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int studentNum = scanner.nextInt();
		
		int [] student = new int[studentNum];
		ArrayList<Integer> st = new ArrayList<>();
		
		for(int i=0; i<studentNum; i++) {
			int number = scanner.nextInt();
			st.add(i-number, i+1);
		}
		
		printResult(st);
		
	}

	private static void printResult(ArrayList<Integer> st) {
		
		for(int i=0; i<st.size(); i++) {
			System.out.print(st.get(i)+" ");
		}
	}

	
}
