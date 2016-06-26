package zebra.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import example.zxing.R;
import zebra.activity.ReviewActivityTest;
import zebra.adapters.SearchAdapter;
import zebra.beans.SearchItem;
import zebra.json.Review;
import zebra.json.Search;
import zebra.manager.NetworkManager;
import zebra.manager.ScanManager;
import zebra.manager.SearchManager;

/**
 * Created by multimedia on 2016-05-29.
 */
public class CategorySearchFragment extends Fragment {

    ListView searchList;
    SearchAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_ok, container, false);

        Search result = SearchManager.getInstance().getSearch();
        setListView(view, result);

        searchList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final View viewInner = view;
                SearchItem item = (SearchItem) parent.getAdapter().getItem(position);
                ScanManager.getInstance().setBarcode(item.barcode);
                NetworkManager.getInstance().review(view.getContext(), item.barcode, new NetworkManager.OnResultResponseListener<Review>() {
                    @Override
                    public void onSuccess(Review result) {
                        Intent i = new Intent(viewInner.getContext(), ReviewActivityTest.class);
                        ScanManager.getInstance().setProductUrl(result.productInfo.productUrl);
                        i.putExtra("Result", result);
                        startActivity(i);
                    }

                    @Override
                    public void onFail(int code, String responseString) {

                    }
                });
            }
        });
        return view;
    }

    private void setListView(View view, Search result){
        searchList = (ListView) view.findViewById(R.id.searchList);
        mAdapter = new SearchAdapter();
        searchList.setAdapter(mAdapter);

        String productUrl;
        String productName;
        double starPoint;
        String barcode;

        for (int i = 0; i < result.productInfo.size(); i++) {
            productUrl = result.productInfo.get(i).productUrl;
            productName = result.productInfo.get(i).productName;
            starPoint = result.productInfo.get(i).starPoint;
            barcode = result.productInfo.get(i).barcode;
            SearchItem item = new SearchItem(productUrl, productName, starPoint, barcode);
            mAdapter.add(item);
        }
    }
}
