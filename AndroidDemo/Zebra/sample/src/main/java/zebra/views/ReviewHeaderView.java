package zebra.views;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import example.zxing.R;

/**
 * Created by multimedia on 2016-05-13.
 */
public class ReviewHeaderView extends FrameLayout {

    ImageView imageView;
    TextView goodsName;
    TextView ratingBar;

    public ReviewHeaderView(Context context) {
        super(context);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.review_header, this);

        imageView = (ImageView)findViewById(R.id.goodsImage);
        goodsName = (TextView)findViewById(R.id.goodsName);
        ratingBar = (TextView)findViewById(R.id.ratingBar);

        imageView.setImageResource(R.drawable.zebra_logo);
        goodsName.setText("상품상품상품");
        ratingBar.setText("별점");
    }
}
