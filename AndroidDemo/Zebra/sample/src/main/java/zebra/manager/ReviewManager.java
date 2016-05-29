package zebra.manager;

import zebra.json.Review;

/**
 * Created by multimedia on 2016-05-27.
 */
public class ReviewManager {

    public static ReviewManager instance;
    public static ReviewManager getInstance(){
        if(instance == null){
            instance = new ReviewManager();
        }
        return instance;
    }

    Review review;

    public void setReview(Review review){
        this.review = review;
    }

    public Review getReview(){
        return review;
    }

    public void clearReview(){
        review = null;
    }
}
