package com.example.grid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.demo.R;

import java.util.ArrayList;

public class GridActivity extends Activity {
    private GridActivity mContext;
    private GridView grid_photo;
    private ArrayList<Icon> mData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        mContext = this;
        grid_photo = findViewById(R.id.grid_photo);

        mData = new ArrayList<>();
        mData.add(new Icon(R.mipmap.iv_icon_baidu,"Icon 1"));
        mData.add(new Icon(R.mipmap.iv_icon_douban,"Icon 2"));
        mData.add(new Icon(R.mipmap.iv_icon_zhifubao,"Icon 3"));
        mData.add(new Icon(R.mipmap.iv_icon_zhifubao,"Icon 4"));
        mData.add(new Icon(R.mipmap.iv_icon_baidu,"Icon 5"));
        mData.add(new Icon(R.mipmap.iv_icon_douban,"Icon 6"));
        mData.add(new Icon(R.mipmap.iv_icon_douban,"Icon 7"));
        mData.add(new Icon(R.mipmap.iv_icon_zhifubao,"Icon 8"));
        mData.add(new Icon(R.mipmap.iv_icon_baidu,"Icon 9"));


        BaseAdapter mAdapter = new MyAdapter<Icon>(mData, R.layout.item_grid_icon) {

            @Override
            public void bindView(ViewHolder holder, Icon obj) {
                holder.setImageResource(R.id.img_icon, obj.getiId());
                holder.setText(R.id.txt_icon, obj.getiName());
            }
        };
        grid_photo.setAdapter(mAdapter);

        grid_photo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(mContext, "你点击了~" + position + "~项", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
