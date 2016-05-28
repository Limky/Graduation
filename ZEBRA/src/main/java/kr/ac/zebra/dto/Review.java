package kr.ac.zebra.dto;

public class Review {

	private String id;
	private String barcode;
	private String reviewText;
	private double starPoint;
	private String level;
	private String memberUrl;
	private String productUrl;

	public String getProductUrl() {
		return productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	public Review() {

	}

	public Review(String id, String barcode, String reviewText, double starPoint, String level) {
		super();

		this.id = id;
		this.barcode = barcode;
		this.reviewText = reviewText;
		this.starPoint = starPoint;
		this.level = level;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	public double getStarPoint() {
		return starPoint;
	}

	public void setStarPoint(double starPoint) {
		this.starPoint = starPoint;
	}

	public String getMemberUrl() {
		return memberUrl;
	}

	public void setMemberUrl(String memberUrl) {
		this.memberUrl = memberUrl;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "{\"id\"=\"" + id + "\", \"reviewText\"=\"" + reviewText + "\", \"starPoint\"=" + starPoint
				+ ", \"level\"=\"" + level + "\", \"memberUrl\"=\"" + memberUrl + "\", \"productUrl\"=\"" + productUrl
				+ "\"}";
	}

}
