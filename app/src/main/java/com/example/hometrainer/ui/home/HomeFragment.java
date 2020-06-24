package com.example.hometrainer.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.hometrainer.MainActivity;
import com.example.hometrainer.PopupActivity;
import com.example.hometrainer.R;
import com.example.hometrainer.ui.challenge.ChallengeFragment;
import com.example.hometrainer.ui.challenge_one_day.OnedayFragment;
import com.example.hometrainer.ui.checkbody.BodyCheckFragment;

import java.util.Timer;
import java.util.TimerTask;

import static android.content.Context.SENSOR_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

public class HomeFragment extends Fragment {
    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    private TextView walk;

    private SensorManager sensorManager;
    private float acceleration;

    private float previousY, currentY;
    private int steps;

    int threshold;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        MainActivity activity = (MainActivity)getActivity();
        steps = activity.StepData();
        System.out.println("받아온값이다 " + steps);

        Button body_check = (Button) root.findViewById(R.id.body_check);
            body_check.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity activity = (MainActivity) getActivity();
                    activity.replaceFragment(BodyCheckFragment.newInstance());
                }
            });

        walk = (TextView) root.findViewById(R.id.manbo_result);
        walk.setText(String.valueOf(steps));

        final FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

        threshold = 10;

        previousY = currentY = 0;

        acceleration = 0.0f;

        sensorManager = (SensorManager)getActivity().getSystemService(Context.SENSOR_SERVICE);
        sensorManager.registerListener(stepDetector, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);

//        TimerTask tt = new TimerTask() {
//            @Override
//            public void run() {
//                start();
//            }
//        };
//
//        Timer timer = new Timer();
//        timer.schedule(tt, 1000, 2000);

        CalendarView calendar = (CalendarView)root.findViewById(R.id.calendarview);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                String rmonth = null;
                String day = null;
                if(month < 10) {
                    rmonth = "0"+Integer.toString(month+1);
                    if(dayOfMonth < 10) {
                        day = "0"+ Integer.toString(dayOfMonth);
                    } else {
                        day = Integer.toString(dayOfMonth);
                    }
                } else {
                    rmonth = Integer.toString(month+1);
                    if(dayOfMonth < 10) {
                        day = "0"+ Integer.toString(dayOfMonth);
                    } else {
                        day = Integer.toString(dayOfMonth);
                    }
                }
                String date = ""+year+"-"+rmonth+"-" +day;
                Intent intent = new Intent(getActivity(), PopupActivity.class);
                intent.putExtra("data", date);
                startActivityForResult(intent, 1);

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
