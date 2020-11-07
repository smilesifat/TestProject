package com.example.testproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.example.testproject.adapters.SliderAdapter;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class MainActivity extends AppCompatActivity {

    SliderView sliderView;
    int[] images={R.drawable.image_slider_1,R.drawable.image_slider_2,R.drawable.image_slider_3,R.drawable.image_slider_5};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //variable
        sliderView=findViewById(R.id.imageSlider);

        //Initialize adapter
//        SliderAdapter sliderAdapter=new SliderAdapter(images);
//        sliderView.setSliderAdapter(sliderAdapter);

        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
//        sliderView.setIndicatorSelectedColor(Color.WHITE);
//        sliderView.setIndicatorUnselectedColor(Color.GRAY);
//        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();
    }
}