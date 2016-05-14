package zebra.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import example.zxing.R;
import zebra.views.ReviewHeaderView;
import zebra.beans.ReviewItem;
import zebra.adapters.ReviewAdapter;

/**
 * Created by multimedia on 2016-05-01.
 */
public class ReviewActivity extends AppCompatActivity{
    ListView reviewList;
    ReviewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        reviewList = (ListView)findViewById(R.id.reviewList);
        mAdapter = new ReviewAdapter();
        reviewList.setAdapter(mAdapter);
        ReviewHeaderView header = new ReviewHeaderView(ReviewActivity.this);
        reviewList.addHeaderView(header);

        for (int i=0; i<10; i++) {
            ReviewItem item = new ReviewItem(R.drawable.icon, "아이디" + i, "5", "리뷰임다ㅇ."+i);
            mAdapter.add(item);
        }

    }

}
