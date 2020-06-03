package com.example.hometrainer.ui.bmi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.hometrainer.MainActivity;
import com.example.hometrainer.R;
import com.example.hometrainer.ui.bmi_result.BMIResutFragment;

public class BMIFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_bmi, container, false);

        Button show_result = (Button) root.findViewById(R.id.bmi_result_button);
        show_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText get_height = (EditText) root.findViewById(R.id.bmi_height_input);
                EditText get_weight = (EditText) root.findViewById(R.id.bmi_weight_input);

                Integer height = Integer.parseInt(get_height.getText().toString());
                Integer weight = Integer.parseInt(get_weight.getText().toString());
//
                float BMI = (float)weight/((float)(height*height)/10000);
//
                System.out.println("키는 " + height);
                System.out.println("몸무게는 " + weight);
                System.out.println("BMI는 " + BMI);

                if(BMI <= 18.5) {
                    System.out.println("저체중 입니다.");
                }
                else if(BMI > 18.5 && BMI <= 23) {
                    System.out.println("정상 입니다.");
                }
                else if(BMI > 23 && BMI <= 25) {
                    System.out.println("과체중 입니다.");
                }
                else if(BMI > 25 && BMI <= 30) {
                    System.out.println("비만 입니다.");
                }
                else {
                    System.out.println("고도비만 입니다.");
                }

                Fragment fragment = new BMIResutFragment();
                Bundle bundle = new Bundle();
                bundle.putString("bmi", String.valueOf(BMI));
                fragment.setArguments(bundle);

                MainActivity activity = (MainActivity)getActivity();
                activity.replaceFragment(BMIResutFragment.newInstance());
            }
        });
        return root;

    }
}
