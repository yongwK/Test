import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	public FileReaderTest() {
		File f = new File("d://io/oracle.sql");
			
		try{
			FileReader fr = new FileReader(f);
			//FileReader fr = new FileReader("d://io/oracle.sql");   같은방법이다 하지만 f 처럼 경로를 만들어 놓고 사용함
			
			BufferedReader br = new BufferedReader(fr);
			
			while(true) {
				/*
				
				int read = fr.read();
				if(read == -1) break;
				System.out.print((char)read);
				*/
				
				
				String read = br.readLine();  // 엔터가 있는 곳까지 한줄  // 읽을 데이터가 없으면 read 에 null이 들어간다.
				if( read == null) { break; }
				System.out.println(read); // 엔터를 안읽기 떄문에 println 떄문에 줄바꿈이 된다. 
		
		
		
		
			}
		
		
		}catch(FileNotFoundException fnfe) {
			System.out.println("파일이 존재하지 않습니다.");
		}catch(IOException e) {
			System.out.println("파일읽기 에러");
		}
		
	
	
	}

	public static void main(String[] args) {
		new FileReaderTest();

	}

}

