package kr.ac.zebra.dto;

public class Product {

	private String barcode;
	private String productName;
	private String description;
	private String category;
	private String productUrl;
	private String companyName;
	private int scanCount;
	private int totalReviewCount;
	private double starPoint;
	
	
	
	public Product(){
			
		
	}

	public Product(String barcode, String productName, String description, String category, String productUrl,
			String companyName, int scanCount, int totalReviewCount, double starPoint) {
		super();
		this.barcode = barcode;
		this.productName = productName;
		this.description = description;
		this.category = category;
		this.productUrl = productUrl;
		this.companyName = companyName;
		this.scanCount = scanCount;
		this.totalReviewCount = totalReviewCount;
		this.starPoint = starPoint;
	}
	
	
	public String getBarcode() {
		return barcode;
	}



	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getProductUrl() {
		return productUrl;
	}



	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}



	public String getCompanyName() {
		return companyName;
	}



	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}



	public int getScanCount() {
		return scanCount;
	}



	public void setScanCount(int scanCount) {
		this.scanCount = scanCount;
	}



	public int getTotalReviewCount() {
		return totalReviewCount;
	}



	public void setTotalReviewCount(int totalReviewCount) {
		this.totalReviewCount = totalReviewCount;
	}



	public double getStarPoint() {
		return starPoint;
	}



	public void setStarPoint(double starPoint) {
		this.starPoint = starPoint;
	}

	
	@Override
	public String toString() {
		return "Product barcode=" + barcode + ", productName=" + productName + ", description=" + description
				+ ", category=" + category + ", productUrl=" + productUrl + ", companyName=" + companyName
				+ ", scanCount=" + scanCount + ", totalReivewCount=" + totalReviewCount + ", starPoint=" + starPoint;
	}


	
	
}
