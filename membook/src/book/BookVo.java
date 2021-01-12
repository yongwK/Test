package book;

public class BookVo {
	private int bNo;
	private String bName;
	private String bAuthor;
	private String bPublisher;
	private String bAble;
	
	public BookVo() {}
	
	public BookVo(int bNo, String bName, String bAuthor, String bPublisher, String bAble) {
	this.bNo = bNo;
	this.bName = bName;
	this.bAuthor = bAuthor;
	this.bPublisher = bPublisher;
	this.bAble = bAble;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbAuthor() {
		return bAuthor;
	}

	public void setbAuthor(String bAuthor) {
		this.bAuthor = bAuthor;
	}

	public String getbPublisher() {
		return bPublisher;
	}

	public void setbPublisher(String bPublisher) {
		this.bPublisher = bPublisher;
	}

	public String getbAble() {
		return bAble;
	}

	public void setbAble(String bAble) {
		this.bAble = bAble;
	}

	public void bookPrt() {
		System.out.println(bNo + "\t" + bName + "\t" + bAuthor + "\t" + bPublisher + "\t" + bAble +"\n");
	}
	
	
	
}
