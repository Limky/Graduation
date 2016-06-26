package zebra.fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatRatingBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import example.zxing.R;
import zebra.activity.LoginActivity;
import zebra.activity.ReviewActivityTest;
import zebra.adapters.ReviewTabsAdapter;
import zebra.json.Review;
import zebra.manager.MemberManager;
import zebra.manager.NetworkManager;
import zebra.manager.PropertyManager;
import zebra.manager.ReviewManager;
import zebra.manager.ScanManager;

/**
 * Created by multimedia on 2016-05-27.
 */
public class ReviewRegisterFragment  extends Fragment {
    EditText reviewEditText;
    Button registerButton, cancelButton;
    AppCompatRatingBar ratingBar;
    String id, barcode, productUrl, memberUrl, reviewText, level;
    double starPoint;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_review_register,container,false);
        reviewEditText = (EditText)view.findViewById(R.id.reviewEditText);

        registerButton = (Button)view.findViewById(R.id.registerButton);
        cancelButton = (Button)view.findViewById(R.id.cancelButton);

        ratingBar = (AppCompatRatingBar)view.findViewById(R.id.ratingBar);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ReviewActivityTest) getActivity()).popFragment();
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View viewGettedOnclick = v;
                id = MemberManager.getInstance().getId();
                barcode = ScanManager.getInstance().getBarcode();
                productUrl = ScanManager.getInstance().getProductUrl();
                memberUrl = MemberManager.getInstance().getMemberUrl();
                reviewText = reviewEditText.getText().toString();
                starPoint = (double) ratingBar.getRating();
                level = MemberManager.getInstance().getLevel();
                if(MemberManager.getInstance().getIsLogin() == false){
                    Toast.makeText(v.getContext(), "로그인을 먼저 하세요", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(v.getContext(), LoginActivity.class);
                    startActivity(i);
                    return;
                }
                if (reviewText.equals("") || starPoint == 0)
                    Toast.makeText(v.getContext(), "리뷰와 별점을 입력해주세요", Toast.LENGTH_LONG).show();
                else {
                    NetworkManager.getInstance().reviewRegister(getContext(), id, reviewText, barcode, starPoint, productUrl, memberUrl, level, new NetworkManager.OnResultResponseListener<Review>() {
                        @Override
                        public void onSuccess(Review result) {
                            if(result == null){
                                Toast.makeText(getContext(), "하루에 등록 가능한 리뷰의 수를 초과했습니다.", Toast.LENGTH_LONG).show();
                                return;
                            }else {
                                ((ReviewActivityTest) getActivity()).setCurrentItem(0, true);
                            }
                        }
                        @Override
                        public void onFail(int code, String responseString) {
                        }
                    });
                }
            }
        });

        return view;
    }
}
