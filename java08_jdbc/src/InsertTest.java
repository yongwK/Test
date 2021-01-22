import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {
   // 2. Database 연결
      String url = "jdbc:oracle:thin:@localhost:1521:xe";
      String userid ="c##scott";
      String userpwd ="tiger";
      Connection conn=null; // 기존에는 try문의 지역 변수여서 catch문에서는 접근이 되지 않았기에 멤버 변수로 선언과 초기화함
      // 초기화된 변수여서 멤버 변수로 옮김
      
      // 1. jdbc 드라이브 로딩
      // 멤버 영역에 실행문을 사용하는 법
      static {
         try { // 예외 처리를 하지 않으면 Class.forName~~이 빨간 줄이 뜬다
            Class.forName("oracle.jdbc.driver.OracleDriver"); // 한 번만 실행되면 됨
            System.out.println("JDBC 드라이버가 로딩 되었습니다"); // 원래는 출력문을 넣을 수 없지만 static으로 묶어줘서 가능해짐
         }catch(Exception e) {
            System.out.println("JDBC 드라이브 로딩을 실패하였습니다==>"+e.getMessage());
         }
      }
   public InsertTest() {
      try {
         // 기존 1번의 자리
         
         Connection conn = DriverManager.getConnection(url,userid,userpwd); // getConnection은 실행문
         
         conn.setAutoCommit(false); // 커밋이 자동으로 되는 것을 막아줌
         
         // 기존 2번의 자리
         
         // 한글을 사용하고, inputstream은 객체를 생성할 수 없어 system 클래스를 넣는다
         InputStreamReader isr = new InputStreamReader(System.in);
         // InputStreamReader는 한 글자씩만 받아올 수 있어서 BufferedReader에 넣어준다 
         BufferedReader br = new BufferedReader(isr);
         
         do {
            System.out.print("이름=");
            String username = br.readLine();
            System.out.print("연락처= ");
            String tel = br.readLine();
            System.out.print("이메일= ");
            String email = br.readLine();
            System.out.print("주소= ");
            String addr = br.readLine();
            
            // 3. PreparedStatement를 생성(쿼리문을 만든다는 말)
            String sql = "insert into member(num, username, tel, email, addr, writedate)"
                  + "values(memsq.nextval,?,?,?,?,sysdate)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // ?에 값을 셋팅 
            pstmt.setString(1,username); // 해당 ?의 위치
            pstmt.setString(2, tel);
            pstmt.setString(3, email);
            pstmt.setString(4, addr);
            
            // 4.실행
            // executeQuery() : ResultSet을 반환, select
            // executeUpdate() : int를 반환, insert, update, delete
            int result = pstmt.executeUpdate();
            
            /*
            sql="insert into member(num, username, tel, email, addr, writedate) "
                  + "values(memsq.nextval, ?,?,?,?,sysdate)";
            pstmt=conn.prepareStatement(sql);
            
            pstmt.setString(1, "AAAAAAAAAAA");
            pstmt.setString(2, "010-4513-9874");
            pstmt.setString(3, "dfsfd@email.com");
            pstmt.setString(4, "서울시 금천구");
            
            int result2=pstmt.executeUpdate();
            
            if(result>0&&result2>0) {
            */
            if(result>0) {
               conn.commit();
               System.out.println("회원 등록되었습니다");
            }else {
               System.out.println("회원 등록을 실패하였습니다");
            }
            
         }while(true);
         
      }catch (Exception e) {
         // 예외가 발생하면 정상 실행된 쿼리실행문 취소(rollback)
         // conn.setAutoCommit(false);(자동으로 커밋이 안되게하기 때문)
         try { // conn.roll이 예외가 발생하므로 예외처리를 해준다
            conn.rollback();
         }catch(SQLException se) {
            se.printStackTrace();
         }
         e.printStackTrace();
      }
   }
   public static void main(String[] args) {
      new InsertTest();
   }
}