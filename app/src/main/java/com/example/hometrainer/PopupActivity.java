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

import org.apache.hc.client5.http.ClientProtocolException;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.DefaultHttpClientConnectionOperator;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

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
    public void mOnClose(View v) throws IOException {
        String encoded = Base64.encodeToString(byteArray, Base64.DEFAULT);
        String weight = get_weight.getText().toString();

        String url = "http://172.30.1.60/setdatabase.php";
        HttpClient httpClient = new HttpClient() {
            @Override
            public HttpResponse execute(ClassicHttpRequest classicHttpRequest) throws IOException {
                return null;
            }

            @Override
            public HttpResponse execute(ClassicHttpRequest classicHttpRequest, HttpContext httpContext) throws IOException {
                return null;
            }

            @Override
            public ClassicHttpResponse execute(HttpHost httpHost, ClassicHttpRequest classicHttpRequest) throws IOException {
                return null;
            }

            @Override
            public HttpResponse execute(HttpHost httpHost, ClassicHttpRequest classicHttpRequest, HttpContext httpContext) throws IOException {
                return null;
            }

            @Override
            public <T> T execute(ClassicHttpRequest classicHttpRequest, HttpClientResponseHandler<? extends T> httpClientResponseHandler) throws IOException {
                return null;
            }

            @Override
            public <T> T execute(ClassicHttpRequest classicHttpRequest, HttpContext httpContext, HttpClientResponseHandler<? extends T> httpClientResponseHandler) throws IOException {
                return null;
            }

            @Override
            public <T> T execute(HttpHost httpHost, ClassicHttpRequest classicHttpRequest, HttpClientResponseHandler<? extends T> httpClientResponseHandler) throws IOException {
                return null;
            }

            @Override
            public <T> T execute(HttpHost httpHost, ClassicHttpRequest classicHttpRequest, HttpContext httpContext, HttpClientResponseHandler<? extends T> httpClientResponseHandler) throws IOException {
                return null;
            }
        };
        HttpPost httpPost = new HttpPost(url);

        List<NameValuePair> param = new ArrayList<NameValuePair>();
        param.add(new BasicNameValuePair("day", data));
        param.add(new BasicNameValuePair("weight", weight));
        param.add(new BasicNameValuePair("body", encoded));

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(param));
            HttpResponse response = httpClient.execute(httpPost);
            System.out.println("다 보내졌음");
        } catch (UnsupportedEncodingException e)    {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            // Log exception
            e.printStackTrace();
        } catch (IOException e) {
            // Log exception
            e.printStackTrace();
        }
//        String test = "http://172.30.1.60/setdatabase.php";
//        URLConnector task = new URLConnector(test);
//
//        task.start();
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
