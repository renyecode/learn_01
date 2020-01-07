package com.example.learn_01.activity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.learn_01.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class InmainActivity extends AppCompatActivity {
    @InjectView(R.id.main_bottom)//控件绑定
    LinearLayout m_bottom;

    @InjectView(R.id.main_tv_title)//控件绑定
    TextView mTvTitle;
    
    @InjectView(R.id.main_viewpager)//控件绑定
    ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inmain);
        ButterKnife.inject(this);//绑定控件  butterknife:6.0.0

    }

    private void initView() {
    }
}
