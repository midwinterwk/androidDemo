package com.example.viewpager;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.example.demo.R;

import java.util.ArrayList;

public class ViewPageTwoActivity extends Activity {
    private ViewPager vpager_two;
    private ArrayList<View> aList;
    private ArrayList<String> sList;
    private MyPagerTitleAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vp_two);
        vpager_two = (ViewPager) findViewById(R.id.vpager_two);

        aList = new ArrayList<View>();
        LayoutInflater li = getLayoutInflater();
        aList.add(li.inflate(R.layout.view_one,null,false));
        aList.add(li.inflate(R.layout.view_two,null,false));
        aList.add(li.inflate(R.layout.view_three, null, false));
        sList = new ArrayList<String>();
        sList.add("橘黄");
        sList.add("淡黄");
        sList.add("浅棕");
        mAdapter = new MyPagerTitleAdapter(aList,sList);
        vpager_two.setAdapter(mAdapter);
    }
}
