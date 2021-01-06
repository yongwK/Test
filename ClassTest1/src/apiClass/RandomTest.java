package apiClass;

import java.util.Random;

public class RandomTest {

	public RandomTest() {
		start();
	}
	
	public void start() {
		//Random Class : 난수 클레스
	
		Random ran = new Random();
		for(int i = 1; i<1000; i++) {
			//boolean ranboo = ran.nextBoolean(); //논리형 :  true, false
			//double result = ran.nextDouble();
			int result = ran.nextInt();
			
			result = ran.nextInt(100); // 100 -> 0 ~ 99사이의 난수 값 출력 50 -> 0 ~ 49 
			result = ran.nextInt(60)+1; // \ 10 ~ 40사이  난수 * (큰-작+1) || + 작은수
			
			System.out.print(result + "\t");
			if(i%10==0) System.out.println();
		}
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		new RandomTest();

	}

}
