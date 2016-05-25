package zebra.fragments;

import android.app.Fragment;
import android.app.SearchManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import example.zxing.R;
import zebra.adapters.SearchAdapter;
import zebra.beans.SearchItem;
import zebra.json.Search;

/**
 * Created by multimedia on 2016-05-25.
 */
public class SearchOkFragment extends Fragment {

    ListView searchList;
    SearchAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_ok, container, false);

        Search result = zebra.manager.SearchManager.getInstance().getSearch();
        setListView(view, result);

        return view;
    }

    private void setListView(View view, Search result){
        searchList = (ListView) view.findViewById(R.id.searchList);
        mAdapter = new SearchAdapter();
        searchList.setAdapter(mAdapter);

        String productUrl;
        String productName;
        double starPoint;

        for (int i = 0; i < result.productInfo.size(); i++) {
            productUrl = result.productInfo.get(i).productUrl;
            productName = result.productInfo.get(i).productName;
            starPoint = result.productInfo.get(i).starPoint;
            SearchItem item = new SearchItem(productUrl, productName, starPoint);
            mAdapter.add(item);
        }
    }
}
