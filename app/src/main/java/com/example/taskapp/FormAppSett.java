package com.example.taskapp;

import android.app.Application;
import android.content.SharedPreferences;

public class FormAppSett extends Application {

    public float size_coef;

    public float getSize_coef(){

        return size_coef;
    }

    @Override
    public void onCreate(){
        super.onCreate();

        SharedPreferences settings= getSharedPreferences("FormAppSett",MODE_PRIVATE);
        size_coef= settings.getFloat("size_coef", 1f);


    }



}
