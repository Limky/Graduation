package zebra.dialog;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import example.zxing.R;
import zebra.json.Review;
import zebra.manager.MemberManager;
import zebra.manager.ScanManager;
import zebra.manager.NetworkManager;

/**
 * Created by multimedia on 2016-05-20.
 */
public class ReviewDialog extends DialogFragment {
    EditText reviewEditText;
    Button dialogButton;
    RatingBar ratingBar;

    String id, reviewText, barcode, productUrl, memberUrl;
    double starPoint = 0;

    public ReviewDialog() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.review_dialog, container);

        getDialog().setTitle("Thank you for your review");

        reviewEditText = (EditText) view.findViewById(R.id.reviewEditText);
        dialogButton = (Button) view.findViewById(R.id.dialogButton);
        ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);

        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = MemberManager.getInstance().getId();
                barcode = ScanManager.getInstance().getBarcode();
                productUrl = ScanManager.getInstance().getProductUrl();
                //id = "a";
                memberUrl = MemberManager.getInstance().getMemberUrl();
                reviewText = reviewEditText.getText().toString();
                starPoint = (double) ratingBar.getRating();
                if (reviewText.equals("") || starPoint == 0)
                    Toast.makeText(getContext(), "리뷰와 별점을 입력해주세요", Toast.LENGTH_LONG).show();
                else {
                    NetworkManager.getInstance().reviewRegister(getContext(), id, reviewText, barcode, starPoint, productUrl, memberUrl, new NetworkManager.OnResultResponseListener<Review>() {
                        @Override
                        public void onSuccess(Review result) {
                            //getActivity().startActivityForResult(intent, code);
                            dismiss();
                        }

                        @Override
                        public void onFail(int code, String responseString) {
                            Toast.makeText(getContext(), "야미실패", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });

        return view;
    }
}
