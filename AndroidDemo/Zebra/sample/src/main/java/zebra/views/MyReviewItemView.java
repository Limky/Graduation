package zebra.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import example.zxing.R;
import zebra.beans.MyReviewItem;

/**
 * Created by multimedia on 2016-05-29.
 */
public class MyReviewItemView extends FrameLayout {
    ImageView productImage;
    TextView memberId;
    RatingBar ratingBar;
    TextView reviewText;

    public MyReviewItemView(Context context) {
        super(context);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.my_review_item, this);
        productImage = (ImageView)findViewById(R.id.productImage);
        memberId = (TextView)findViewById(R.id.memberId);
        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        reviewText = (TextView)findViewById(R.id.reviewText);
    }

    public void setViewItem(MyReviewItem item) {
        Glide.with(getContext()).load(item.productImage).asBitmap().centerCrop().into(new BitmapImageViewTarget(productImage) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(getContext().getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                productImage.setImageDrawable(circularBitmapDrawable);
            }
        });
        memberId.setText(item.memberId);
        ratingBar.setRating((float)item.ratingBar);
        reviewText.setText(item.reviewText);
    }

}
