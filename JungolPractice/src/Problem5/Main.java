package Problem5;

import java.util.Scanner;

/*
 * Problem 5. Sort 3 numbers.
 * 
 *   Input : N (List size <= 1000), N numbers from 1 to 3
 *   Output : Number of position changes
 *   
 */

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		int[] inputs = new int[N];
		int[] elementIndex= new int[3];
		
		for(int i=0; i<N; i++) {
			inputs[i] = scanner.nextInt();
			elementIndex[inputs[i]-1]++;
		}
		
		elementIndex[2] = elementIndex[1]+elementIndex[0]+elementIndex[2]-1;
		elementIndex[1] = elementIndex[0]+elementIndex[1]-1;
		elementIndex[0] = elementIndex[0]-1;
		
		int result = runSort(inputs, elementIndex);
		
		System.out.println(result);
		
	}

	private static int runSort(int[] inputs, int[] elementIndex) {
		int count = 0;
		
		for(int i=0; i< inputs.length; i++) {
			if(elementPosition(elementIndex, i) != inputs[i]) {
				
				for(int j=elementIndex[inputs[i]-1]; j < inputs.length ; j++) {
					if(inputs[j] == elementPosition(elementIndex, i)) {
						int temp = inputs[i];
						inputs[i] = inputs[j];
						inputs[j] = temp;
						
						count++;
						break;
					}
				}
					}
			
		}
		return count;
	}

	private static int elementPosition(int[] elementIndex, int i) {

		if(elementIndex[0] >= i) {
			return 1;
		}else if( elementIndex[1] >= i) {
			return 2;
		}else {
			return 3;
		}
	}

}
