import java.io.File;
import java.io.FileWriter;

public class FileWriterTest {

	public FileWriterTest() {
		try {
			// 없는 파일명을 가지고 객체를 만듬
			File f = new File("d://io/test_file.txt"); 
			FileWriter fw = new FileWriter(f);
			String txt = "자바에서 문자열을 파일로 쓰기 연습!!!!!";
			
			
			//1.  배열로 저장    writw(
			//문자열을 char 배열로  생성              
			char c[] = txt.toCharArray();    
			fw.write(c, 5, c.length-5);        // 인덱스 0부터 배열의 길이만큼  , 내가 원하는 위치에서 시작할수 있고 시작한 곳만큼 길이에서 빼줘야한다.
			fw.flush();						//쓰기를 끝내고 나서  꼭 flush를 해줘야한다.
			
			
			//2. 문자열로쓰기
			fw.write(txt,0, txt.length());
			fw.flush();
			
			
			
			
			
			fw.close();  // 다쓰고나면 닫기
			
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("end......");
		
		
	}

	public static void main(String[] args) {
		new FileWriterTest();

	}

}
