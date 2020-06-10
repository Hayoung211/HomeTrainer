package com.example.hometrainer.ui.home;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
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
import com.example.hometrainer.ui.challenge.ChallengeFragment;
import com.example.hometrainer.ui.challenge_one_day.OnedayFragment;

import static android.content.Context.SENSOR_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    private TextView walk;
    private int mSteps = 0;
    private int mCounterSteps = 0;

    private SensorManager sensorManager;
    private float acceleration;

    private float previousY, currentY;
    private int steps;

    int threshold;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        Button challenge_more = (Button) root.findViewById(R.id.challenge_more);

        walk = (TextView) root.findViewById(R.id.manbo_result);

        threshold = 7;

        previousY = currentY = steps = 0;

        acceleration = 0.0f;

        sensorManager = (SensorManager)getActivity().getSystemService(Context.SENSOR_SERVICE);
        sensorManager.registerListener(stepDetector, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);

        challenge_more.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity)getActivity();
                activity.replaceFragment(ChallengeFragment.newInstance());

            }
        });

        return root;
    }

    private SensorEventListener stepDetector = new SensorEventListener() {

        @Override
        public void onSensorChanged(SensorEvent event) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            currentY = y;

            if (Math.abs(currentY - previousY) > threshold) {
                walk.setText(String.valueOf(steps));
                steps++;
            }

            previousY = y;


        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };
}
