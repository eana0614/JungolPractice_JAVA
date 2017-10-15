package Problem7;

import java.util.Scanner;

/*
 * Problem 7. Error Collection.
 * 
 * Read the matrix information to determine if it has a parity property.
 * 
 * Input : In the first row, n (n <100), the size of the matrix, is input 
 * 			and n 0 or 1 is entered in n rows.
 * 
 * Output : Print "OK" when having parity property.
 * 			Print "Change bit (i,j)" containing information of the bit to be changed
 * 					when only one bit has the property of parity.
 * 			Print "Corrupt" if not both
 * 
 */

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		int[][] matrix = new int[n][n];
		
		for(int i=0; i<n*n; i++) {
			
			int x = i / n;
			
			int y = i % n;
			
			matrix[x][y] = scanner.nextInt();
			
		}
		
		runParitycheck(matrix);
	}

	private static void runParitycheck(int[][] matrix) {
		String index;
		if(hasParity(matrix)) {
			System.out.println("OK");
		}else if((index = isOneBit(matrix) )!= null) {
			System.out.println("Change bit ("+index+")");
		}else {
			System.out.println("Corrupt");
		}
	}

	private static String isOneBit(int[][] matrix) {
		
		String str = null;
		
		int rowCount  = 0;
		int colCount = 0;
		
		int rowcheck = 0;
		int colcheck = 0;
		
		int row = 0;
		int col = 0;
		
		for(int i=0; i< matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				rowcheck += matrix[i][j];
				colcheck += matrix[j][i];
				
			}
			
			if(rowcheck % 2 != 0 ) {
				rowCount++;
				row = i+1;
			}
			
			if(colcheck % 2 != 0) {
				colCount++;
				col = i+1;
			}
			
			rowcheck = 0;
			colcheck = 0;
		}
		
		if(rowCount == 1 && colCount == 1) {
			str = row+","+col;
		}
		
		return str;
	}

	private static boolean hasParity(int[][] matrix) {
		
		int rowcheck = 0;
		int colcheck = 0;
		for(int i=0; i < matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				rowcheck += matrix[i][j];
				colcheck += matrix[j][i];
			}
			
			if(rowcheck % 2 != 0 || colcheck % 2 != 0) {
				return false;
			}
			
			rowcheck = 0;
			colcheck = 0;
		}
		
		return true;
	}

}
