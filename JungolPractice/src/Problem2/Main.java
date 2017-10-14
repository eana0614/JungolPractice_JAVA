package Problem2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {

			int year = scanner.nextInt();
			int month = scanner.nextInt();
			int day = scanner.nextInt();

			if (checkDay(year, month, day)) {

				printCalendar(year, month, day);

			} else {
				System.out.println("INPUT ERROR!");
			}

		}

	}

	private static void printCalendar(int year, int month, int day) {

		String[] weeks = { "Saturday", "Sunday", " MonDay", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		int dayNum = getDayNum(year, month, day);

		String dayOf = weeks[dayNum % 7];

		int fristDayNum = getDayNum(year, month, 1);

		System.out.println(year + ". " + month);
		System.out.println("sun mon tue wed thu fri sat ");

		String[] calendar  = createCalendar(getMonth(year, month), fristDayNum);

		for(int i=0; i<calendar.length; i++) {
			if(i < 10 && calendar[i] == null) {
				System.out.print("    ");
			} else if( i > 27 && calendar[i] == null) {
				break;
			} else {
				System.out.print(calendar[i]);
			}
			
			if((i+1) % 7 == 0) {
				System.out.println();
			}
		}
		
		System.out.println();
		System.out.println(dayOf);

	}

	private static String[] createCalendar(int monthDays, int fristDayNum) {
		String[] result = new String[monthDays + 14];
		int startDay = (fristDayNum%7) - 1;
		
		if(startDay == -1) {
			startDay = 6;
		}
		
		for(int i=0; i<monthDays; i++) {
			String temp;
			
			if(i<9) {
				temp = "  ";
			}else {
				temp = " ";
			}
			
			result[startDay+i] = temp+(i+1)+" ";
		}
		
		
		return result;
	}

	private static int getMonth(int year, int month) {

		boolean isLeapYear = false;

		if (year >= 2000 && year <= 2010) {
			if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
				isLeapYear = true;
			}
		}
		
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		default:
			if (isLeapYear) {
				return 29;
			} else {
				return 28;
			}
		}
	}

	private static int getDayNum(int year, int month, int day) {
		long days = 0;

		try {

			String str = "" + year;

			if (month < 10) {
				str += ("0" + month);
			} else {
				str += month;
			}

			if (day < 10) {
				str += ("0" + day);
			} else {
				str += day;
			}

			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			Date begin = formatter.parse("20000101");
			Date end = formatter.parse(str);

			long time = end.getTime() - begin.getTime();
			days = time / (24 * 60 * 60 * 1000);

		} catch (Exception e) {
			System.err.println(e);
		}

		return (int) days;
	}

	private static boolean checkDay(int year, int month, int day) {

		boolean isLeapYear = false;

		if (year >= 2000 && year <= 2010) {
			if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
				isLeapYear = true;
			}
		} else {
			return false;
		}

		if (month < 1 || month > 12) {
			return false;
		}

		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			if (day < 1 || day > 31) {
				return false;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			if (day < 1 || day > 30) {
				return false;
			}
			break;
		default:
			if (isLeapYear) {
				if (day < 1 || day > 29) {
					return false;
				}
			} else {
				if (day < 1 || day > 28) {
					return false;
				}
			}
			break;
		}

		return true;
	}

}
