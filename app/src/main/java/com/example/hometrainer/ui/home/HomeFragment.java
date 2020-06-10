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

public class HomeFragment extends Fragment implements SensorEventListener {

    private HomeViewModel homeViewModel;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    TextView walk;
    private int mSteps = 0;
    private int mCounterSteps = 0;

    private SensorManager sensorManager;
    private Sensor stepCountSensor;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        Button challenge_more = (Button) root.findViewById(R.id.challenge_more);

        sensorManager = (SensorManager)getActivity().getSystemService(Context.SENSOR_SERVICE);
        stepCountSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        EditText walk = (EditText)root.findViewById(R.id.manbo_result);

        challenge_more.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity)getActivity();
                activity.replaceFragment(ChallengeFragment.newInstance());

            }
        });

        return root;
    }

    public void onStart() {
        super.onStart();
        if(stepCountSensor != null) {
            sensorManager.registerListener(this, stepCountSensor, SensorManager.SENSOR_DELAY_GAME);
        }
    }

    public void onStop() {
        super.onStop();
        if(sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_STEP_COUNTER){

            //stepcountsenersor는 앱이 꺼지더라도 초기화 되지않는다. 그러므로 우리는 초기값을 가지고 있어야한다.
            if (mCounterSteps < 1) {
                // initial value
                mCounterSteps = (int) event.values[0];
            }
            //리셋 안된 값 + 현재값 - 리셋 안된 값
            mSteps = (int) event.values[0] - mCounterSteps;
            walk.setText(Integer.toString(mSteps));
            Log.i("log: ", "New step detected by STEP_COUNTER sensor. Total step count: " + mSteps );
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
