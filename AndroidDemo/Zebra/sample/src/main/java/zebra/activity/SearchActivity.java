package zebra.activity;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import example.zxing.R;
import zebra.adapters.NaviAdapter;
import zebra.beans.NaviItem;
import zebra.fragments.SearchFragment;
import zebra.fragments.SearchNoFragment;
import zebra.fragments.SearchOkFragment;
import zebra.json.Search;
import zebra.manager.NetworkManager;
import zebra.manager.SearchManager;
import zebra.views.NaviHeaderView;

/**
 * Created by multimedia on 2016-05-24.
 */
public class SearchActivity extends AppCompatActivity {
    ImageButton searchButton;
    EditText searchEdit;

    String keyword;

    //for toolbar
    DrawerLayout mDrawerLayout;
    ListView mDrawerList;
    NaviAdapter naviAdapter;
    ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchButton = (ImageButton)findViewById(R.id.searchButton);
        searchEdit = (EditText)findViewById(R.id.searchEdit);

        setToolbar();

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction().add(R.id.container, new SearchFragment()).commit();
        }

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyword = searchEdit.getText().toString();
                if(TextUtils.isEmpty(keyword)){
                    Toast.makeText(SearchActivity.this, "검색어를 입력 해주세요.", Toast.LENGTH_LONG).show();
                    return;
                }
                network(keyword);
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                View view = getCurrentFocus();
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        });
    }

    void setToolbar(){
        //Toolbar 설정
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("");
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer);

        mDrawerList = (ListView)findViewById(R.id.naviList);
        naviAdapter = new NaviAdapter();
        mDrawerList.setAdapter(naviAdapter);

        NaviHeaderView header = new NaviHeaderView(SearchActivity.this);
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

    public void network(String keyWord){
        NetworkManager.getInstance().productSearch(this, keyword, new NetworkManager.OnResultResponseListener<Search>() {
            @Override
            public void onSuccess(Search result) {
                if(result.productInfo.size() == 0){
                    SearchActivity.this.popFragment();
                    SearchManager.getInstance().setSearchNull();
                    SearchActivity.this.pushSearchNoFragment();
                } else {
                    SearchActivity.this.popFragment();
                    SearchManager.getInstance().setSearch(result);
                    SearchActivity.this.pushSearchOkFragment();
                }
            }

            @Override
            public void onFail(int code, String responseString) {
            }
        });
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

    public void pushSearchFragment() {
        getFragmentManager().beginTransaction().replace(R.id.container, new SearchFragment()).addToBackStack(null).commit();
    }

    public void pushSearchOkFragment() {
        getFragmentManager().beginTransaction().replace(R.id.container, new SearchOkFragment()).addToBackStack(null).commit();
    }

    public void pushSearchNoFragment() {
        getFragmentManager().beginTransaction().replace(R.id.container, new SearchNoFragment()).addToBackStack(null).commit();
    }

    public void popFragment() {
        getFragmentManager().popBackStack();
    }
}
