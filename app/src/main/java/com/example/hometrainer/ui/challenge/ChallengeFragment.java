package com.example.hometrainer.ui.challenge;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.hometrainer.MainActivity;
import com.example.hometrainer.R;
import com.example.hometrainer.ui.challenge_one_day.OnedayFragment;

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

        return root;
    }
}
