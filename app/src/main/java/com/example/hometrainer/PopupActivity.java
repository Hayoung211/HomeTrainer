package com.example.hometrainer;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.impl.io.DefaultHttpClientConnectionOperator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class PopupActivity extends Activity {

    TextView txtText;
    EditText get_weight;
    ImageView body;

    byte[] byteArray;

    String data;

    int weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_popup);

        //UI 객체생성
        txtText = (TextView)findViewById(R.id.date);

        //데이터 가져오기
        Intent intent = getIntent();
        data = intent.getStringExtra("data");
        txtText.setText(data);

        get_weight = (EditText)findViewById(R.id.weight_result);

        body = (ImageView)findViewById(R.id.body_pic);

        body.setOnClickListener(new MyListener());

    }

    class MyListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(intent, 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == 1) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                try {
                    // 선택한 이미지에서 비트맵 생성
                    InputStream in = getContentResolver().openInputStream(data.getData());
                    Bitmap img = BitmapFactory.decodeStream(in);
                    in.close();
                    // 이미지 표시
                    body.setImageBitmap(img);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    img.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    byteArray = byteArrayOutputStream.toByteArray();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void mOnCancel(View v) {
        finish();
    }

    //확인 버튼 클릭
    @SuppressLint("WrongConstant")
    public void mOnClose(View v){
        String encoded = Base64.encodeToString(byteArray, Base64.DEFAULT);
        weight = Integer.parseInt(get_weight.getText().toString());

        String test = "http://172.30.1.60/setdatabase.php";
        URLConnector task = new URLConnector(test);
//
//        task.start();
//
//        try{
//            task.join();
//            System.out.println("waiting... for result");
//        }
//        catch(InterruptedException e){
//
//        }

//        String result = task.getResult();
//
//        String id;
//        try {
//            JSONObject root = new JSONObject(result);
//            JSONArray ja = root.getJSONArray("result");
//
//            for(int i = 0; i < ja.length();i++)
//            {
//                JSONObject jo = ja.getJSONObject(i);
//                id = jo.getString("seq");
//                System.out.println(id);
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
        //액티비티(팝업) 닫기
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //바깥레이어 클릭시 안닫히게
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        //안드로이드 백버튼 막기
        return;
    }
}
