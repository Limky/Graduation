package zebra.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import at.markushi.ui.CircleButton;
import example.zxing.R;
import zebra.adapters.NaviAdapter;
import zebra.beans.NaviItem;
import zebra.views.NaviHeaderView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    CircleButton barcodeButton, reviewButton, loginButton;
    //for toolbar
    DrawerLayout mDrawerLayout;
    ListView mDrawerList;
    NaviAdapter naviAdapter;
    ActionBarDrawerToggle mDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Button 설정
        barcodeButton = (CircleButton) findViewById(R.id.barcodeButton);
        reviewButton = (CircleButton) findViewById(R.id.reviewButton);
        loginButton = (CircleButton) findViewById(R.id.searchButton);

        barcodeButton.setOnClickListener(this);
        reviewButton.setOnClickListener(this);
        loginButton.setOnClickListener(this);

        //Toolbar 설정
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("");
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer);

        mDrawerList = (ListView)findViewById(R.id.naviList);
        naviAdapter = new NaviAdapter();
        mDrawerList.setAdapter(naviAdapter);

        NaviHeaderView header = new NaviHeaderView(MainActivity.this);
        mDrawerList.addHeaderView(header);

        //navbar 아이템들, 지워야됨
        for (int i=0; i<4; i++) {
            if(i == 0){NaviItem item = new NaviItem(R.drawable.ic_perm_identity_black_48dp, "프로필");naviAdapter.add(item);}
            if(i == 1){NaviItem item = new NaviItem(R.drawable.ic_library_books_black_48dp, "나의 리뷰");naviAdapter.add(item);}
            if(i == 2){NaviItem item = new NaviItem(R.drawable.ic_redeem_black_48dp, "선물함");naviAdapter.add(item);}
            if(i == 3){NaviItem item = new NaviItem(R.drawable.logout, "로그아웃");naviAdapter.add(item);}
        }

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int editedPosition = position+1;
                Toast.makeText(MainActivity.this, "You selected item " + editedPosition, Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawer(mDrawerList);
            }
        });

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close){
            public void onDrawerClosed(View v){
                super.onDrawerClosed(v);
                invalidateOptionsMenu();
                syncState();
            }
            public void onDrawerOpened(View v){
                super.onDrawerOpened(v);
                invalidateOptionsMenu();
                syncState();
            }
        };

        mDrawerLayout.addDrawerListener(mDrawerToggle);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        mDrawerToggle.syncState();
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home: {
                if (mDrawerLayout.isDrawerOpen(mDrawerList)){
                    mDrawerLayout.closeDrawer(mDrawerList);
                } else {
                    mDrawerLayout.openDrawer(mDrawerList);
                }
                return true;
            }
            default: return super.onOptionsItemSelected(item);
        }
    }
}
