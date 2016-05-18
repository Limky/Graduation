package zebra.views;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import example.zxing.R;
import zebra.beans.NaviItem;
import zebra.beans.ReviewItem;

/**
 * Created by multimedia on 2016-05-18.
 */
public class NaviItemView extends FrameLayout {

    ImageView naviItemIcon;
    TextView naviItemName;

    public NaviItemView(Context context) {
        super(context);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.navi_item, this);
        naviItemIcon = (ImageView) findViewById(R.id.naviItemIcon);
        naviItemName = (TextView)findViewById(R.id.naviItemName);
    }

    public void setViewItem(NaviItem item) {
        naviItemIcon.setImageResource(item.naviItemIcon);
        naviItemName.setText(item.naviItemName);
    }
}
