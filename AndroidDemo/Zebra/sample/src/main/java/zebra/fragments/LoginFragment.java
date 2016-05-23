package zebra.fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import example.zxing.R;
import zebra.activity.LoginActivity;
import zebra.json.Login;
import zebra.network.NetworkManager;

/**
 * Created by multimedia on 2016-05-14.
 */
public class LoginFragment extends Fragment {
    Button loginButton;
    EditText idEditText, passwordEditText;
    CheckBox autoLoginCheck;
    String id, password;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        idEditText = (EditText) v.findViewById(R.id.idEditText);
        passwordEditText = (EditText) v.findViewById(R.id.passwordEditText);

        idEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    switch (keyCode) {
                        case KeyEvent.KEYCODE_ENTER:
                            passwordEditText.requestFocus();
                            return true;
                    }
                }
                return false;
            }
        });

        autoLoginCheck = (CheckBox) v.findViewById(R.id.autoLoginCheck);

        loginButton = (Button) v.findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = idEditText.getText().toString();
                password = passwordEditText.getText().toString();

                if (TextUtils.isEmpty(id) || TextUtils.isEmpty(password)) {
                    Toast.makeText(getActivity(), "아이디와 비밀번호를 입력하세요", Toast.LENGTH_LONG).show();
                } else {
                    NetworkManager.getInstance().login(v.getContext(), id, password, new NetworkManager.OnResultResponseListener<Login>() {
                        @Override
                        public void onSuccess(Login result) {
                            if (autoLoginCheck.isChecked()) {
                                //autoLogin 설정
                            }
                            Toast.makeText(getActivity(), "성공", Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onFail(int code, String responseString) {
                            Toast.makeText(getActivity(), "실패", Toast.LENGTH_LONG).show();
                        }
                    });
                }

            }
        });

        /*
        signupButton = (Button)v.findViewById(R.id.signupButton);
        loginButton = (Button)v.findViewById(R.id.loginButton);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((LoginActivity)getActivity()).pushSignUpFragment();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });*/

        return v;
    }


}
