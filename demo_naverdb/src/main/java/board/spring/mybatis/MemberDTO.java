package board.spring.mybatis;

import org.springframework.stereotype.Component;

@Component
public class MemberDTO {
	
	String memberid;
	String pw;
	String membername;
	String phone;
	String email;
	String regdate;
	
	public MemberDTO(String memberid, String membername, String phone, String email) {
		super();
		this.memberid = memberid;
		this.membername = membername;
		this.phone = phone;
		this.email = email;
	}
	
	public MemberDTO() {System.out.println("MemberDTO 기본 생성자 호출");}

	public MemberDTO(String memberid, String pw, String membername, String phone, String email, String regdate) {
		super();
		this.memberid = memberid;
		this.pw = pw;
		this.membername = membername;
		this.phone = phone;
		this.email = email;
		this.regdate = regdate;
	}

	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "{\"memberid\"=\"" + memberid + "\", \"pw\"=\"" + pw + 
				"\", \"membername\"=\"" + membername + "\", \"phone\"=\"" + phone + 
				"\", \"email\"=\"" + email + "\", \"regdate\"=\"" + regdate + "\"}";
	}
	
}
