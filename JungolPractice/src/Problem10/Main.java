package Problem10;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Problem 10. Line drawing
 * 
 * In the 2D plane, player draws line using N points.
 * 
 * 2 points are connected regardless of the straight line length.
 * There should be no parallel straight line among the lines.
 * 
 * Input : N ( 2 <= N <= 200), points N
 * 
 */

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		Points[] points = new Points[n];

		while (n > 0) {
			n--;

			int x = scanner.nextInt();
			int y = scanner.nextInt();

			points[n] = new Points(x, y);
		}

		int result = drawAllLine(points);
		System.out.println(result);
	}

	private static int drawAllLine(Points[] points) {

		boolean vertical = false;
		boolean hor = false;

		int count = 0;
		
		ArrayList<Double> inclination = new ArrayList<>();
		for (int i = 0; i < points.length - 1; i++) {
			for (int j = i + 1; j < points.length; j++) {

				double inc;
				if (points[i].x == points[j].x && points[i].y != points[j].y) {
					vertical = true;
				} else if (points[i].x != points[j].x && points[i].y == points[j].y) {
					hor = true;
				} else {
					inc = (double) (points[i].y - points[j].y) / (points[i].x - points[j].x);
					if (!inclination.contains(inc)) {
						inclination.add(inc);
					}
				}
			}
		}
		
		count = inclination.size();
		
		if(vertical) {
			count++;
		}
		
		if(hor) {
			count++;
		}

		return count;
	}

	static class Points {
		int x;
		int y;

		public Points(int i, int j) {
			this.x = i;
			this.y = j;
		}
	}

}
