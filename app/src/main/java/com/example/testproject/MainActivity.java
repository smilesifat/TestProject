package com.example.testproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.testproject.adapters.ExpandableListAdapter;
import com.example.testproject.adapters.GridViewAdapter;
import com.example.testproject.adapters.SliderAdapter;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SliderView sliderView;
    private GridView gridView;
    private ExpandableListView expandableListView;
    List<String> listDataHeader;
    HashMap<String,List<String>> listDataChild;

    int[] images={R.drawable.image_slider_1,R.drawable.image_slider_2,R.drawable.image_slider_3};

    int[] products={R.drawable.product_bag_1_2,R.drawable.product_watch_1_1};
    String[] productNames;

    int[] expandableImages={R.drawable.ic_baseline_list_24,R.drawable.ic_baseline_local_police_24,R.drawable.ic_baseline_ondemand_video_24,R.drawable.ic_baseline_help_outline_24,R.drawable.ic_baseline_help_center_24,R.drawable.ic_baseline_more_vert_24};
    ArrayList<String> listGroup=new ArrayList<>();
    HashMap<String,ArrayList<String>> listChild=new HashMap<>();
    private ExpandableListAdapter expandableListAdapter;

    ImageView Shoe1;
    ImageView Shoe2;
    ImageView Shoe3;
    ImageView Shoe4;
    ImageView Shoe5;

    TextView StrikeLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //variable
        sliderView=findViewById(R.id.imageSlider);
        gridView=findViewById(R.id.product_grid_view);

        //expandable List

        expandableListView=findViewById(R.id.expendable_list_view);
        for(int g=0;g<=10;g++){
            listGroup.add("Group"+g);
            ArrayList<String> arrayList=new ArrayList<>();
            for(int c=0;c<=5;c++){
                arrayList.add("Item"+c);
            }
            listChild.put(listGroup.get(g),arrayList);
        }

        expandableListAdapter =new ExpandableListAdapter(listGroup,listChild);
        expandableListView.setAdapter(expandableListAdapter);


        Shoe1 =findViewById(R.id.shoes1_imageViw);
        Shoe2 =findViewById(R.id.shoes2_imageViw);
        Shoe3 =findViewById(R.id.shoes3_imageViw);
        Shoe4 =findViewById(R.id.shoes4_imageViw);
        Shoe5 =findViewById(R.id.shoes5_imageViw);

        StrikeLine=findViewById(R.id.bdt_strike_line);
        StrikeLine.setPaintFlags(StrikeLine.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);

        Shoe3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.product_options);
            }
        });
        Shoe2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //setContentView(R.layout.product_options);

                BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(
                        MainActivity.this,R.style.BottomSheetDialogTheme);
                View bottomSheetView= LayoutInflater.from(getApplicationContext()).
                        inflate(R.layout.product_options ,
                                (LinearLayout) findViewById(R.id.bottomSheetContainer));
                bottomSheetView.findViewById(R.id.product_cancel).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            bottomSheetDialog.dismiss();
                    }
                });
            }

        });
        Shoe3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        //Initialize adapter
        SliderAdapter sliderAdapter=new SliderAdapter(images);
        sliderView.setSliderAdapter(sliderAdapter);

        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setScrollTimeInSec(3); //set scroll delay in seconds :
        sliderView.startAutoCycle();

        //grid layout
        productNames=getResources().getStringArray(R.array.product_grid_view);
        GridViewAdapter gridViewAdapter=new GridViewAdapter(this,products,productNames);
        gridView.setAdapter(gridViewAdapter);
    }

}