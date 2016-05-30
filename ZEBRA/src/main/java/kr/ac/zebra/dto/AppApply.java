package kr.ac.zebra.dto;

public class AppApply {

	private String barcode;
	private String id;
	private String productName;

	public AppApply() {

	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "AppApply [barcode=" + barcode + ", id=" + id + ", productName=" + productName + "]";
	}

}
