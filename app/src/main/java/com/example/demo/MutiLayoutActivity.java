package com.example.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MutiLayoutActivity extends Activity {

    private ListView listContent;
    private ListAdapter mutiAdapter;
    private ArrayList<Object> mData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muti);

        //数据准备：
        mData = new ArrayList<Object>();
        for(int i = 0;i < 20;i++){
            switch ((int)(Math.random() * 2)){
                case MutiLayoutAdapter.TYPE_BOOK:
                    mData.add(new Book("《第一行代码》","郭霖"));
                    break;
                case MutiLayoutAdapter.TYPE_APP:
                    mData.add(new App(R.mipmap.iv_icon_baidu,"百度"));
                    break;
            }
        }

        listContent = findViewById(R.id.list_content);
        mutiAdapter = new MutiLayoutAdapter<>(MutiLayoutActivity.this,mData);
        listContent.setAdapter(mutiAdapter);
    }
}
