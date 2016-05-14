package zebra.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import example.zxing.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button barcodeButton, reviewButton, loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barcodeButton = (Button) findViewById(R.id.barcodeButton);
        reviewButton = (Button) findViewById(R.id.reviewButton);
        loginButton = (Button) findViewById(R.id.loginButton);

        barcodeButton.setOnClickListener(this);
        reviewButton.setOnClickListener(this);
        loginButton.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Log.d("MainActivity", "Cancelled scan");
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Log.d("MainActivity", "Scanned");
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();

                Intent i = new Intent(MainActivity.this, ReviewActivity.class);
                startActivity(i);
            }
        } else {
            Log.d("MainActivity", "Cancelled scan");
            Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            // This is important, otherwise the result will not be passed to the fragment
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onClick(View v) {
        int buttonId = v.getId();
        switch (buttonId) {
            case R.id.barcodeButton:
                new IntentIntegrator(this).setCaptureActivity(ToolbarCaptureActivity.class).initiateScan();
                break;
            case R.id.reviewButton:
                Intent reviewIntent = new Intent(MainActivity.this, ReviewActivity.class);
                startActivity(reviewIntent);
                break;
            case R.id.loginButton:
                Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(loginIntent);
                break;
        }
    }
}
