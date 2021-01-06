import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class LottoCollection2 {
	Scanner sc = new Scanner(System.in);
	Random ran = new Random();
	public LottoCollection2() {
		
		
		
				TreeSet<Integer> ti = new TreeSet<Integer>();
				
				while(true) {
					ti.add(ran.nextInt(45)+1);
					if(ti.size()==7) {
						break;
					}
				}
			
				System.out.println(ti.size());
			
				
				Iterator<Integer> ii = ti.iterator();
				
				System.out.print(  "게임 : [");
				for(int i = 0; i<ti.size()-1; i++) {
					System.out.print(ii.next()+" ");
				}
				System.out.print("], 보너스 숫자 :");
				System.out.println(ti.pollLast());
			
	
	}
		
	
	
	
	public static void main(String[] args) {
		new LottoCollection();
		

	}

}
