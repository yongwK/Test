import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderTest {

	public BufferedReaderTest() {
		
		try {
			//한줄 단위로 입력할수 있는 클래스			    매개변수 InputStream --> System.in -->리턴값이 InputStream
			InputStreamReader isr = new InputStreamReader(System.in);
			//								매개변수--> Reader -> InputStreamReader
			BufferedReader br = new BufferedReader(isr);
			
			System.out.println("문자열입력=");
			//한줄 단위로 입력할수 있는 클래스, 매서드 readLine()
			//return 값이 null 인경우는  읽어온 데이터가 없다.
			String inData = br.readLine();
			System.out.println("inData=" + inData);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new BufferedReaderTest();

	}

}
