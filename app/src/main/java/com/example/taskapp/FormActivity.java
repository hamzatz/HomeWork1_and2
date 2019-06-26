package com.example.taskapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class FormActivity extends AppCompatActivity {

    EditText titleEditText;
    EditText descriptionEditText;
    public static String RESULT_KEY= "result_key";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        if(getSupportActionBar()!=null)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        titleEditText=findViewById(R.id.edit_title);
        descriptionEditText= findViewById(R.id.edit_description);
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
}
