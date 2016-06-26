package zebra.fragments;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import example.zxing.R;
import zebra.manager.MemberManager;

/**
 * Created by multimedia on 2016-05-29.
 */
public class MyPageFragment extends Fragment {
    TextView id, level, name, point;
    String levelString;
    ImageView profileImageView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_page, container, false);

        id = (TextView)view.findViewById(R.id.id);
        level = (TextView)view.findViewById(R.id.level);
        name = (TextView)view.findViewById(R.id.name);
        point = (TextView)view.findViewById(R.id.point);
        profileImageView = (ImageView)view.findViewById(R.id.profileImageView);

        setProfile(view);

        return view;
    }

    public void setProfile(View view){
        id.setText(MemberManager.getInstance().getId());

        levelString = MemberManager.getInstance().getLevel();
        level.setText(levelString);
        if(levelString.equals("Gold")){

        } else if(levelString.equals("Silver")){

        } else {

        }

        name.setText(MemberManager.getInstance().getName());

        point.setText(MemberManager.getInstance().getPoint() + "");

        Glide.with(view.getContext()).load(MemberManager.getInstance().getMemberUrl()).asBitmap().centerCrop().into(new BitmapImageViewTarget(profileImageView) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(getContext().getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                profileImageView.setImageDrawable(circularBitmapDrawable);
            }
        });
    }
}
