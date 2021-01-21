import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class WriteExcel {
	/*
	
		자바에서 excel로 쓰기 읽기
	
		jakarta.apache.org 에서 
	 	왼쪽에서 POI
	 	맨위 다운로드 클릭
	 	바이너리에서 poi-bin-5.0.0-20210120.zip  다운로드클릭
	 	페이지 옴겨진데서 아무거나 클릭해서 다운로드 받아야한다.
	 	
	 	poi.5.0.0.jar, commons.math3-3.6.1.jar
	 	buildPath 설정 ->project에서 마우스 오른쪽 buildPath 선택
		
		library - classpath - add extends jars
	 *
	 */
	
	
	
	public WriteExcel() {
		// 엑셀로 쓰기
		
		// 1. workbook객체 생성
		HSSFWorkbook workbook = new HSSFWorkbook();
		
		// 2. sheet객체 생성.
		HSSFSheet sheet1 = workbook.createSheet("회원목록");
		HSSFSheet sheet2 = workbook.createSheet();
		
		// 3. row객체 생성
		HSSFRow row1 = sheet1.createRow(0);
		
		//4. cell객체 생성
		HSSFCell cell1 = row1.createCell(0);
		
		//5. value 셋팅
		cell1.setCellValue("번호");
		
		row1.createCell(1).setCellValue("이름"); // 한번에 만들수도 있다.
		row1.createCell(2).setCellValue("연락처");
		row1.createCell(3).setCellValue("이메일");
		
		////////////////////////////////////////
		String data[][] = {
				{"1","홍길동","010-1234-5678","aaaaa@nate.com"},
				{"2","김길동","010-1111-2222","bbbbb@nate.com"},
				{"3","박길동","010-7777-8888","ccccc@nate.com"},
				{"4","이길동","010-1234-2222","eeeee@nate.com"},
				{"5","최길동","010-8888-5678","fffff@nate.com"},
		};
		
		
		for(int r = 0; r<data.length; r++) { //1,2,3,4,5
			HSSFRow cRow = sheet1.createRow(r+1);
			for(int c=0; c<data[r].length;c++) { // 0,1,2,3
				if(c==0) {
					//번호를 숫자로 변경
					cRow.createCell(c).setCellValue(Integer.parseInt(data[r][c]));
				}else {
					cRow.createCell(c).setCellValue(data[r][c]);
				}
			}
		}
		
		//
		File f = new File("d://javaIO/member.xls");
		
		// 파일로 쓰기
		try {
			FileOutputStream fos = new FileOutputStream(f);
			workbook.write(fos);
			workbook.close();
			
		}catch(Exception e) {
			
		}
		System.out.println("엑셀로 쓰기완료");
		
		
	}
	
	public static void main(String[] args) {
		new WriteExcel();
	}

}
