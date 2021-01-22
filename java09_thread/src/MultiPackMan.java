
public class MultiPackMan {

	public MultiPackMan() {
		PackMan pm1 = new PackMan(1,1,500,500);
		PackMan pm2 = new PackMan(1,501,500,500);
		
		Thread t1 = new Thread(pm1);
		Thread t2 = new Thread(pm2);
		
		t1.start();
		t2.start();
	}

	public static void main(String[] args) {
		new MultiPackMan();

	}

}
