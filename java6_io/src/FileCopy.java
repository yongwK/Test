import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;

//직렬화를 하여 개체를 파일로 저장하도록 한다.
public class FileCopy implements Serializable{

	public FileCopy() {		}

	public void start() {
		try {
			//파일복사
			// 바다사진 파일을 복사해서 javaio 폴더에 넣을거임
			File srcFile = new File("d://바다사진.png");
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
	
//	public static void main(String[] args) {
//		new FileCopy().start();
//
//	}

}
