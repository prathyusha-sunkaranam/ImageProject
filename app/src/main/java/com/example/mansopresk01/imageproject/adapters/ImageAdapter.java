package com.example.mansopresk01.imageproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.mansopresk01.imageproject.R;

/**
 * Created by Mansopresk01 on 10/30/2017.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIdsTxt.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_item, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
            textView.setText(mThumbIdsTxt[position]);
            imageView.setImageResource(mThumbIds[position]);
        } else {
            grid = (View) convertView;
        }

        return grid;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.repository_bg, R.drawable.dummy1_bg,R.drawable.dummy2_bg,
            R.drawable.dummy_3bg, R.drawable.dummy4_bg,
    };

    // references to our images
    private String[] mThumbIdsTxt = {"RESPOSITORY","LOREM IPSUM","LOREM IPSUM","LOREM IPSUM","LOREM IPSUM"};
}