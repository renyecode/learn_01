package com.example.learn_01.utils;

import android.os.Build;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.example.learn_01.R;

// 创建按钮
public class ToolBarUtil {
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public void createToolBar(LinearLayout container, String[] toolBarTitleArr, int[] iconArr){//往LinearLayout容器里面传东西
        // 将按钮生成
        for (int i = 0;i<toolBarTitleArr.length;i++)
        {
            TextView tv = (TextView) View.inflate(container.getContext(), R.layout.inflate_toolbar_btn,null);
            // 动态的修改文字和图标
            tv.setText(toolBarTitleArr[i]);
            tv.setCompoundDrawablesRelativeWithIntrinsicBounds(0,iconArr[i],0,0);
            //添加按钮
            int width=0;
            int height=LinearLayout.LayoutParams.MATCH_PARENT;
            LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(width,height);
            params.weight=1;
            container.addView(tv,params);
            final int finalI = i;
            tv.setOnClickListener(new View.OnClickListener() {//点击事件
                @Override
                public void onClick(View view) {
                    //不同模块之间传值需要用接口回调
                    //3需要传值的地方，用接口对象调用接口方法
                    mOnToolBarClickListener.ontoolbarclick(finalI);

                }
            });
        }

    }
    //1创建接口和接口方法
    public interface  OnToolBarClickListener{
        void ontoolbarclick(int position);
    }
    //2定义接口变量
   OnToolBarClickListener mOnToolBarClickListener;
    //4暴露一个公共方法
    public void setmOnToolBarClickListener(OnToolBarClickListener onToolBarClickListener){
        mOnToolBarClickListener = onToolBarClickListener;
    }
}
