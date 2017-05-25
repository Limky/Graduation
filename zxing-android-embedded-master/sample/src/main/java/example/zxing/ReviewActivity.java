package example.zxing;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by multimedia on 2016-05-01.
 */
public class ReviewActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
    }

    public void buttonClicked(View v){
        Intent intent = new Intent();
        ComponentName name = new ComponentName("example.zxing", "example.zxing.MainActivity");

        intent.setComponent(name);

        startActivity(intent);
        finish();
    }
}
