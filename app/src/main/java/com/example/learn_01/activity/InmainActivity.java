package com.example.learn_01.activity;

import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learn_01.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class InmainActivity extends AppCompatActivity {

    @InjectView(R.id.main_tv_title)
    TextView mainTvTitle;
    @InjectView(R.id.main_viewpager)
    SurfaceView mainViewpager;
    @InjectView(R.id.main_bottom)
    LinearLayout mainBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inmain);
        ButterKnife.inject(this);//绑定控件  butterknife:6.0.0

    }

    private void initView() {
    }
}
