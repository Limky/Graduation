package zebra.beans;

/**
 * Created by multimedia on 2016-05-29.
 */
public class MyReviewItem {

    public String productImage;
    public String memberId;
    public double ratingBar;
    public String reviewText;

    public MyReviewItem(String productImage, String memberId, double ratingBar, String reviewText){
        this.productImage = productImage;
        this.memberId = memberId;
        this.ratingBar = ratingBar;
        this.reviewText = reviewText;
    }

}
