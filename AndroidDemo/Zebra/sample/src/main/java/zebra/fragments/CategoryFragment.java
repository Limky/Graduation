package zebra.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import example.zxing.R;
import zebra.activity.CategoryActivity;
import zebra.json.Search;
import zebra.manager.NetworkManager;
import zebra.manager.SearchManager;

/**
 * Created by multimedia on 2016-05-27.
 */
public class CategoryFragment extends Fragment {
    LinearLayout bookButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_category, container, false);

        bookButton = (LinearLayout)v.findViewById(R.id.bookButton);
        bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                network("1");
                Toast.makeText((CategoryActivity)getActivity(), "눌림", Toast.LENGTH_LONG).show();
            }
        });

        return v;
    }

    public void network(String category){
        NetworkManager.getInstance().category((CategoryActivity)getActivity(), category, new NetworkManager.OnResultResponseListener<Search>() {
            @Override
            public void onSuccess(Search result) {
                ((CategoryActivity)getActivity()).popFragment();
                SearchManager.getInstance().setSearch(result);
                ((CategoryActivity)getActivity()).pushCategorySearchFragment();
            }

            @Override
            public void onFail(int code, String responseString) {
                Toast.makeText((CategoryActivity)getActivity(), "실패"+code, Toast.LENGTH_LONG).show();
            }
        });
    }
}
