package com.example.textwatcher;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

import com.example.demo.R;

@SuppressLint("AppCompatCustomView")
public class DelEditText extends EditText {

    private Drawable imgClear;
    private Context mContext;

    public DelEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
    }

    private void init() {
        imgClear = mContext.getResources().getDrawable(R.drawable.delete_record_icon);
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                setDrawable();
            }
        });
    }

    private void setDrawable() {
        if (length() < 1) {
            setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        } else {
            setCompoundDrawablesWithIntrinsicBounds(null, null, imgClear, null);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (imgClear != null && event.getAction() == MotionEvent.ACTION_UP) {
            int eventX = (int) event.getRawX();
            int eventY = (int) event.getRawY();
            Rect rect = new Rect();
            getGlobalVisibleRect(rect);
            rect.left = rect.right -100;
            if (rect.contains(eventX,eventY)) {
                setText("");
            }
        }
        return super.onTouchEvent(event);
    }


}
