import java.io.File;
import java.io.IOException;

public class FileTest {

	public FileTest() {
		//File 객체 생성 : 드라이브명, 폴더명, 파일명 반드시 '절대주소'    [절대주소 -> 드라이브 부터 시작되야함 D://~ / C://~]
		File f1 = new File("D://javaIO"); //없는 경로도 만들수있음
		File f2 = new File("D://io/MainTest.java");
		File f3 = new File(f1, "Test.txt");
		
		//폴더생성하기
		//exists() :  폴더 또는 파일이 존재하는지 확인 반환형이 boolean ( true : 있다,, false : 없다);
		if(!f1.exists()) { // 폴더가 없으면 참 !있어서
			if(f1.mkdirs()) {     // mkdirs() -- > return boolean type
				System.out.println("폴더가 생성됨...");
			}
			else {
				System.out.println("폴더가 생성실패");
			}
		}
		
		//파일생성
		if(!f3.exists()) {
			try {
				if(f3.createNewFile()) {            // createNewFile() -- > return boolean  파잃생성 됬는지 않됬는지 true false로 확인
					System.out.println("파일이 생성됨");
				}
				else {
					System.out.println("파일생성 실패");
				}
			}catch(IOException e) {
				
			}
			
		}

	}///FileTest() 생성자 메소드 끝

	public static void main(String[] args) {
		new FileTest();

	}

}
