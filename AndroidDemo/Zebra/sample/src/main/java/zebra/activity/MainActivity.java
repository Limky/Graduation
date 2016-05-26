package zebra.activity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import at.markushi.ui.CircleButton;
import example.zxing.R;
import zebra.adapters.NaviAdapter;
import zebra.beans.NaviItem;
import zebra.json.Review;
import zebra.manager.MemberManager;
import zebra.manager.ProductManager;
import zebra.manager.PropertyManager;
import zebra.manager.ScanManager;
import zebra.manager.NetworkManager;
import zebra.views.NaviHeaderView;


public class MainActivity extends AppCompatActivity {
    CircleButton loginButton, barcodeButton, searchButton;

    AnimationDrawable frameAnimation;
    ImageView imageAnimation;

    String barcode;

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
        loginButton = (CircleButton) findViewById(R.id.loginButton);
        barcodeButton = (CircleButton) findViewById(R.id.barcodeButton);
        searchButton = (CircleButton) findViewById(R.id.searchButton);

        //loginButton OnClick
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });
        barcodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new IntentIntegrator(MainActivity.this).setCaptureActivity(ToolbarCaptureActivity.class).initiateScan();
            }
        });
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchIntent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(searchIntent);
            }
        });


        setToolbar(true);
        setAnimation();

        //자동 로그인일 경우에 설정
        if(PropertyManager.getInstance().getAutoLogin())PropertyManager.getInstance().setMemberInfoToMemManager();

    }


    public void setAnimation(){
        imageAnimation = (ImageView) findViewById(R.id.imageAnimation);
        // animation_list.xml 를 ImageView 백그라운드에 셋팅한다
        imageAnimation.setBackgroundResource(R.drawable.zebra_animation);
        // 이미지를 동작시키기위해  AnimationDrawable 객체를 가져온다.
        frameAnimation = (AnimationDrawable)imageAnimation.getBackground();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            // 어플에 포커스가 갈때 시작된다
            frameAnimation.start();
        } else {
            // 어플에 포커스를 떠나면 종료한다
            frameAnimation.stop();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setToolbar(false);
    }

    void setToolbar(boolean isFirst){
        //Toolbar 설정
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        //toolbar.setTitle("");
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer);

        mDrawerList = (ListView)findViewById(R.id.naviList);
        naviAdapter = new NaviAdapter();
        mDrawerList.setAdapter(naviAdapter);

        NaviHeaderView header = new NaviHeaderView(MainActivity.this);
        //onResume()에서 두번째 불려지는 경우 naviHeader가 두개 생기는 경우를 방지!!
        if(isFirst)mDrawerList.addHeaderView(header);

        //navbar 아이템들, 지워야됨
        for (int i=0; i<4; i++) {
            if(i == 0){NaviItem item = new NaviItem(R.drawable.ic_perm_identity_black_48dp, "프로필");naviAdapter.add(item);}
            if(i == 1){NaviItem item = new NaviItem(R.drawable.ic_library_books_black_48dp, "나의 리뷰");naviAdapter.add(item);}
            if(i == 2){NaviItem item = new NaviItem(R.drawable.ic_redeem_black_48dp, "선물함");naviAdapter.add(item);}
            if(i == 3){
                if(PropertyManager.getInstance().getAutoLogin() || PropertyManager.getInstance().getIsLogin()){
                    PropertyManager.getInstance();
                    NaviItem item = new NaviItem(R.drawable.logout, "로그아웃");naviAdapter.add(item);
                }
                else
                {
                    NaviItem item = new NaviItem(R.drawable.logout, "로그인");naviAdapter.add(item);
                }
            }
        }

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 4:
                        //로그아웃 일 경우에 toolbar를 다시 설정
                        PropertyManager.getInstance().setAutoLogin(MainActivity.this, false);
                        PropertyManager.getInstance().setIsogin(false);
                        setToolbar(false);
                }
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

    public void network(){
        NetworkManager.getInstance().review(this, barcode, new NetworkManager.OnResultResponseListener<Review>() {
            @Override
            public void onSuccess(Review result) {
                if(result.productInfo==null){
                    Toast.makeText(MainActivity.this, "등록 된 상품이 없습니다.", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(MainActivity.this, ProductRegisterActivity.class);
                    startActivity(i);
                }else if(result == null){
                    Toast.makeText(MainActivity.this, "등록 대기중", Toast.LENGTH_LONG).show();
                }
                else{
                    Intent i = new Intent(MainActivity.this, ReviewActivity.class);
                    ScanManager.getInstance().setProductUrl(result.productInfo.productUrl);
                    i.putExtra("Result", result);
                    startActivity(i);
                }
            }

            @Override
            public void onFail(int code, String responseString) {
                Toast.makeText(MainActivity.this, "실패"+code, Toast.LENGTH_LONG).show();
                Log.d("Main", "실패");
            }
        });
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

                //ScanManager에 barcode를 set
                ScanManager.getInstance().setBarcode(result.getContents());
                barcode = ScanManager.getInstance().getBarcode();
                network();
            }
        } else {
            Log.d("MainActivity", "Cancelled scan");
            Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            // This is important, otherwise the result will not be passed to the fragment
            super.onActivityResult(requestCode, resultCode, data);
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
