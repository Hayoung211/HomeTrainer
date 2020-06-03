package com.example.hometrainer.ui.challenge_one_day;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.hometrainer.MainActivity;
import com.example.hometrainer.R;

public class OnedayFragment extends Fragment implements MainActivity.onKeyBackPressedListener {
    public static OnedayFragment newInstance() {
        return new OnedayFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_challenge_one_day, container, false);

        return root;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((MainActivity)context).setOnKeyBackPressedListener(this);
    }

    @Override
    public void onBackKey() {
        MainActivity activity = (MainActivity) getActivity();

        activity.onBackPressed();
    }
}
