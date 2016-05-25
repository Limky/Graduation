package zebra.views;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import example.zxing.R;
import zebra.beans.ReviewItem;

/**
 * Created by multimedia on 2016-05-13.
 */
public class ReviewItemView extends FrameLayout{
    ImageView profileImage;
    TextView memberId;
    RatingBar ratingBar;
    TextView reviewText;

    public ReviewItemView(Context context) {
        super(context);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.review_item, this);

        profileImage = (ImageView) findViewById(R.id.profileImage);
        memberId = (TextView)findViewById(R.id.memberId);
        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        reviewText = (TextView)findViewById(R.id.reviewText);
    }

    public void setViewItem(ReviewItem item) {

        profileImage.setImageResource(item.profileImage);
        memberId.setText(item.memberId);
        ratingBar.setRating((float)item.ratingBar);
        reviewText.setText(item.reviewText);
    }
}
