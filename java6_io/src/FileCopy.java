import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopy {

	public FileCopy() {
		
		try {
			//파일복사
			// 바다사진 파일을 복사해서 javaio 폴더에 넣을거임
			File srcFile = new File("d://바다사진.jpg");
			//쓰기할곳
			File tarFile = new File("d://io", srcFile.getName() );
			
			FileInputStream fi = new FileInputStream(srcFile);
			FileOutputStream fo = new FileOutputStream(tarFile);
			
			while(true) {
				int inData = fi.read();
				if(inData == -1) break;
				fo.write(inData);
				
			}
			fo.flush();
			fo.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

	public static void main(String[] args) {
		new FileCopy();

	}

}
