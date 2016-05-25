package zebra.beans;

/**
 * Created by multimedia on 2016-05-25.
 */
public class SearchItem {

    public String productUrl;
    public String productName;
    public double ratingBar;

    public SearchItem(String productUrl, String productName, double ratingBar){
        this.productUrl = productUrl;
        this.productName = productName;
        this.ratingBar = ratingBar;
    }
}
