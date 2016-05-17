package kr.ac.zebra.dto;

public class Enterprise {

	private String companyName;
	private String email;
	private String password;

	public Enterprise() {

	}

	public Enterprise(String companyName, String email, String password) {
		super();
		this.companyName = companyName;
		this.email = email;
		this.password = password;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	@Override
	public String toString() {
		return "Enterprise [companyName=" + companyName + ", email=" + email + ", password=" + password + "]";
	}

}
