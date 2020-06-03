package com.example.hometrainer.ui.bmi_result;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.hometrainer.R;

public class BMIResutFragment extends Fragment {
    public static Fragment newInstance() { return new BMIResutFragment(); }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        try {
            assert getArguments() != null;
            String BMI = getArguments().getString("bmi");
            System.out.println("여기는 BMI Result " + BMI);
        } catch (Exception e) {
            System.out.println("error " + e);
        }
        View root = inflater.inflate(R.layout.fragment_bmi_result, container, false);


        return root;
    }
}
