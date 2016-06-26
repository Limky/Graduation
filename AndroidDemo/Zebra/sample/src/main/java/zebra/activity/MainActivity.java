package zebra.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import at.markushi.ui.CircleButton;
import example.zxing.R;
import zebra.adapters.NaviAdapter;
import zebra.beans.NaviItem;
import zebra.gcm.QuickstartPreferences;
import zebra.gcm.RegistrationIntentService;
import zebra.json.MyReview;
import zebra.json.Review;
import zebra.manager.MemberManager;
import zebra.manager.PropertyManager;
import zebra.manager.ScanManager;
import zebra.manager.NetworkManager;
import zebra.views.NaviHeaderView;


public class MainActivity extends AppCompatActivity {
    //GCM
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private static final String TAG = "MainActivity";
    private BroadcastReceiver mRegistrationBroadcastReceiver;

    LinearLayout loginButton, barcodeButton, categoryButton, searchButton;

    String barcode;

    TextView myText;

    //for toolbar
    DrawerLayout mDrawerLayout;
    ListView mDrawerList;
    NaviAdapter naviAdapter;
    ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getInstanceIdToken();

        registBroadcastReceiver();

        if (ScanManager.getInstance().getIsGCM()) {
            barcode = ScanManager.getInstance().getBarcode();
            ScanManager.getInstance().setIsGCM(false);
            network();
        }

        loginButton = (LinearLayout) findViewById(R.id.loginButton);
        barcodeButton = (LinearLayout) findViewById(R.id.barcodeButton);
        categoryButton = (LinearLayout) findViewById(R.id.categoryButton);
        searchButton = (LinearLayout) findViewById(R.id.searchButton);
        myText = (TextView) findViewById(R.id.myText);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MemberManager.getInstance().getIsLogin()) {
                    networkMyPage();
                    return;
                }
                Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });
        barcodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //networkMyPage();
                new IntentIntegrator(MainActivity.this).setCaptureActivity(ToolbarCaptureActivity.class).initiateScan();
            }
        });
        categoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categoryItent = new Intent(MainActivity.this, CategoryActivity.class);
                startActivity(categoryItent);
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
    }

    @Override
    protected void onResume() {
        super.onResume();
        setToolbar(false);
        if (MemberManager.getInstance().getIsLogin()) {
            myText.setText("My Page");
        }
    }

    void setToolbar(boolean isFirst) {
        //Toolbar 설정
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mDrawerList = (ListView) findViewById(R.id.naviList);
        naviAdapter = new NaviAdapter();
        mDrawerList.setAdapter(naviAdapter);
        NaviHeaderView header = new NaviHeaderView(MainActivity.this);

        //onResume()에서 두번째 불려지는 경우 naviHeader가 두개 생기는 경우를 방지!!
        if (isFirst) mDrawerList.addHeaderView(header);

        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                NaviItem item = new NaviItem(R.drawable.ic_perm_identity_black_48dp, "프로필");
                naviAdapter.add(item);
            }
            if (i == 1) {
                NaviItem item = new NaviItem(R.drawable.ic_library_books_black_48dp, "나의 리뷰");
                naviAdapter.add(item);
            }
            if (i == 2) {
                NaviItem item = new NaviItem(R.drawable.ic_redeem_black_48dp, "선물함");
                naviAdapter.add(item);
            }
            if (i == 3) {
                if (MemberManager.getInstance().getIsLogin()) {
                    NaviItem item = new NaviItem(R.drawable.logout, "로그아웃");
                    naviAdapter.add(item);
                } else {
                    NaviItem item = new NaviItem(R.drawable.logout, "로그인");
                    naviAdapter.add(item);
                }
            }
        }

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 4:
                        MemberManager.getInstance().clearMemberInfo();
                        //로그아웃 일 경우에 toolbar를 다시 설정
                        setToolbar(false);
                }
                int editedPosition = position + 1;
                mDrawerLayout.closeDrawer(mDrawerList);
            }
        });

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            public void onDrawerClosed(View v) {
                super.onDrawerClosed(v);
                invalidateOptionsMenu();
                syncState();
            }

            public void onDrawerOpened(View v) {
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

    public void networkMyPage() {
        NetworkManager.getInstance().myReview(this, MemberManager.getInstance().getId(), new NetworkManager.OnResultResponseListener<MyReview>() {
            @Override
            public void onSuccess(MyReview result) {
                MemberManager.getInstance().setReviews(result);
                Intent i = new Intent(MainActivity.this, MyPageActivity.class);
                startActivity(i);
            }

            @Override
            public void onFail(int code, String responseString) {

            }
        });
    }

    public void network() {
        NetworkManager.getInstance().review(this, barcode, new NetworkManager.OnResultResponseListener<Review>() {
            @Override
            public void onSuccess(Review result) {
                //등록 된 상품이 없는 경우
                if (result == null) {
                    if (MemberManager.getInstance().getIsLogin() == false) {
                        Intent i = new Intent(MainActivity.this, LoginActivity.class);
                        i.putExtra("fromRegister", true);
                        startActivity(i);
                        return;
                    }
                    Intent i = new Intent(MainActivity.this, ProductRegisterActivity.class);
                    startActivity(i);
                } else if (result.productInfo.productName.equals("nothingApply")) {
                    Toast.makeText(MainActivity.this, "이미 등록 요청 된 상품입니다.", Toast.LENGTH_LONG).show();
                } else { //리뷰 get
                    Intent i = new Intent(MainActivity.this, ReviewActivityTest.class);
                    ScanManager.getInstance().setProductUrl(result.productInfo.productUrl);
                    i.putExtra("Result", result);
                    startActivity(i);
                }
            }

            @Override
            public void onFail(int code, String responseString) {
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
            } else {
                Log.d("MainActivity", "Scanned");

                //ScanManager에 barcode를 set
                ScanManager.getInstance().setBarcode(result.getContents());
                barcode = ScanManager.getInstance().getBarcode();
                network();
            }
        } else {
            Log.d("MainActivity", "Cancelled scan");
            // This is important, otherwise the result will not be passed to the fragment
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                if (mDrawerLayout.isDrawerOpen(mDrawerList)) {
                    mDrawerLayout.closeDrawer(mDrawerList);
                } else {
                    mDrawerLayout.openDrawer(mDrawerList);
                }
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Instance ID를 이용하여 디바이스 토큰을 가져오는 RegistrationIntentService를 실행한다.
     */
    //GCM get token
    public void getInstanceIdToken() {
        if (checkPlayServices()) {
            // Start IntentService to register this application with GCM.
            Intent intent = new Intent(this, RegistrationIntentService.class);
            startService(intent);
        }
    }

    /**
     * Google Play Service를 사용할 수 있는 환경이지를 체크한다.
     */
    private boolean checkPlayServices() {
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode, this,
                        PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                Log.i(TAG, "This device is not supported.");
                finish();
            }
            return false;
        }
        return true;
    }

    /**
     * LocalBroadcast 리시버를 정의한다. 토큰을 획득하기 위한 READY, GENERATING, COMPLETE 액션에 따라 UI에 변화를 준다.
     */
    public void registBroadcastReceiver() {
        mRegistrationBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();

                if (action.equals(QuickstartPreferences.REGISTRATION_READY)) {
                    // 액션이 READY일 경우

                } else if (action.equals(QuickstartPreferences.REGISTRATION_GENERATING)) {
                    // 액션이 GENERATING일 경우

                } else if (action.equals(QuickstartPreferences.REGISTRATION_COMPLETE)) {
                    // 액션이 COMPLETE일 경우
                }
            }
        };
    }

    /**
     * 앱이 화면에서 사라지면 등록된 LocalBoardcast를 모두 삭제한다.
     */
    @Override
    protected void onPause() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mRegistrationBroadcastReceiver);
        super.onPause();
    }
}
