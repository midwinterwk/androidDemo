package com.example.viewflipper;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.Nullable;

import com.example.demo.R;

public class ViewFlipperActvity extends Activity {
    private ViewFlipper vflp_help;
    private int[] resId = {R.mipmap.ic_help_view_1, R.mipmap.ic_help_view_2,
            R.mipmap.ic_help_view_3, R.mipmap.ic_help_view_4};
    private Context mContext;
    private final static int MIN_MOVE = 200;   //最小距离
    private MyGestureListener mgListener;
    private GestureDetector mDetector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vflp);
        mContext = this;
        //实例化SimpleOnGestureListener与GestureDetector对象
        mgListener = new MyGestureListener();
        mDetector = new GestureDetector(this, mgListener);

        vflp_help = findViewById(R.id.vflp_help);
        for (int i = 0; i < resId.length; i++) {
            vflp_help.addView(getImageView(resId[i]));
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mDetector.onTouchEvent(event);
    }

    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e1.getX() - e2.getX() > MIN_MOVE) {
                vflp_help.setInAnimation(mContext, R.anim.right_in);
                vflp_help.setOutAnimation(mContext, R.anim.right_out);
                vflp_help.showNext();
            } else if (e2.getX() - e1.getX() > MIN_MOVE) {
                vflp_help.setInAnimation(mContext, R.anim.left_in);
                vflp_help.setOutAnimation(mContext, R.anim.left_out);
                vflp_help.showPrevious();
            }
            return true;
        }
    }

    private ImageView getImageView(int resid) {
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(resid);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        return imageView;
    }
}
