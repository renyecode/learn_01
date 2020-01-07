package com.example.learn_01.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {

    public static void showToastSafe(final Context context,final String text){
        //在子线程弹出Toast
        ThreadUtils.runinUIthread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context,text,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
