package com.example.learn_01.activity;

import android.os.Build;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.learn_01.R;
import com.example.learn_01.fragment.ContactsFragment;
import com.example.learn_01.fragment.sessionFragment;
import com.example.learn_01.utils.ToolBarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class InmainActivity extends AppCompatActivity {

    @InjectView(R.id.main_tv_title)
    TextView mainTvTitle;
    @InjectView(R.id.main_viewpager)
    ViewPager mainViewpager;
    @InjectView(R.id.main_bottom)
    LinearLayout mainBottom;
    private List<Fragment> mFragments = new ArrayList<Fragment>();//将 sessionfragment  contacts fragment 联系人 放入列表里面
    private ToolBarUtil toolBarUtil;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inmain);
        ButterKnife.inject(this);//绑定控件  butterknife:6.0.0
        initData();
        initListener();

    }

    private void initListener() {
//        mainViewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
        toolBarUtil.setmOnToolBarClickListener(new ToolBarUtil.OnToolBarClickListener() {//监听按钮点击
            @Override
            public void ontoolbarclick(int position) {
                mainViewpager.setCurrentItem(position);
            }
        });



    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void initData() {
        //添加fragment 到集合中
        mFragments.add(new sessionFragment());
        mFragments.add(new ContactsFragment());
        mainViewpager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));// 设置适配器
        // 创建底部按钮
        toolBarUtil = new ToolBarUtil();
        // 图片名字
        String[] toolBarTitleArr={"会话","联系人"};
        //图标图片
        int[] iconArr={R.mipmap.ic_launcher,R.mipmap.ic_launcher};
        toolBarUtil.createToolBar(mainBottom,toolBarTitleArr,iconArr);
        


    }

    //Fragment https://blog.csdn.net/qq_34927117/article/details/68067040
    class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);//返回控件2个
        }

        @Override
        public int getCount() {
            // return 2  是主界面 有两个按钮点击切换  两个 fragment
            //sessionfragment  会话
            //contacts fragment 联系人

            return 2;
        }
    }


}
