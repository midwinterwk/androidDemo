package com.example.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MutiLayoutAdapter<T> extends BaseAdapter {
    //定义两个类别标志
    public static final int TYPE_BOOK = 0;
    public static final int TYPE_APP = 1;
    private Context mContext;
    private ArrayList<T> mData = null;

    public MutiLayoutAdapter(Context mContext,ArrayList<T> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int postion) {
        return mData.get(postion);
    }

    @Override
    public long getItemId(int postion) {
        return postion;
    }

    @Override
    public int getItemViewType(int position) {
        if (mData.get(position) instanceof App) {
            return TYPE_APP;
        } else if (mData.get(position) instanceof Book) {
            return TYPE_BOOK;
        } else {
            return super.getItemViewType(position);
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        ViewHodler1 hodler1 = null;
        ViewHodler2 hodler2 = null;
        if (convertView == null) {
            switch (type) {
                case TYPE_APP:
                    hodler1 = new ViewHodler1();
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.item_one, parent, false);
                    hodler1.img_icon = convertView.findViewById(R.id.img_icon);
                    hodler1.txt_aname = convertView.findViewById(R.id.txt_aname);
                    convertView.setTag(R.id.Tag_APP,hodler1);
                    break;
                case TYPE_BOOK:
                    hodler2 = new ViewHodler2();
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.item_two, parent,false);
                    hodler2.txt_bname = convertView.findViewById(R.id.txt_bname);
                    hodler2.txt_bauthor = convertView.findViewById(R.id.txt_bauthor);
                    convertView.setTag(R.id.Tag_Book,hodler2);
                    break;
            }
        } else {
            switch (type) {
                case TYPE_APP:
                    hodler1 = (ViewHodler1) convertView.getTag(R.id.Tag_APP);
                    break;
                case TYPE_BOOK:
                    hodler2 = (ViewHodler2) convertView.getTag(R.id.Tag_Book);
                    break;
            }
        }

        Object obj = mData.get(position);
        //设置下控件的值
        switch (type) {
            case TYPE_APP:
                App app = (App) obj;
                if (app != null) {
                    hodler1.img_icon.setImageResource(app.getaIcon());
                    hodler1.txt_aname.setText(app.getaName());
                }
                break;
            case TYPE_BOOK:
                Book book = (Book) obj;
                if (book != null) {
                    hodler2.txt_bname.setText(book.getbName());
                    hodler2.txt_bauthor.setText(book.getbAuthor());
                }
                break;
        }
        return convertView;
    }

    private static class ViewHodler1 {
        ImageView img_icon;
        TextView txt_aname;
    }

    private static class ViewHodler2 {
        TextView txt_bname;
        TextView txt_bauthor;
    }
}
