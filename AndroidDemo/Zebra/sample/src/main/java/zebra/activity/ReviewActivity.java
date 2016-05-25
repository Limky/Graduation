package zebra.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import example.zxing.R;
import zebra.adapters.NaviAdapter;
import zebra.beans.NaviItem;
import zebra.dialog.ReviewDialog;
import zebra.json.Review;
import zebra.manager.ScanManager;
import zebra.manager.NetworkManager;
import zebra.views.NaviHeaderView;
import zebra.beans.ReviewItem;
import zebra.adapters.ReviewAdapter;

/**
 * Created by multimedia on 2016-05-01.
 */
public class ReviewActivity extends AppCompatActivity {
    ListView reviewList;
    ReviewAdapter mAdapter;
    View reviewHeader;

    String barcode;
    Review result;

    //for toolbar
    DrawerLayout mDrawerLayout;
    ListView mDrawerList;
    NaviAdapter naviAdapter;
    ActionBarDrawerToggle mDrawerToggle;

    ImageButton barcodeNaviButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        barcodeNaviButton = (ImageButton)findViewById(R.id.barcodeNaviButton);
        barcodeNaviButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new IntentIntegrator(ReviewActivity.this).setCaptureActivity(ToolbarCaptureActivity.class).initiateScan();
            }
        });

        //getIntent
        barcode = ScanManager.getInstance().getBarcode();
        result = (Review)getIntent().getParcelableExtra("Result");

        //listView 구성
        setListView();

        //Toolbar 설정
        setToolbar();

        reviewHeader.findViewById(R.id.dialogButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                ReviewDialog dialogFragment = new ReviewDialog();
                dialogFragment.show(fm, "dialog");
            }
        });
    }

    private void setListView(){
        reviewList = (ListView) findViewById(R.id.reviewList);
        mAdapter = new ReviewAdapter();
        reviewList.setAdapter(mAdapter);
        reviewHeader = getLayoutInflater().inflate(R.layout.review_header, null, false);
        reviewList.addHeaderView(reviewHeader);

        for (int i = 0; i < result.reviews.size(); i++) {
            ReviewItem item = new ReviewItem(R.drawable.icon,
                                            result.reviews.get(i).id ,
                                            result.reviews.get(i).starPoint,
                                            result.reviews.get(i).reviewText);
            mAdapter.add(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Log.d("ReviewActivity", "Cancelled scan");
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Log.d("ReviewActivity", "Scanned");
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();

                //ScanManager에 barcode를 set
                ScanManager.getInstance().setBarcode(result.getContents());
                barcode = ScanManager.getInstance().getBarcode();
                network();
            }
        } else {
            Log.d("ReviewActivity", "Cancelled scan");
            Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            // This is important, otherwise the result will not be passed to the fragment
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void network(){
        NetworkManager.getInstance().review(this, barcode, new NetworkManager.OnResultResponseListener<Review>() {
            @Override
            public void onSuccess(Review result) {
                if(result.productInfo==null){
                    Toast.makeText(ReviewActivity.this, "등록 된 상품이 없습니다.", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(ReviewActivity.this,ProductRegisterActivity.class);
                    startActivity(i);
                    finish();
                }
                else{
                    ScanManager.getInstance().setProductUrl(result.productInfo.productUrl);
                    for (int i = 0; i < result.reviews.size(); i++) {
                        ReviewItem item = new ReviewItem(R.drawable.icon, result.reviews.get(i).id , 3, result.reviews.get(i).reviewText);
                        mAdapter.add(item);
                    }
                }
                Toast.makeText(ReviewActivity.this, "성공", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFail(int code, String responseString) {
                Toast.makeText(ReviewActivity.this, "실패 "+code, Toast.LENGTH_LONG).show();
            }
        });

    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        mDrawerList = (ListView) findViewById(R.id.naviList);
        naviAdapter = new NaviAdapter();
        mDrawerList.setAdapter(naviAdapter);

        NaviHeaderView naviHeader = new NaviHeaderView(ReviewActivity.this);
        mDrawerList.addHeaderView(naviHeader);

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
                NaviItem item = new NaviItem(R.drawable.logout, "로그아웃");
                naviAdapter.add(item);
            }
        }

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int editedPosition = position + 1;
                Toast.makeText(ReviewActivity.this, "You selected item " + editedPosition, Toast.LENGTH_SHORT).show();
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
}
