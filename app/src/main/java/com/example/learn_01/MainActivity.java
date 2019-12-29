package com.example.learn_01;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learn_01.activity.loginactivity;
import com.example.learn_01.utils.ThreadUtils;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //停留三秒进入主界面
        ThreadUtils.runiNthread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(1000);
                //进入主界面
                Intent intent =new Intent(MainActivity.this, loginactivity.class);
                startActivity(intent);
                finish();
            }


    });
    }



}
