package com.example.testproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.GridView;

import com.example.testproject.adapters.ExpandableListAdapter;
import com.example.testproject.adapters.GridViewAdapter;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SliderView sliderView;
    private GridView gridView;
    private ExpandableListView expandableListView;
    List<String> listDataHeader;
    HashMap<String,List<String>> listDataChild;

    int[] images={R.drawable.image_slider_1,R.drawable.image_slider_2,R.drawable.image_slider_3,R.drawable.image_slider_5};

    int[] products={R.drawable.product_bag_1_2,R.drawable.product_watch_1_1};
    String[] productNames;

    int[] expandableImages={R.drawable.ic_baseline_list_24,R.drawable.ic_baseline_local_police_24,R.drawable.ic_baseline_ondemand_video_24,R.drawable.ic_baseline_help_outline_24,R.drawable.ic_baseline_help_center_24,R.drawable.ic_baseline_more_vert_24};
    String[] expandableHeadersNames;
    String[] expandableHeadersChildNames;
    private ExpandableListAdapter expandableListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //variable
        sliderView=findViewById(R.id.imageSlider);
        gridView=findViewById(R.id.product_grid_view);

        //expandable List
        expandableListView=findViewById(R.id.expendable_list_view);
        expandableListAdapter =new ExpandableListAdapter(this,listDataHeader,listDataChild);

        expandableListData();

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

        //grid layout
        productNames=getResources().getStringArray(R.array.product_grid_view);
        GridViewAdapter gridViewAdapter=new GridViewAdapter(this,products,productNames);
        gridView.setAdapter(gridViewAdapter);
    }

    private void expandableListData() {

       expandableHeadersNames=getResources().getStringArray(R.array.header_expandable_list);
       expandableHeadersChildNames =getResources().getStringArray(R.array.header_expandable_list_child);

       listDataHeader=new ArrayList<>();
       listDataChild=new HashMap<>();

       for (int i=0; i<expandableHeadersNames.length;i++){
           listDataHeader.add(expandableHeadersNames[i]);

           List<String> child=new ArrayList<>();
           child.add(expandableHeadersChildNames[i]);

           listDataChild.put(listDataHeader.get(i),child);
       }
    }
}