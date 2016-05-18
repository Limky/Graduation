package zebra.activity;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import example.zxing.R;
import zebra.adapters.NaviAdapter;
import zebra.beans.NaviItem;
import zebra.views.NaviHeaderView;
import zebra.views.ReviewHeaderView;
import zebra.beans.ReviewItem;
import zebra.adapters.ReviewAdapter;

/**
 * Created by multimedia on 2016-05-01.
 */
public class ReviewActivity extends AppCompatActivity{
    ListView reviewList;
    ReviewAdapter mAdapter;

    //for toolbar
    DrawerLayout mDrawerLayout;
    ListView mDrawerList;
    NaviAdapter naviAdapter;
    ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        reviewList = (ListView)findViewById(R.id.reviewList);
        mAdapter = new ReviewAdapter();
        reviewList.setAdapter(mAdapter);
        ReviewHeaderView reviewHeader = new ReviewHeaderView(ReviewActivity.this);
        reviewList.addHeaderView(reviewHeader);

        for (int i=0; i<10; i++) {
            ReviewItem item = new ReviewItem(R.drawable.icon, ""+i, 3, "리뷰입니다.");
            mAdapter.add(item);
        }

        //Toolbar 설정
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Review");

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer);

        mDrawerList = (ListView)findViewById(R.id.naviList);
        naviAdapter = new NaviAdapter();
        mDrawerList.setAdapter(naviAdapter);

        NaviHeaderView naviHeader = new NaviHeaderView(ReviewActivity.this);
        mDrawerList.addHeaderView(naviHeader);

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
                Toast.makeText(ReviewActivity.this, "You selected item " + editedPosition, Toast.LENGTH_SHORT).show();
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
