package com.example.hometrainer.ui.challenge_one_day;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.hometrainer.MainActivity;
import com.example.hometrainer.R;

public class OnedayFragment extends Fragment {
    public static OnedayFragment newInstance() {

        return new OnedayFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

        View root = inflater.inflate(R.layout.fragment_challenge_one_day, container, false);

        Button one_day1 = (Button) root.findViewById(R.id.one_day_challenge_take_up1);
                one_day1.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        transaction.add(R.id.nav_host_fragment, OnedayFragment1.newInstance());
                        transaction.addToBackStack(null);
                        transaction.commit();
            }
        });
        Button one_day2 = (Button) root.findViewById(R.id.one_day_challenge_take_up2);
        one_day2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(OnedayFragment2.newInstance());


            }
        });

        Button one_day3 = (Button) root.findViewById(R.id.one_day_challenge_take_up3);
        one_day3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(OnedayFragment3.newInstance());


            }
        });
        Button one_day4 = (Button) root.findViewById(R.id.one_day_challenge_take_up4);
        one_day4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.replaceFragment(OnedayFragment4.newInstance());


            }
        });




        return root;
    }
}
