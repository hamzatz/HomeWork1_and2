package com.example.taskapp;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.util.TypedValue;

public class MyEditTextView extends AppCompatEditText {


    public MyEditTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        InitSize(context);
    }

    private void InitSize(Context context) {

        Activity activity =(Activity)context;
        float koef=((FormAppSett)activity.getApplication()).getSize_coef();

        float cur_size=getTextSize();

        setTextSize(TypedValue.COMPLEX_UNIT_PX, cur_size*koef);
    }

}
