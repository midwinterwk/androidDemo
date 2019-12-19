package com.example.viewpager;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.viewpager.widget.ViewPager;

import com.example.demo.R;

import java.util.ArrayList;

/**
 * Created by Jay on 2015/10/8 0008.
 */
public class ViewPageThreeActivity extends Activity {

    private ViewPager vpager_three;
    private ArrayList<View> aList;
    private ArrayList<String> sList;
    private MyPagerTitleAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vp_three);
        vpager_three = (ViewPager) findViewById(R.id.vpager_three);
        aList = new ArrayList<View>();
        LayoutInflater li = getLayoutInflater();
        aList.add(li.inflate(R.layout.view_one, null, false));
        aList.add(li.inflate(R.layout.view_two, null, false));
        aList.add(li.inflate(R.layout.view_three, null, false));
        sList = new ArrayList<String>();
        sList.add("橘黄");
        sList.add("淡黄");
        sList.add("浅棕");
        mAdapter = new MyPagerTitleAdapter(aList, sList);
        vpager_three.setAdapter(mAdapter);
    }
}
