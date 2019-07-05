package com.example.taskapp;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static com.example.taskapp.R.color.colorAccent;


/**
 * A simple {@link Fragment} subclass.
 */
public class BoardFragment extends Fragment {

    ImageView imageView;
    TextView textTitle;
    TextView textDesc;
    Button startBtn;
    Button skipBtn;






    public BoardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_board, container, false);
         imageView = view.findViewById(R.id.imageView);
         textTitle = view.findViewById(R.id.textTitle);
         textDesc= view.findViewById(R.id.textDesc);
        startBtn= view.findViewById(R.id.button_view);
        skipBtn = view.findViewById(R.id.button_skip);

       skipBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               SharedPreferences preferences= getActivity().getSharedPreferences("settings", Context.MODE_PRIVATE);
               preferences.edit().putBoolean("isShown", true).apply();
               startActivity(new Intent(getContext(),MainActivity.class));

               getActivity().finish();
           }
       });



        startBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
             SharedPreferences preferences= getActivity().getSharedPreferences("settings", Context.MODE_PRIVATE);
             preferences.edit().putBoolean("isShown", true).apply();
             startActivity(new Intent(getContext(),MainActivity.class));

             getActivity().finish();
             }
         });
        RelativeLayout relativeLayout = view.findViewById(R.id.back);
         int pos = getArguments().getInt("pos");
         switch (pos){
             case 0:
                 imageView.setImageResource(R.drawable.smile);
                 textTitle.setText("Привет!");
                 relativeLayout.setBackgroundColor(Color.RED);
                 skipBtn.setVisibility(View.VISIBLE);
                 break;

             case 1:
                 imageView.setImageResource(R.drawable.smile1);
                 textTitle.setText("Как дела?");
                 relativeLayout.setBackgroundColor(Color.BLUE);
                 skipBtn.setVisibility(View.VISIBLE);
                 break;

             case 2:
                 imageView.setImageResource(R.drawable.smile2);
                 textTitle.setText("Что делаешь?");
                 relativeLayout.setBackgroundColor(Color.GREEN);
                 startBtn.setVisibility(View.VISIBLE);
                 break;
         }
        return view;

    }

}
