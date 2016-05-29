package zebra.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import example.zxing.R;
import zebra.activity.SearchActivity;
import zebra.json.Search;
import zebra.manager.NetworkManager;

/**
 * Created by multimedia on 2016-05-25.
 */
public class SearchFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_search, container, false);

        return view;
    }
}
