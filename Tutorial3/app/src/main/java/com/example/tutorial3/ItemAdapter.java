package com.example.tutorial3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {

    LayoutInflater mInflater; // m because it is a member of the class
    // Inflater is a class that can take a layout XML file and turn it into a View object

    String [] items;
    String [] prices;
    String [] descriptions;

    // Constructor
    public ItemAdapter(Context c, String [] i, String [] p, String [] d) {
        items = i;
        prices = p;
        descriptions = d;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int i) {
        return items[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    /**
     *
     * @param i i is the index of the item in the list that is currently working with
     * @param view view is the view that is currently being worked with NOT USED HERE
     * @param viewGroup viewGroup is the parent view that the view is attached to NOT USED HERE
     * @return
     */
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // How to present the information
        View v = mInflater.inflate(R.layout.my_listview_detail, null); // inflate takes layout and a view and turns it into a view object
        TextView nameTextView = (TextView) v.findViewById(R.id.nameTextView); // v is the current view
        TextView descriptionTextView = (TextView) v.findViewById(R.id.descriptionTextView);
        TextView priceTextView = (TextView) v.findViewById(R.id.priceTextView);

        String name = items[i];
        String description = descriptions[i];
        String cost = prices[i];

        nameTextView.setText(name);
        descriptionTextView.setText(description);
        priceTextView.setText(cost);

        return v;
    }
}
