package com.example.hometrainer.ui.challenge;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.hometrainer.MainActivity;
import com.example.hometrainer.R;
import com.example.hometrainer.ui.challenge_month_day.MonthdayFragment;
import com.example.hometrainer.ui.challenge_one_day.OnedayFragment;
import com.example.hometrainer.ui.challenge_week_day.WeekdayFragment;

public class ChallengeFragment extends Fragment {

    public static ChallengeFragment newInstance() {
        return new ChallengeFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_challenge, container, false);

        Button one_day = (Button) root.findViewById(R.id.one_day_challenge_more);
        one_day.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity)getActivity();
                activity.replaceFragment(OnedayFragment.newInstance());

            }
        });
        Button one_day2 = (Button) root.findViewById(R.id.week_day_challenge_more);
        one_day2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity)getActivity();
               activity.replaceFragment(WeekdayFragment.newInstance());

            }
        });
        Button one_day3 = (Button) root.findViewById(R.id.month_day_challenge_more);
        one_day3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity)getActivity();
                activity.replaceFragment(MonthdayFragment.newInstance());

            }
        });
        return root;
    }
}
