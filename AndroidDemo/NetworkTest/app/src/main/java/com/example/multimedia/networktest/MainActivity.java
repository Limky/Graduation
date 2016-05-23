package com.example.multimedia.networktest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

public class MainActivity extends AppCompatActivity {

    AsyncHttpClient client;
    private static final String SERVER_URL = "http://113.198.84.84:8080/ZEBRA/";
    Button testButton, loginButton;
    EditText idEditText,passwordEditText;
    TextView idTextView, passwordTextView, nameTextView, testTextView;

    String id, password;

    Member member;

    Gson gson;
    Sample sample;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //AsyncHttpClient 초기화
        client = new AsyncHttpClient();

        testButton = (Button)findViewById(R.id.testButton);
        loginButton = (Button)findViewById(R.id.loginButton);

        idEditText=(EditText)findViewById(R.id.idEditText);
        passwordEditText=(EditText)findViewById(R.id.passwordEditText);

        idTextView = (TextView)findViewById(R.id.idTextView);
        passwordTextView = (TextView)findViewById(R.id.passwordTextView);
        nameTextView = (TextView)findViewById(R.id.nameTextView);
        testTextView = (TextView)findViewById(R.id.testTextView);

        sample = new Sample();
        user = new User();
        member = new Member();

        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Network Test", "before");
                test(MainActivity.this);
                Log.d("Network Test", "after");
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = idEditText.getText().toString();
                password = passwordEditText.getText().toString();
                Log.d("Network Test", "before");
                login(MainActivity.this, id, password);
                Log.d("Network Test", "after");
            }
        });
    }

    public void test (Context context) {
        RequestParams params = new RequestParams();
        params.put("barcode", "15489");

        client.post(context, SERVER_URL + "/androidTest", params, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, String responseString, Throwable throwable) {
                Log.d("Network Test", "fail");
                Toast.makeText(getApplicationContext(), "fail"+statusCode, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, String responseString) {
                Log.d("Network Test", "Succes");

                //statusCode는 웹에서 404, 500 같은 에러 코드랑 같은 값
                Toast.makeText(getApplicationContext(), "success"+statusCode, Toast.LENGTH_LONG).show();

                // responseString으로 날라온 \n \r들을 자르는 함수
                String ss = responseString.replaceAll("[\n \r]","");

                gson = new Gson();
                sample = gson.fromJson(ss, Sample.class);

                testTextView.setText(sample.productInfo.companyName + sample.productInfo.starPoint);


                //Toast.makeText(getApplicationContext(), responseString, Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplicationContext(), sample.productInfo.companyName, Toast.LENGTH_LONG).show();
            }
        });
    }


    public void login (Context context, String id, String password) {
        RequestParams params = new RequestParams();
        params.put("id", id);
        params.put("password", password);

        client.post(context, SERVER_URL + "/loginTest", params, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, String responseString, Throwable throwable) {
                Log.d("Network Test", "fail");
                Toast.makeText(getApplicationContext(), "fail"+statusCode, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, String responseString) {
                Log.d("Network Test", "Succes");

                //statusCode는 웹에서 404, 500 같은 에러 코드랑 같은 값
                Toast.makeText(getApplicationContext(), "success"+statusCode, Toast.LENGTH_LONG).show();

                // responseString으로 날라온 \n \r들을 자르는 함수
                String ss = responseString.replaceAll("[\n \r]","");

                // 파싱
                gson = new Gson();
                member = gson.fromJson(ss, Member.class);

                //TextView에 값 설정
                idTextView.setText(member.member.id);
                passwordTextView.setText(member.member.password);
                nameTextView.setText(member.member.name);

                //List 받기 예제
                /*
                String ss = responseString.replaceAll("[\n \r]","");
                gson = new Gson();
                sample = gson.fromJson(ss, Sample.class);

                textView.setText(sample.productInfo.companyName + sample.productInfo.starPoint);
                */

                //Toast.makeText(getApplicationContext(), responseString, Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplicationContext(), sample.productInfo.companyName, Toast.LENGTH_LONG).show();
            }
        });
    }
}