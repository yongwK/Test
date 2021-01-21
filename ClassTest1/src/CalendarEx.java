import java.util.Calendar;
import java.util.Scanner;

public class CalendarEx {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		System.out.print("년도=");
		int year = sc.nextInt();
		System.out.print("월=");
		int month = sc.nextInt();
		
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, 1);
		
		
		int week = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(week);
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
	
		System.out.printf("\t\t %d년 %d월\n",year,month);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
				
		for(int space = 1; space < week; space++) { 
			System.out.print("\t");
		}
			
		for(int day = 1; day<=lastDay; day++) {
			System.out.print(day+"\t");
			if((day + (week-1)) % 7 == 0) {
				System.out.println();
			}
		}
	}
}
		
	/*
import java.util.Calendar;
import java.util.Scanner;

public class CalendarEx {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		// 년도 
		
		// 월 입력
		System.out.print("년도=");
		int year = sc.nextInt();
		System.out.print("월=");
		int month = sc.nextInt();
		
		Calendar cal = Calendar.getInstance();//오늘 날자 + 시간
		
		//날짜를 1일로 변경
		cal.set(year, month-1, 1);
		
		// 1일에 대한 요일 구하기
		int week = cal.get(Calendar.DAY_OF_WEEK);
		
		
		// 31 -> 1 3 5 7 8 10 12
		// 30 -> 4 6 9 11
		// 28, 29 -> 2
		
		/*
		int lastDay = 31;
		
		switch(month) {
			case 4: case 6: case 9: case 11:
				lastDay = 30; break;
			
			case 2: // 출력할 달이 2월인경우
				if( year % 4 == 0 && year % 100 !=0 || year % 400 ==0) {
					lastDay = 29; break;
				}
				else {  // 윤년이 아닐떄
					lastDay = 28;
				}			
		}*/
		/*
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	//====================================================정보 모은거
		// 제목 출력
		System.out.printf("\t\t %d년 %d월\n",year,month);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		
		//공백 출력 
		for(int space = 1; space < week; space++) { //1,2,3,4
			System.out.print("\t");
		}
		
		// 날짜 출력
		for(int day = 1; day<=lastDay; day++) {
			System.out.print(day+"\t");
			if((day + (week-1)) % 7 == 0) {
				System.out.println();
			}
		}
		
			 
	*/

