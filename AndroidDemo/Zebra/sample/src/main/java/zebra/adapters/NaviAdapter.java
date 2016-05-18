package zebra.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import zebra.beans.NaviItem;
import zebra.beans.ReviewItem;
import zebra.views.NaviItemView;

/**
 * Created by multimedia on 2016-05-18.
 */
public class NaviAdapter extends BaseAdapter {
    private List<NaviItem> items = new ArrayList<NaviItem>();

    public void add(NaviItem item) {
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
        NaviItemView view = null;
        if (convertView == null) {
            view = new NaviItemView(parent.getContext());
        } else {
            view = (NaviItemView) convertView;
        }
        view.setViewItem(items.get(position));
        return view;
    }
}
