package zebra.views;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import example.zxing.R;

/**
 * Created by multimedia on 2016-05-18.
 */
public class NaviHeaderView extends FrameLayout {

    ImageView profileImage;
    TextView name;

    public NaviHeaderView(Context context) {
        super(context);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.navi_header, this);

        profileImage = (ImageView)findViewById(R.id.profileImage);
        name = (TextView)findViewById(R.id.name);

        profileImage.setImageResource(R.drawable.bang);
        name.setText("임인혁님 반갑습니다.");
    }
}
