package com.example.taskapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import com.bumptech.glide.load.engine.Resource;

import static android.content.Context.MODE_PRIVATE;

public class FormActivity extends AppCompatActivity {
    float new_coef = 1.3f;
    EditText titleEditText;
    EditText descriptionEditText;

    public static String RESULT_KEY= "result_key";
    final float start_value = 0.7f;
    final float step =0.15f;
    int size_coef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        titleEditText=findViewById(R.id.edit_title);
        descriptionEditText= findViewById(R.id.edit_description);






       SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(FormActivity.this);




       String title= preferences.getString("Task_title"," ");
       titleEditText.setText(title);
       String desc1 = preferences.getString("Task_desc", " ");
       descriptionEditText.setText(desc1);

        if(getSupportActionBar()!=null)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);







        SeekBar seekBar = findViewById(R.id.seek_bar);
        if(seekBar!=null){
            seekBar.setProgress(size_coef);
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    size_coef=progress;
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
            SharedPreferences settings=getSharedPreferences("FormAppSett", MODE_PRIVATE);
            SharedPreferences.Editor value_add = settings.edit();
            value_add.putFloat("size_coef", new_coef);
            value_add.commit();

            Resources res = getResources();
            float coef= start_value+size_coef*step;
            Configuration configuration = new Configuration(res.getConfiguration());
            configuration.fontScale= coef;
            res.updateConfiguration(configuration, res.getDisplayMetrics());


        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();

        return super.onOptionsItemSelected(item);
    }

    public void onClickCancel(View view) {
        finish();

    }

    public void OnClickSave(View view) {
        Intent intent =new Intent();
        String title= titleEditText.getText().toString();
        String description= descriptionEditText.getText().toString();
        Task task= new Task(title,description);
        intent.putExtra(RESULT_KEY,task);
        setResult(RESULT_OK, intent);
        Log.d("tag12", title + " " + description);
        finish();



    }

    @Override
    public void onBackPressed() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(FormActivity.this);
        SharedPreferences.Editor editor= preferences.edit();
        String title = titleEditText.getText().toString();
        String desc = descriptionEditText.getText().toString();
        editor.putString("Title", title );
        editor.putString("Desc", desc);
        editor.apply();
        super.onBackPressed();
    }




}
