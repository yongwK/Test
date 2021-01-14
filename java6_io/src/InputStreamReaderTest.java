import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest {

	public InputStreamReaderTest() {
		char a[] = new char[10];
		for(char b : a) {
			System.out.println(b);
		}
		try {
			// 콘솔에서 문자단위 입력하는 클래스                      InputStream 객체를 넣어줘야 하는데 --> System.in 이다.
			InputStreamReader isr = new InputStreamReader(System.in);
			
			System.out.println("문자입력 = ");
			while(true) {
				// 한번에 1문자(char)읽어온다.        // char 문자로 읽어오니까 한글이 깨지지 않는다.
				/*
				int inData = isr.read();	
				if(	inData==-1 ) break;
				System.out.println(inData +"--->" + (char)inData);	
				*/
				// 한거번에 여러문자를 읽어서 배열에 저장한다. 배열의 크기만큼 읽는다 
				// char 배열을 이용하여 여러문자를 한번에 읽어오기
				
				char[] inData = new char[30];
				// 읽은 문자의 수
				int cnt = isr.read(inData);
				
				String inStr1 = new String(inData,0,cnt);
				String inStr2 = String.valueOf(inData,0,cnt);
				
				System.out.println(inStr1 + "-----");
				System.out.println(inStr2 + "======");
				
			}
			
			
			
		}catch(IOException e ) {
			System.out.println(e.getMessage());
		}
	
	}

	public static void main(String[] args) {
		new InputStreamReaderTest();

	}

}
