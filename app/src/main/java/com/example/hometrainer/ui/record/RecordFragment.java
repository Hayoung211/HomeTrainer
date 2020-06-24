package com.example.hometrainer.ui.record;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.hometrainer.MainActivity;
import com.example.hometrainer.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RecordFragment extends Fragment {

    private TextView walk;

    private SensorManager sensorManager;
    private float acceleration;

    private float previousY, currentY;
    private int steps;

    int threshold;

    TextView today;

    long now;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd");

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_record, container, false);

        MainActivity activity = (MainActivity)getActivity();
        steps = activity.StepData();
        System.out.println("받아온값이다 " + steps);

        walk = (TextView) root.findViewById(R.id.today_walk_result);
        walk.setText(String.valueOf(steps));

        final FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

        threshold = 10;

        previousY = currentY = 0;

        acceleration = 0.0f;

        sensorManager = (SensorManager)getActivity().getSystemService(Context.SENSOR_SERVICE);
        sensorManager.registerListener(stepDetector, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);

        now = System.currentTimeMillis();
        Date date = new Date(now);
        String time = mFormat.format(date);
        today = (TextView)root.findViewById(R.id.day_check);
        today.setText(time);

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