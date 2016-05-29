package zebra.views;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import example.zxing.R;
import zebra.beans.ReviewHeaderItem;

/**
 * Created by multimedia on 2016-05-13.
 */
public class ReviewHeaderView extends FrameLayout {

    ImageView productImage;
    TextView productName, description;
    RatingBar ratingBar;

    public ReviewHeaderView(Context context) {
        super(context);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.review_header, this);

        productImage = (ImageView)findViewById(R.id.productImage);
        productName = (TextView)findViewById(R.id.productName);
        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        description = (TextView)findViewById(R.id.description);
    }

    public void setReviewHeader(ReviewHeaderItem reviewHeaderItem){
        Glide.with(getContext()).load(reviewHeaderItem.productUrl).into(productImage);
        productName.setText(reviewHeaderItem.productName);
        ratingBar.setRating((float) reviewHeaderItem.ratingBar);
        description.setText(reviewHeaderItem.description);
    }
}
