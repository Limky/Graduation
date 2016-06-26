package zebra.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Member;

import example.zxing.R;
import zebra.adapters.MyTabsAdapter;
import zebra.adapters.NaviAdapter;
import zebra.beans.NaviItem;
import zebra.fragments.MyPageFragment;
import zebra.fragments.MyReviewFragment;
import zebra.views.NaviHeaderView;

/**
 * Created by multimedia on 2016-05-29.
 */
public class MyPageActivity extends AppCompatActivity {
    //for toolbar
    DrawerLayout mDrawerLayout;
    ListView mDrawerList;
    NaviAdapter naviAdapter;
    ActionBarDrawerToggle mDrawerToggle;

    // Tab Pager
    TabHost tabHost;
    ViewPager pager;
    MyTabsAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);

        setToolbar();

        tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();

        pager = (ViewPager)findViewById(R.id.pager);
        mAdapter = new MyTabsAdapter(this, getSupportFragmentManager(), tabHost, pager);

        mAdapter.addTab(tabHost.newTabSpec("tab1").setIndicator("Profile"), MyPageFragment.class, null);
        mAdapter.addTab(tabHost.newTabSpec("tab2").setIndicator("My Review"), MyReviewFragment.class, null);

        TextView review = (TextView) tabHost.getTabWidget().getChildAt(0).findViewById(android.R.id.title);
        review.setTextSize(18);
        review.setTextColor(ContextCompat.getColor(this, R.color.text_white));
        TextView reviewRegister = (TextView) tabHost.getTabWidget().getChildAt(1).findViewById(android.R.id.title);
        reviewRegister.setTextSize(18);
        reviewRegister.setTextColor(ContextCompat.getColor(this, R.color.text_white));

        setTabColor(tabHost);

        mAdapter.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                setTabColor(tabHost);
                if (tabId.equals("tab1")) {

                } else if (tabId.equals("tab2")) {

                } else {

                }
            }
        });

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(android.R.id.tabcontent, new MyPageFragment()).commit();
        }
    }

    public void setTabColor(TabHost tabhost) {
        for(int i=0;i<tabhost.getTabWidget().getChildCount();i++) {
            tabhost.getTabWidget().getChildAt(i).setBackgroundColor(ContextCompat.getColor(MyPageActivity.this, R.color.accent_pressed)); //unselected
        }
        tabhost.getTabWidget().getChildAt(tabhost.getCurrentTab()).setBackgroundColor(ContextCompat.getColor(MyPageActivity.this, R.color.primary)); // selected
    }

    public void pushMyPageFragment() {
        getSupportFragmentManager().beginTransaction().replace(android.R.id.tabcontent, new MyPageFragment()).addToBackStack(null).commit();
    }

    public void pushMyReviewFragment() {
        getSupportFragmentManager().beginTransaction().replace(android.R.id.tabcontent, new MyReviewFragment()).addToBackStack(null).commit();
    }

    public void popFragment() {
        getFragmentManager().popBackStack();
    }

    void setToolbar() {
        //Toolbar 설정
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        mDrawerList = (ListView) findViewById(R.id.naviList);
        naviAdapter = new NaviAdapter();
        mDrawerList.setAdapter(naviAdapter);

        NaviHeaderView header = new NaviHeaderView(MyPageActivity.this);
        mDrawerList.addHeaderView(header);

        //navbar 아이템들, 지워야됨
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
