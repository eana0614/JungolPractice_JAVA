package Problem1;

import java.util.ArrayList;
import java.util.Scanner;


/*
 * Problem1. Line up.
 * ���� �� ������� ���� 0���� �ڽ��� �տ� �ִ� ��������� ���� ���� ������ ���ڸ� �̾� ���� ����ŭ
 * �����ΰ� ���� ����.
 * 
 * �Է� : ���� ���� ��� ��, ���� ���� ����
 * ��� : ������ �������� �����Ͽ� ���� �� �л����� ���� �� ����
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
