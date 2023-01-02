package com.example.unitconverter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ConversionAdapter extends BaseAdapter {

    LayoutInflater mInflater; // m because it is a member of the class, common in Android development
    ArrayList<ConversionResult> conversionResults;

    // Constructor
    public ConversionAdapter(Context c, ArrayList<ConversionResult> conversionResults) {
        this.conversionResults = conversionResults;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE); // Inflater is a class that can take a layout XML file and turn it into a View object
        // Line above means that we are getting the layout inflater service from the context
        // The context is the activity that is currently running
    }

    @Override
    public int getCount() {
        return conversionResults.size();
    }

    @Override
    public Object getItem(int i) {
        return conversionResults.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // How to present the information
        View v = mInflater.inflate(R.layout.listview_detail, null); // inflate takes layout and a view and turns it into a view object
        TextView fromNumberTextView = (TextView) v.findViewById(R.id.fromNumber); // v is the current view
        TextView toNumberTextView = (TextView) v.findViewById(R.id.toNumber);
        TextView conversionTypeTextView = (TextView) v.findViewById(R.id.conversionType);

        String fromNumber = conversionResults.get(i).getFromValue().toString();
        String toNumber = conversionResults.get(i).getToValue().toString();
        String conversionType = conversionResults.get(i).getType().toString();
        // For the conversion type, uncapitalize and remove the underscores
        conversionType = conversionType.substring(0, 1).toUpperCase() + conversionType.substring(1).toLowerCase();
        conversionType = conversionType.replace("_", " ");

        // Set the text for the text views
        fromNumberTextView.setText(fromNumber);
        toNumberTextView.setText(toNumber);
        conversionTypeTextView.setText(conversionType);

        return v;
    }
}
