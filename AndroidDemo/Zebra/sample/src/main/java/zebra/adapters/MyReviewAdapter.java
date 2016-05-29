package zebra.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import zebra.beans.MyReviewItem;
import zebra.views.MyReviewItemView;

/**
 * Created by multimedia on 2016-05-29.
 */
public class MyReviewAdapter extends BaseAdapter{

    private List<MyReviewItem> items = new ArrayList<MyReviewItem>();

    public void add(MyReviewItem item) {
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
        MyReviewItemView view = null;

        if (convertView == null) {
            view = new MyReviewItemView(parent.getContext());
        } else {
            view = (MyReviewItemView) convertView;
        }
        view.setViewItem(items.get(position));

        return view;
    }

}
