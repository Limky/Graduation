package kr.ac.zebra.dto;

public class AppReview {
	private int index;
	private String id;
	private String barcode;
	private String reviewText;
	private double starPoint;
	private String memberUrl;
	private String productUrl;

	public String getProductUrl() {
		return productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	public AppReview() {

	}

	public AppReview(int index, String id, String barcode, String reviewText, double starPoint) {
		super();
		this.index = index;
		this.id = id;
		this.barcode = barcode;
		this.reviewText = reviewText;
		this.starPoint = starPoint;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
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

	@Override
	public String toString() {
		return "{\"id\"=\"" + id + "\", \"reviewText\"=\"" + reviewText + "\", \"starPoint\"=" + starPoint
				+ ", \"memberUrl\"=\"" + memberUrl + "\", \"productUrl\"=\"" + productUrl + "\"}";
	}

}
