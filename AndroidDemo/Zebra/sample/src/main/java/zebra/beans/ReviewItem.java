package zebra.beans;

/**
 * Created by multimedia on 2016-05-13.
 */
public class ReviewItem {
    public int profileImage;
    public String memberId;
    public double ratingBar;
    public String reviewText;


    public ReviewItem(int profileImage, String memberId, double ratingBar, String reviewText){
        this.profileImage = profileImage;
        this.memberId = memberId;
        this.ratingBar = ratingBar;
        this.reviewText = reviewText;
    }
}
