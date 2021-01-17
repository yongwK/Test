import java.io.IOException;
import java.io.InputStream;

public class InputStreamTest {

	public InputStreamTest() {
		try {
			//InputStream 클래스는 추상클래스로 객체 생성할수 없다.
			// System.in 을 통해서  객체를 생성한다.
			//InputStream 은 byte 단위로 입력받는 클래스
			InputStream is = System.in;
			
			System.out.println("입력 = ");
			
			while(true) {
				/*
				//read() -> 입력문자를 1byte 씩 읽어온다.
				int inData = is.read(); //읽은 데이터가 없을때 -1 입력
				if(inData == -1) break;
				System.out.println(inData + "," + (char)inData);
				
				
				
				//read(byte[] b) : 배열의 크기만큼 한번에 읽어온다.
				byte[] inData = new byte[10];         // 5byte일고 출력 5byte읽고 출력 
				// byte 수			   읽은 byte는 배열에 저장
				int cnt = is.read(inData);
				//System.out.println(new String(inData) +"--->" +cnt); // 비어있는 칸까지 같이 출력됨
				System.out.println(new String(inData,0,cnt) +"--->" +cnt); // 입력된 문자수까지만 출력
				
				if(cnt<=0) break;
				*/
				
				//       읽어온데이터를 담을 배열, 배열의 저장위치 index, 읽어올 byte갯수
				//read(byte[] int,int
				byte inData[] = new byte[10];
				int cnt = is.read(inData, 3, 4);
				for(int i = 0; i<inData.length; i++) {
					System.out.println("inData[" + i + "]=" + inData[i]);
				}
				
			}
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		new InputStreamTest();

	}

}
