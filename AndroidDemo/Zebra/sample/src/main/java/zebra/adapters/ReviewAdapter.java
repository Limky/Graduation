package zebra.adapters;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import zebra.beans.ReviewItem;
import zebra.views.ReviewItemView;

/**
 * Created by multimedia on 2016-05-13.
 */
public class ReviewAdapter extends BaseAdapter {

    private List<ReviewItem> items = new ArrayList<ReviewItem>();


    public void add(ReviewItem item) {
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
        ReviewItemView view = null;

        if (convertView == null) {
            view = new ReviewItemView(parent.getContext());
        } else {
            view = (ReviewItemView) convertView;
        }
        view.setViewItem(items.get(position));

        return view;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

}
