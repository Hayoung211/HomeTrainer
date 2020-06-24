package com.example.hometrainer.ui.checkbody;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.provider.MediaStore;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.hometrainer.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BodyCheckFragment extends Fragment implements SurfaceHolder.Callback {


    private SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;
    private Camera camera;
    Button button, button2;
    String str;
    Camera.PictureCallback jpegCallback;
    Camera.AutoFocusCallback AutoFocus;

    public static BodyCheckFragment newInstance() {

        return new BodyCheckFragment();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_body_check, container, false);

        byte[][] mImageData = new byte[6][];
        surfaceView = (SurfaceView) root.findViewById(R.id.check_body_surfaceView);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        
        button = (Button) root.findViewById(R.id.check_body_take_photo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                camera.takePicture(null, null, jpegCallback);

            }
        });


        button2 = (Button) root.findViewById(R.id.body_check_focus);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                camera.autoFocus(AutoFocus);
            }
        });

        AutoFocus = new Camera.AutoFocusCallback() {
            @Override
            public void onAutoFocus(boolean success, Camera camera) {
                button2.setEnabled(true);
            }
        };

        jpegCallback = new Camera.PictureCallback() {
            @Override
            public void onPictureTaken(byte[] data, Camera camera) {
                String sd = Environment.getExternalStorageDirectory().getAbsolutePath();
                String path = sd+ "/DCIM" + System.currentTimeMillis()+".jpg";
                File file = new File(path);

                try {
                  FileOutputStream fos = new FileOutputStream(file);
                  fos.write(data);
                  fos.flush();
                  fos.close();
                }

                catch (Exception e) {
                   Toast.makeText(getActivity().getApplicationContext(),"파일 저장 중 에러 발생",Toast.LENGTH_LONG).show();
                   return;
                }

                Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                Uri uri = Uri.parse("file://"+path);
                intent.setData(uri);
                getActivity().sendBroadcast(intent);


                Toast.makeText(getActivity().getApplicationContext(),
                        "사진이 갤러리에 저장되었습니다.", Toast.LENGTH_LONG).show();
                refreshCamera();
            }

        };

        return root;
    }

    public void refreshCamera() {
        if (surfaceHolder.getSurface() == null) {
            return;
        }

        try {
            camera.stopPreview();
        }

        catch (Exception e) {
        }

        try {
            camera.setPreviewDisplay(surfaceHolder);
            camera.startPreview();
        }
        catch (Exception e) {
        }
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        camera = Camera.open(Camera.CameraInfo.CAMERA_FACING_BACK);
        Camera.Parameters parameters = camera.getParameters();
        if(getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE){
            parameters.set("orientation", "portrait");
            camera.setDisplayOrientation(90);
            parameters.setRotation(90);
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
