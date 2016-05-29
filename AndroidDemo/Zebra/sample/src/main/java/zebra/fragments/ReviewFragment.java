package zebra.fragments;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import example.zxing.R;
import zebra.adapters.ReviewAdapter;
import zebra.beans.ReviewHeaderItem;
import zebra.beans.ReviewItem;
import zebra.json.Review;
import zebra.manager.ReviewManager;
import zebra.views.ReviewHeaderView;

/**
 * Created by multimedia on 2016-05-27.
 */

public class ReviewFragment extends Fragment {
    ListView reviewList;
    ReviewAdapter mAdapter;
    ReviewHeaderView reviewHeaderView;

    Review result;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_review,container,false);

        result = ReviewManager.getInstance().getReview();

        setListView(view);

        return view;
    }

    private void setListView(View view){
        reviewList = (ListView) view.findViewById(R.id.reviewList);
        reviewHeaderView = new ReviewHeaderView(view.getContext());
        ReviewHeaderItem reviewHeaderItem = new ReviewHeaderItem(result.productInfo.productUrl, result.productInfo.productName, result.productInfo.description, result.productInfo.starPoint);
        reviewHeaderView.setReviewHeader(reviewHeaderItem);
        mAdapter = new ReviewAdapter();
        reviewList.setAdapter(mAdapter);
        reviewList.addHeaderView(reviewHeaderView);

        for (int i = 0; i < result.reviews.size(); i++) {
            ReviewItem item = new ReviewItem(result.reviews.get(i).memberUrl,
                    result.reviews.get(i).id ,
                    result.reviews.get(i).starPoint,
                    result.reviews.get(i).reviewText);
            mAdapter.add(item);
        }
    }
}
