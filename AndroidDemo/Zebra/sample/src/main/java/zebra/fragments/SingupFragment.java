package zebra.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import example.zxing.R;
import zebra.activity.LoginActivity;

/**
 * Created by multimedia on 2016-05-14.
 */
public class SingupFragment extends Fragment {
    Button signupButton,loginButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_signup, container, false);

        signupButton = (Button)v.findViewById(R.id.signupButton);
        loginButton = (Button)v.findViewById(R.id.loginButton);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((LoginActivity)getActivity()).pushLogInFragment();
            }
        });

        return v;
    }
}
