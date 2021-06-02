package VO;

public class LoginVO {
	private String id;
	private String pw;
	private String name;
	private String regno;
	private String point;

	public LoginVO(String id, String pw, String name, String regno, String point) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.regno = regno;
		this.point = point;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegno() {
		return regno;
	}

	public void setRegno(String regno) {
		this.regno = regno;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "\n\t\t\t\t[회원정보]\n\n\t회원아이디\t회원명\t\t    주민번호\t\t잔여포인트\n" 
	+"----------------------------------------------------------------------------------\n"+ 
				"\t  "+id + "\t\t" + name + " \t\t" + regno + "\t\t  " + point+
				"\n----------------------------------------------------------------------------------";
	}

}
