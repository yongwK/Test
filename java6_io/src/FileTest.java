import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileTest {

	public FileTest() {
		//File 객체 생성 : 드라이브명, 폴더명, 파일명 반드시 '절대주소'    [절대주소 -> 드라이브 부터 시작되야함 D://~ / C://~]
		File f1 = new File("D://javaIO"); //없는 경로도 만들수있음
		File f2 = new File("D://io/oracle.sql");
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
		
		//마지막수정일 얻어오기
		// 현재 날자의 데이터를 밀리초로 가지고온다.
		long lastDate = f2.lastModified();
		System.out.println("lastDate = " + lastDate);  
		
		
		//밀리초를 날자로 변환
		Calendar now = Calendar.getInstance(); //현재날자
		//밀리초를 Calendar에 셋팅
		now.setTimeInMillis(lastDate);
		//2021-01-12 오후 03:01
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd a hh:mm");
		String lastDateStr = sdf.format(now.getTime());
		System.out.println("lastDateStr = "+ lastDateStr);
		
		
		//
		System.out.println("canExecute="+f2.canExecute()); //실행가능?
		System.out.println("canRead="+f2.canRead()); // 읽기가능?
		System.out.println("canWrite="+f2.canWrite()); // 쓰기가능?
		System.out.println("isfile = " + f2.isFile()); //파일이니?
		System.out.println("isDirectory ="+ f2.isDirectory()); // 디렉토리니?
		System.out.println("======================================================================");
		
		//listFiles() --> File[]                // 폴더와 파일을 구해 문자열로 해주는건 list() -->String[]
		// 특정드라이브 또는 특정 폴더의 폴더목록, 파일목록을 구한다.
		File f4 = new File("C://");
		File file[] = f4.listFiles();
		// getPath() : 드라이브명, 경로, 파일명
		// getAbsoluteName() : 드라이브명, 경로, 파일명
		// getName() : 파일명
		// getParent() : 드라이브명, 경로
		// isHiden() :
		for( File f : file) {
			if(f.isDirectory()) {
				if(f.isHidden()) {
					System.out.println(f.getPath()+"[숨긴폴더]");
				}else {
					System.out.println( f.getPath() + "[폴더]" );
				} 
			}else if ( f.isFile()) {
				if(f.isHidden()) {
					System.out.println(f.getPath()+ "[숨긴파일]");
				}else {
					System.out.println(f.getPath()+ "[파일]");
				}
			}
		}
		System.out.println("======================================================================");
		
		
		
		//현재 컴퓨터의 드라이브 목록
		File[] drive = File.listRoots();
		for(File f : drive)		{ System.out.println(f.getPath()); }
		
		// 파일크기(byte)
		long size = f2.length();
		System.out.println("file size -->" + size+"byte");
		
		// 파일 삭제
		f3.delete();
		System.out.println("파일이 삭제됨....");
		
		
		
	}///FileTest() 생성자 메소드 끝

	public static void main(String[] args) {
		new FileTest();

	}

}
