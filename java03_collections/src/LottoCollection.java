import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class LottoCollection {
	Scanner sc = new Scanner(System.in);
	public LottoCollection() {
		
		
	
	}
		
	
	public void start() {
		do {
			// 게임수
			int cnt = gameCount();
			for(int i = 1; i<=cnt; i++) { //1 2 3
				System.out.print(i + "게임=");
				createLotto();
			}
			// true : 계속, false : 중지
			if(!qna()) {
				break;
			}
			
		}while(true);
		
		System.out.println("--------------------------The End--------------------------");
	}
	
	
	//게임수 입력
	public int gameCount() {
		int intCnt = 0;
		do {
			try {
				System.out.println("게임수=");
				intCnt = Integer.parseInt(sc.nextLine());        // "5" "dfd" "-5" "0"
				//게임의 수가 0이거나 양수가 아닌경우
				if(intCnt <= 0) {
					// 예외 발생
					throw new Exception("게임수는 1보다 큰 값이이어야 합니다..");
				}
				break; // 게임수가 입력되었을때
			}catch(NumberFormatException nfe) {
				System.out.println("게임수는 정수만 입력해야 합니다.");
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}	
		}while(true);
		return intCnt;
	}
		
	
	//로또 1게임 만드는 메서드
	public void createLotto() {
		
		Random ran = new Random();
		TreeSet<Integer> ts = new TreeSet<Integer>();
		int lastNum = 0;
		// 생서 -> TreeSet --> 7개가 될때까지
		while(true) {
			lastNum = ran.nextInt(45)+1; // 1~45 마지막으로 만들어진 번호 
			ts.add(lastNum);
			if(ts.size()==7) {
				break;
			}
		}
		//// 마지막으로 생성된 번호는 보너스이므로 TreeSet에서 제거한다.
		ts.remove(lastNum);
		System.out.print(ts.toString());  //[ , , , , , ]
		System.out.println(", bonus = " + lastNum);
	}
	
	
	// 계속 여부 확인    true : 계속, false : 그만
	public boolean qna() {
		boolean boo = false;
		do {	
			System.out.println("계속하시겠습니까(Y or y : 예, N or n : 아니오)?");
			String que= sc.nextLine();
			
			if(que.equalsIgnoreCase("Y")) { // "Y".equalsIgnoreCase(que); 사용해도 가능
				boo = true;
				break;
			}else if(que.equalsIgnoreCase("N")) {
				boo = false;
				break;
			}else {
				System.out.println(" Y or N 을 입력하세요");
			}
		}while(true);
		
		return boo;
	}
	
	public static void main(String[] args) {
		LottoCollection lotto = new LottoCollection();
		lotto.start();
		

	}

}
