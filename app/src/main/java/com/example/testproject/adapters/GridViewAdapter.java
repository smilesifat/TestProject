package com.example.testproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testproject.R;

public class GridViewAdapter extends BaseAdapter {

    Context context;
    int[] products;
    String[] productNames;
    private LayoutInflater inflater;

    public GridViewAdapter(Context context, int[] products, String[] productNames) {
        this.context = context;
        this.products = products;
        this.productNames = productNames;
    }

    @Override
    public int getCount() {
        return productNames.length;
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
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.sample_grid_view,parent,false);

            ImageView imageView= convertView.findViewById(R.id.product_image);
            TextView textView= convertView.findViewById(R.id.product_names);

            imageView.setImageResource(products[position]);
            textView.setText(productNames[position]);
        }
        return convertView;
    }
}
