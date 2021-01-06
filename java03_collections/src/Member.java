import java.util.Vector;

public class Member{
		int no = 1234;
		String username = "세종대앙";
		String tel = "010-4567-7890";
		String addr = "서울시 매포구 백범로";

		public Member() {
			
			
		}
		public Member(int no, String username, String tel, String addr) {
			this.no = no;
			this.username = username;
			this.tel = tel;
			this.addr = addr;
			
		}
		public void memberPrn() {
			System.out.printf("%d, %s, %s, %s\n", no, username, tel, addr);
		}
}
