package zebra.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import example.zxing.R;
import zebra.fragments.SingupFragment;
import zebra.fragments.LoginFragment;

/**
 * Created by multimedia on 2016-05-14.
 */
public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction().add(R.id.container, new LoginFragment()).commit();
        }
    }

    public void pushSignUpFragment() {
        getFragmentManager().beginTransaction().replace(R.id.container, new SingupFragment()).addToBackStack(null).commit();
    }

    public void pushLogInFragment() {
        getFragmentManager().beginTransaction().replace(R.id.container, new LoginFragment()).addToBackStack(null).commit();
    }

    public void popFragment() {
        getFragmentManager().popBackStack();
    }
}
