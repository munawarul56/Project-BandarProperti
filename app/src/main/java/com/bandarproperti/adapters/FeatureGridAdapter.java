package com.bandarproperti.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bandarproperti.R;

/**
 * Created by arief on 19-Oct-16.
 */

public class FeatureGridAdapter extends BaseAdapter {

    private Context context;
    private final String[] string;

    public FeatureGridAdapter(Context context, String[] string) {
        this.context = context;
        this.string = string;
    }

    @Override
    public int getCount() {
        return string.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            grid = new View(context);
            grid = inflater.inflate(R.layout.feature_grid, null);
            TextView textView = (TextView) grid.findViewById(R.id.featureText);
            textView.setText(string[position]);
        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}
