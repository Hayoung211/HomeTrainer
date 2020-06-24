package com.example.hometrainer;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;

import com.example.hometrainer.ui.home.HomeFragment;
import com.google.android.material.navigation.NavigationView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity<EndToast> extends AppCompatActivity {
    private static String IP_ADDRESS = "192.168.35.224";
    private static String TAG = "phptest";

    private AppBarConfiguration mAppBarConfiguration;

    private int mSteps = 0;
    private int mCounterSteps = 0;

    private SensorManager sensorManager;
    private float acceleration;

    private float previousY, currentY;
    private int steps;

    int threshold;

    int hold = 1;

    final FragmentTransaction transaction = this.getSupportFragmentManager().beginTransaction();
    HomeFragment home = new HomeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_challenge, R.id.nav_record, R.id.nav_bmi)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        String test = "http://172.30.1.60/test1.php";
        URLConnector task = new URLConnector(test);

        task.start();

        try{
            task.join();
            System.out.println("waiting... for result");
        }
        catch(InterruptedException e){

        }

        String result = task.getResult();

        String id;
        try {
            JSONObject root = new JSONObject(result);
            JSONArray ja = root.getJSONArray("result");

            for(int i = 0; i < ja.length();i++)
            {
                JSONObject jo = ja.getJSONObject(i);
                id = jo.getString("seq");
                System.out.println(id);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        threshold = 10;

        previousY = currentY = steps = 0;

        acceleration = 0.0f;

        sensorManager = (SensorManager)this.getSystemService(Context.SENSOR_SERVICE);
        sensorManager.registerListener(stepDetector, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);


    }

    private SensorEventListener stepDetector = new SensorEventListener() {

        @Override
        public void onSensorChanged(SensorEvent event) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            currentY = y;

            if (Math.abs(currentY - previousY) > threshold) {
                System.out.println(String.valueOf(steps));
                steps++;
            }

            previousY = y;

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    public int StepData() {
        return steps;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, fragment).commit();
    }

    public interface onKeyBackPressedListener {
        void onBackKey();
    }
    private onKeyBackPressedListener mOnKeyBackPressedListener;
    public void setOnKeyBackPressedListener(onKeyBackPressedListener listener) {
        mOnKeyBackPressedListener = listener;
    }

    @Override
    public void onBackPressed() {
        if (mOnKeyBackPressedListener != null) {
            mOnKeyBackPressedListener.onBackKey();
        } else {
            super.onBackPressed();
        }
    }



//    @Override
//    public void onBackPressed() {
//        // 인스턴스 초기화
//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//
//        // 백스택이 존재할 떄까지
//        if (fm.getBackStackEntryCount() > 0) {
//            fm.popBackStack();
//            ft.commit();
//        }
//        // 백스택이 없는 경우
//        else {
//            // 이미 한 번 선택된 경우
//            transaction.replace(R.id.nav_host_fragment, HomeFragment.newInstance());
//            transaction.addToBackStack(null);
//            transaction.commit();
//        }
//    }
}
