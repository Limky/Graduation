package zebra.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import example.zxing.R;
import zebra.json.Search;
import zebra.network.NetworkManager;

/**
 * Created by multimedia on 2016-05-24.
 */
public class SearchActivity extends AppCompatActivity {
    EditText searchEdit;
    Button searchButton;

    String keyWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchEdit = (EditText)findViewById(R.id.searchEdit);
        searchButton = (Button)findViewById(R.id.searchButton);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyWord = searchEdit.getText().toString();
                network(keyWord);
            }
        });
    }

    public void network(String keyWord){
        NetworkManager.getInstance().productSearch(this, keyWord, new NetworkManager.OnResultResponseListener<Search>() {
            @Override
            public void onSuccess(Search result) {
                Toast.makeText(SearchActivity.this, "성공", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFail(int code, String responseString) {
                Toast.makeText(SearchActivity.this, "실패"+code, Toast.LENGTH_LONG).show();
            }
        });
    }
}
