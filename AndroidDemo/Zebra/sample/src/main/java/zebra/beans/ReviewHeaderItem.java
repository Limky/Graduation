package zebra.beans;

/**
 * Created by multimedia on 2016-05-26.
 */
public class ReviewHeaderItem {
    public String productUrl, productName, description;
    public double ratingBar;

    public ReviewHeaderItem(String productUrl, String productName, String description, double ratingBar){
        this.productUrl = productUrl;
        this.productName = productName;
        this.description = description;
        this.ratingBar = ratingBar;
    }
}
