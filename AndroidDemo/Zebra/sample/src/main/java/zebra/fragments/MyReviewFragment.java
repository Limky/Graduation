package zebra.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import example.zxing.R;
import zebra.adapters.MyReviewAdapter;
import zebra.beans.MyReviewItem;
import zebra.json.MyReview;
import zebra.manager.MemberManager;

/**
 * Created by multimedia on 2016-05-29.
 */
public class MyReviewFragment extends Fragment {
    TextView point, count;

    ListView reviewList;
    MyReviewAdapter mAdapter;
    MyReview result;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_review, container, false);

        point = (TextView)view.findViewById(R.id.point);
        count = (TextView)view.findViewById(R.id.count);
        point.setText("Point : "+MemberManager.getInstance().getPoint());
        count.setText("Count : "+MemberManager.getInstance().getReviewCount());

        result = MemberManager.getInstance().getReviews();

        setListView(view);

        return view;
    }

    private void setListView(View view){
        reviewList = (ListView) view.findViewById(R.id.reviewList);
        mAdapter = new MyReviewAdapter();

        reviewList.setAdapter(mAdapter);

        for (int i = 0; i < MemberManager.getInstance().getReviews().reviews.size(); i++) {
            MyReviewItem item = new MyReviewItem(result.reviews.get(i).productUrl,
                    result.reviews.get(i).id ,
                    result.reviews.get(i).starPoint,
                    result.reviews.get(i).reviewText);
            mAdapter.add(item);
        }
    }
}
