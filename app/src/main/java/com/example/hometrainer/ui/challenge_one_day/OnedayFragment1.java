package com.example.hometrainer.ui.challenge_one_day;

import android.Manifest;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hometrainer.R;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragmentX;


public class OnedayFragment1 extends Fragment implements SurfaceHolder.Callback{

    private static final String API_KEY ="AIzaSyCWEKIZHSd0tKdOKb8ZIs1lwoNNx10dB4c";

    private static String VIDEO_ID = "swRNeYw1JkY";

    private SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;
    private Camera camera;


    public static OnedayFragment1 newInstance() {

        return new OnedayFragment1();

    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_challenge_oneday_1, container, false);
        surfaceView = (SurfaceView) rootview.findViewById(R.id.surfaceView);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);


        YouTubePlayerSupportFragmentX youTubePlayerFragment = YouTubePlayerSupportFragmentX.newInstance();

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.youtube_layout,youTubePlayerFragment).commit();

        youTubePlayerFragment.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
                if (!wasRestored) {
                    player.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                    player.loadVideo(VIDEO_ID);
                    player.play();

                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult error) {
                String errorMessage = error.toString();
                Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();

            }


        });



        return rootview;
    }

        @Override
        public void surfaceCreated(SurfaceHolder holder) {

                camera = Camera.open(Camera.CameraInfo.CAMERA_FACING_FRONT);
                Camera.Parameters parameters = camera.getParameters();
                if(getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE){
                    parameters.set("orientation", "portrait");
                    camera.setDisplayOrientation(90);
                    parameters.setRotation(270);
                }else {
                    parameters.set("orientation","landscape");
                    camera.setDisplayOrientation(0);
                    parameters.setRotation(0);
                }
                camera.setParameters(parameters);
                try {
                    camera.setPreviewDisplay(holder);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setPreviewSize(width, height);
            camera.startPreview();
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            camera.release();
            camera = null;
        }

}
