package zebra.views;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import example.zxing.R;
import zebra.beans.SearchItem;

/**
 * Created by multimedia on 2016-05-29.
 */
public class CategorySearchItemView extends FrameLayout {
    ImageView productImage;
    TextView productName;
    RatingBar ratingBar;

    public CategorySearchItemView(Context context) {
        super(context);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.search_item, this);

        productImage = (ImageView)findViewById(R.id.productImage);
        productName = (TextView)findViewById(R.id.productName);
        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
    }

    public void setViewItem(SearchItem item) {
        Glide.with(getContext()).load(item.productUrl).into(productImage);
        productName.setText(item.productName);
        ratingBar.setRating((float)item.ratingBar);
    }
}
