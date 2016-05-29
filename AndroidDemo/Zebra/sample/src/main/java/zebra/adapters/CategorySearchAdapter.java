package zebra.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import zebra.beans.SearchItem;
import zebra.views.SearchItemView;

/**
 * Created by multimedia on 2016-05-29.
 */
public class CategorySearchAdapter extends BaseAdapter {

    private List<SearchItem> items = new ArrayList<SearchItem>();


    public void add(SearchItem item) {
        items.add(item);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SearchItemView view = null;

        if (convertView == null) {
            view = new SearchItemView(parent.getContext());
        } else {
            view = (SearchItemView) convertView;
        }
        view.setViewItem(items.get(position));

        return view;
    }
}