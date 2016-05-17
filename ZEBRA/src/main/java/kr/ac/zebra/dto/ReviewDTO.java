package kr.ac.zebra.dto;

public class ReviewDTO {
	private int index;
	private String id;
	private String barcode;
	private String reviewText;
	private int starPoint;

	public ReviewDTO() {

	}

	public ReviewDTO(int index, String id, String barcode, String reviewText, int starPoint) {
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

	public int getStarPoint() {
		return starPoint;
	}

	public void setStarPoint(int starPoint) {
		this.starPoint = starPoint;
	}

	@Override
	public String toString() {
		return "ReviewDTO [index=" + index + ", id=" + id + ", barcode=" + barcode + ", reviewText=" + reviewText
				+ ", starPoint=" + starPoint + "]";
	}

}
