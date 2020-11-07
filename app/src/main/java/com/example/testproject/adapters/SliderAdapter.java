package com.example.testproject.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.testproject.MainActivity;
import com.example.testproject.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.ViewHolder> {
    //initialize variable
    int[] images;
    //create constructor
    public SliderAdapter(int[] images){
        this.images=images;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        //initialize view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.slider_item,parent,false);
        //return view
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        //set image on image view
        viewHolder.imageView.setImageResource(images[position]);
    }
    @Override
    public int getCount() {
        //return images length
        return images.length;
    }
    public static class ViewHolder extends SliderViewAdapter.ViewHolder{
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView=itemView.findViewById(R.id.auto_image_slider_1);
        }
    }
}
