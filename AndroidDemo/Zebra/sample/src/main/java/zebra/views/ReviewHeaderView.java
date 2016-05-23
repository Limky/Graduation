package zebra.views;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import example.zxing.R;
import zebra.activity.ReviewActivity;

/**
 * Created by multimedia on 2016-05-13.
 */
public class ReviewHeaderView extends FrameLayout {

    ImageView imageView;
    TextView goodsName;
    Button dialogButton;

    public ReviewHeaderView(Context context) {
        super(context);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.review_header, this);

        imageView = (ImageView)findViewById(R.id.goodsImage);
        goodsName = (TextView)findViewById(R.id.goodsName);
        dialogButton = (Button)findViewById(R.id.dialogButton);
        imageView.setImageResource(R.drawable.book);
    }
    public void setReviewHeader(){

    }
}
