package Problem11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * Problem 11. Timeline.
 * 
 * Arrange the events in time and if events is overlapping, increase the number of line.
 * Print number of line.
 * 
 *  Input : N (1<= N <= 100000, N = input data number), N times
 *  
 */

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		scanner.nextLine();
		String[] inputs = new String[n];
		
		while( n > 0) {
			n--;
			inputs[n] = scanner.nextLine();
		}
		
		Events [] events = createEvents(inputs);
		
		int result = checkTime(events);
		System.out.println(result);
	}
	
	private static int checkTime(Events[] events) {
		
		Date sts = events[0].startDate;
		Date ends = events[0].endDate;
		
		int count = 0;
		int max = 0;
		
		SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd");
		
		for(int i=1; i< events.length; i++) {
			
			if(sts.after(events[i].startDate)) {
				sts = events[i].startDate;
			}
			
			if(ends.before(events[i].endDate)) {
				ends = events[i].endDate;
			}
			
			//System.out.println(sd.format(sts) + " ~ " + sd.format(ends) );
			
			for(int j=0; j<events.length; j++) {
				if(sts.before(events[j].startDate) && ends.after(events[j].endDate)) {
				//	System.out.println(sd.format(events[j].startDate) +" - "+sd.format(events[j].endDate));
					count++;
				}
			}
			
			if(count > max) {
				max = count;
			}
			
			count = 0;
			
		}
		
		return max;
	}

	private static Events[] createEvents(String[] inputs) {
		
		int size = inputs.length;
		Events[] result = new Events[size];
		
		for(int i=0; i<size; i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(inputs[i], " ");
			
			String st = stringTokenizer.nextToken();
			String en = stringTokenizer.nextToken();
			
			SimpleDateFormat simple = new SimpleDateFormat("yyyy.MM.dd");
			
			try {
				Date start = simple.parse(st);
				Date end = simple.parse(en);
				
				result[i] = new Events(start, end);
				
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		}
		
		
		Arrays.sort(result);
		
		return result;
	}

	static class Events implements Comparable {
		
		Date startDate;
		Date endDate;
		
		public Events(Date start, Date end) {
			this.startDate = start;
			this.endDate = end; 
		}
		
		@Override
		public int compareTo(Object o) {
			
			Events ev = (Events)o;
			
			if(startDate.before(ev.startDate)) {
				return -1;
			}else if(startDate.after(ev.startDate)) {
				return 1;
			}else {
				return 0;
			}
		}
		
	}

}
