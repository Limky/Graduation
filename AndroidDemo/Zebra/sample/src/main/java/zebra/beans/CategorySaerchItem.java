package zebra.beans;

/**
 * Created by multimedia on 2016-05-29.
 */
public class CategorySaerchItem {
    public String productUrl;
    public String productName;
    public double ratingBar;
    public String barcode;

    public CategorySaerchItem(String productUrl, String productName, double ratingBar, String barcode){
        this.productUrl = productUrl;
        this.productName = productName;
        this.ratingBar = ratingBar;
        this.barcode = barcode;
    }
}
