
public class UpdateTest extends DBConn{ // DBconn 상속

	public UpdateTest() {
		
	}
	public void setUpdate() {
		try {
			getConn(); // DB 연결
			sql="update member set tel=? where username=?";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "010-5555-5555");
			pstmt.setString(2, "장영실");
			
			// 실행
			// 데이터 수정이니 Update : insert, update, delete
			int result=pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println(result+" 개의 레코드가 수정되었습니다");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose(); // db 연결 해제
		}
	}
	public static void main(String[] args) {
		new UpdateTest().setUpdate();
	}

}
