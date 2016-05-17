package kr.ac.zebra.dto;

public class Member {
	
	private String id;
	private String password;
	private String name;
	private String memberUrl;
	private String lastReviewDate;
	private String phoneNumber;
	private int point;
	private int level;
	private int reviewCount;
	private int totalReviewCount;
	
	public Member(){
		
	}
	
	public Member(String id, String password, String name, String phoneNumber, int point, int level, String memberUrl,
			String lastReviewDate, int reviewCount, int totalReviewCount) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.point = point;
		this.level = level;
		this.memberUrl = memberUrl;
		this.lastReviewDate = lastReviewDate;
		this.reviewCount = reviewCount;
		this.totalReviewCount = totalReviewCount;
	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getMemberUrl() {
		return memberUrl;
	}
	public void setMemberUrl(String memberUrl) {
		this.memberUrl = memberUrl;
	}
	public String getLastReviewDate() {
		return lastReviewDate;
	}
	public void setLastReviewDate(String lastReviewDate) {
		this.lastReviewDate = lastReviewDate;
	}
	public int getReviewCount() {
		return reviewCount;
	}
	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}
	public int getTotalReivewCount() {
		return totalReviewCount;
	}
	public void setTotalReivewCount(int totalReviewCount) {
		this.totalReviewCount = totalReviewCount;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", password=" + password + ", name=" + name + ", phoneNumber=" + phoneNumber
				+ ", point=" + point + ", level=" + level + ", memberUrl=" + memberUrl + ", lastReviewDate="
				+ lastReviewDate + ", reviewCount=" + reviewCount + ", totalReviewCount=" + totalReviewCount + "]";
	}
	
	
	
	
}
