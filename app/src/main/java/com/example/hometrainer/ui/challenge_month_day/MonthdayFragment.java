package com.example.hometrainer.ui.challenge_month_day;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hometrainer.MainActivity;
import com.example.hometrainer.R;
import com.example.hometrainer.ui.challenge_one_day.OnedayFragment1;


public class MonthdayFragment extends Fragment {

    public static MonthdayFragment newInstance() {


        return  new MonthdayFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_challenge_month_day, container, false);

        Button one_day1 = (Button) rootview.findViewById(R.id.month_day_challenge_take_up1);
        one_day1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(MonthdayFragment1.newInstance());


            }
        });
        Button one_day2= (Button) rootview.findViewById(R.id.month_day_challenge_take_up2);
        one_day2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(MonthdayFragment2.newInstance());


            }
        });
        Button one_day3 = (Button) rootview.findViewById(R.id.month_day_challenge_take_up3);
        one_day3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(MonthdayFragment3.newInstance());


            }
        });
        Button one_day4 = (Button) rootview.findViewById(R.id.month_day_challenge_take_up4);
        one_day4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(MonthdayFragment4.newInstance());


            }
        });
        Button one_day5 = (Button) rootview.findViewById(R.id.month_day_challenge_take_up5);
        one_day5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(MonthdayFragment5.newInstance());


            }
        });Button one_day6 = (Button) rootview.findViewById(R.id.month_day_challenge_take_up6);
        one_day6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(MonthdayFragment6.newInstance());


            }
        });Button one_day7 = (Button) rootview.findViewById(R.id.month_day_challenge_take_up7);
        one_day7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(MonthdayFragment7.newInstance());


            }
        });
        Button one_day8 = (Button) rootview.findViewById(R.id.month_day_challenge_take_up8);
        one_day8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(MonthdayFragment8.newInstance());


            }
        });
        Button one_day9 = (Button) rootview.findViewById(R.id.month_day_challenge_take_up9);
        one_day9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(MonthdayFragment9.newInstance());


            }
        });
        Button one_day10 = (Button) rootview.findViewById(R.id.month_day_challenge_take_up10);
        one_day10.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(MonthdayFragment10.newInstance());


            }
        });
        Button one_day11 = (Button) rootview.findViewById(R.id.month_day_challenge_take_up11);
        one_day11.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(MonthdayFragment11.newInstance());


            }
        });
        Button one_day12 = (Button) rootview.findViewById(R.id.month_day_challenge_take_up12);
        one_day12.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(MonthdayFragment12.newInstance());


            }
        });
        Button one_day13 = (Button) rootview.findViewById(R.id.month_day_challenge_take_up13);
        one_day13.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(MonthdayFragment13.newInstance());


            }
        });
        Button one_day14 = (Button) rootview.findViewById(R.id.month_day_challenge_take_up14);
        one_day1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(MonthdayFragment1.newInstance());


            }
        });
        Button one_day15 = (Button) rootview.findViewById(R.id.month_day_challenge_take_up15);
        one_day15.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(MonthdayFragment15.newInstance());


            }
        });Button one_day16 = (Button) rootview.findViewById(R.id.month_day_challenge_take_up16);
        one_day16.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(MonthdayFragment16.newInstance());


            }
        });
        Button one_day17 = (Button) rootview.findViewById(R.id.month_day_challenge_take_up17);
        one_day17.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(MonthdayFragment17.newInstance());


            }
        });
        Button one_day18 = (Button) rootview.findViewById(R.id.month_day_challenge_take_up18);
        one_day18.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(MonthdayFragment18.newInstance());


            }
        });
        Button one_day19 = (Button) rootview.findViewById(R.id.month_day_challenge_take_up19);
        one_day19.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(MonthdayFragment19.newInstance());


            }
        });
        Button one_day20 = (Button) rootview.findViewById(R.id.month_day_challenge_take_up20);
        one_day20.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(MonthdayFragment20.newInstance());


            }
        });
        Button one_day21 = (Button) rootview.findViewById(R.id.month_day_challenge_take_up21);
        one_day21.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(MonthdayFragment21.newInstance());


            }
        });
        Button one_day22 = (Button) rootview.findViewById(R.id.month_day_challenge_take_up22);
        one_day22.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(MonthdayFragment22.newInstance());


            }
        });
        Button one_day23 = (Button) rootview.findViewById(R.id.month_day_challenge_take_up23);
        one_day23.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(MonthdayFragment23.newInstance());


            }
        });
        Button one_day24 = (Button) rootview.findViewById(R.id.month_day_challenge_take_up24);
        one_day24.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(MonthdayFragment24.newInstance());


            }
        });
        Button one_day25 = (Button) rootview.findViewById(R.id.month_day_challenge_take_up25);
        one_day25.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(MonthdayFragment25.newInstance());


            }
        });
        Button one_day26 = (Button) rootview.findViewById(R.id.month_day_challenge_take_up26);
        one_day26.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(MonthdayFragment26.newInstance());


            }
        });
        Button one_day27 = (Button) rootview.findViewById(R.id.month_day_challenge_take_up27);
        one_day27.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(MonthdayFragment27.newInstance());


            }
        });
        Button one_day28 = (Button) rootview.findViewById(R.id.month_day_challenge_take_up28);
        one_day28.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(MonthdayFragment28.newInstance());


            }
        });

        Button one_day29 = (Button) rootview.findViewById(R.id.month_day_challenge_take_up29);
        one_day29.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(MonthdayFragment29.newInstance());


            }
        });
        Button one_day30 = (Button) rootview.findViewById(R.id.month_day_challenge_take_up30);
        one_day30.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(MonthdayFragment30.newInstance());


            }
        });





        return rootview;
    }
}
