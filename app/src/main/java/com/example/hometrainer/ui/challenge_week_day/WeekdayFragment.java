package com.example.hometrainer.ui.challenge_week_day;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hometrainer.MainActivity;
import com.example.hometrainer.R;
import com.example.hometrainer.ui.challenge_one_day.OnedayFragment1;


public class WeekdayFragment extends Fragment {


    public static WeekdayFragment newInstance() {
        return new WeekdayFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_challenge_week_day, container, false);


        Button one_day1 = (Button) rootview.findViewById(R.id.week_day_challenge_take_up1);
        one_day1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(WeekdayFragment1.newInstance());


            }
        });
        Button one_day2 = (Button) rootview.findViewById(R.id.week_day_challenge_take_up2);
        one_day2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(WeekdayFragment2.newInstance());


            }
        });
        Button one_day3 = (Button) rootview.findViewById(R.id.week_day_challenge_take_up3);
        one_day3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(WeekdayFragment3.newInstance());


            }
        });
        Button one_day4 = (Button) rootview.findViewById(R.id.week_day_challenge_take_up4);
        one_day4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(WeekdayFragment4.newInstance());


            }
        });
        Button one_day5 = (Button) rootview.findViewById(R.id.week_day_challenge_take_up5);
        one_day5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(WeekdayFragment5.newInstance());


            }
        });
        Button one_day6 = (Button) rootview.findViewById(R.id.week_day_challenge_take_up6);
        one_day6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(WeekdayFragment6.newInstance());


            }
        });
        Button one_day7 = (Button) rootview.findViewById(R.id.week_day_challenge_take_up7);
        one_day7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(WeekdayFragment7.newInstance());


            }
        });
        return rootview;
    }
}
