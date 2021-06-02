package VO;

public class SignUpVO {
	private String id;
	private String pw;
	private String pw2;
	private String name;
	private String regno;


	public SignUpVO(String id, String pw, String pw2, String name, String regno) {
		this.id = id;
		this.pw = pw;
		this.pw2 = pw2;
		this.name = name;
		this.regno = regno;
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
	
	public String getPw2() {
		return pw2;
	}

	public void setPw2(String pw2) {
		this.pw2 = pw2;
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

	@Override

	public String toString() {

		String str = String.format("아이디:%s \n이름:%s \n주민번호:%s \n",

				id, name, regno);

		return str;

	}

	

}
