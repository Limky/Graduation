package zebra.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import example.zxing.R;
import zebra.adapters.NaviAdapter;
import zebra.beans.NaviItem;
import zebra.manager.MemberManager;
import zebra.manager.ScanManager;
import zebra.manager.NetworkManager;
import zebra.views.NaviHeaderView;

/**
 * Created by multimedia on 2016-05-22.
 */
public class ProductRegisterActivity extends AppCompatActivity {
    EditText productNameEdit;
    Button registerButton, cancelButton;
    String barcode, productName, id;

    //for toolbar
    DrawerLayout mDrawerLayout;
    ListView mDrawerList;
    NaviAdapter naviAdapter;
    ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        productNameEdit = (EditText) findViewById(R.id.productNameEdit);
        registerButton = (Button) findViewById(R.id.registerButton);
        cancelButton = (Button) findViewById(R.id.cancelButton);

        barcode = ScanManager.getInstance().getBarcode();
        id = MemberManager.getInstance().getId();

        //등록 버튼 클릭
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productName = productNameEdit.getText().toString();

                NetworkManager.getInstance().productRegister(ProductRegisterActivity.this, id, barcode, productName, new NetworkManager.OnResultListener<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Intent i = new Intent(ProductRegisterActivity.this, MainActivity.class);
                        startActivity(i);
                        finish();
                    }

                    @Override
                    public void onFail(int code) {

                    }
                });
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProductRegisterActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        setToolbar();
    }

    void setToolbar() {
        //Toolbar 설정
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        mDrawerList = (ListView) findViewById(R.id.naviList);
        naviAdapter = new NaviAdapter();
        mDrawerList.setAdapter(naviAdapter);

        NaviHeaderView header = new NaviHeaderView(ProductRegisterActivity.this);
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
