import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Calendar;

public class ObjectInputStreaTest {

	public ObjectInputStreaTest() {
		try {
			// 파일의 객체를 얻어오기
			File f = new File("d://javaIO/Object.txt");
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			//첫번쨰 객체 읽어오기
			ArrayList al =	(ArrayList)ois.readObject();			
			
			//두번째 객체 읽어오기
			DataVO vo = (DataVO)ois.readObject();
			
			//--------------------------------------------------
			String userName = (String)al.get(0);
			Calendar date = (Calendar)al.get(1);
			FileCopy copy = (FileCopy)al.get(2);
			
			System.out.println("arrayList.String->"+ userName); // 홍길동
			System.out.println("arrayList.calendar->"+date); // 시분..10:7
			copy.start();//FileCopy 호출
			
			System.out.printf("dateVo->%d, %s, %s, %s \n", vo.getNum(), vo.getName(), vo.getTel(), vo.getEmail());
		}catch(Exception e) {
			e.printStackTrace();
		}

		
	}
	
	
	
	
	public static void main(String[] args) {
		new ObjectInputStreaTest();
	}
}
