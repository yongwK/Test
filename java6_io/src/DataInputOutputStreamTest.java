import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputOutputStreamTest {

	public DataInputOutputStreamTest() {
		
		try {
			//DataOutputStream 매개변수에 대입하기 위해서 생성한 객체들
			File file = new File("d://io", "data.txt");
			FileOutputStream fos = new FileOutputStream(file);
			
			DataOutputStream dos = new DataOutputStream(fos);
			
			//byte : 1 short : 2 int : 4 long : 8byte
			// float : 4 double : 8byte
			// char : 2byte
			// boolean : 1byte
			int num = 125487;
			char str = 'Z';
			double num2 = 254836.3254;
			boolean boo = true;
			
			dos.writeInt(num);
			dos.writeChar(str);
			dos.writeDouble(num2);
			dos.writeBoolean(boo);
			dos.close();
			
			//읽어오기
			FileInputStream fis = new FileInputStream(file);
			DataInputStream dis = new DataInputStream(fis);
			
			int numIn = dis.readInt();
			char charIn = dis.readChar();
			double num2In = dis.readDouble();
			boolean booIn = dis.readBoolean();
			
			System.out.println("numIn=" + numIn);
			System.out.println("charIn=" + charIn);
			System.out.println("num2In=" + num2In);
			System.out.println("booIn=" + booIn);
	
		}catch(FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
		}catch(IOException ie) {
			System.out.println("쓰기 에러가 발생하였습니다.");
		}
		
		//원래 데이터 타입으로 저장하기, 불러오기
		// DataOutputStream, DataInputStream
	
		
	
		
	
	
	
	
	}
	

	public static void main(String[] args) {
		new DataInputOutputStreamTest();

	}

}
