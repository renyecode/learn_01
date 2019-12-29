package com.example.learn_01.utils;


import android.os.Handler;

public class ThreadUtils {
    //子线程执行task
    public static void runiNthread(Runnable task){
        new Thread(task).start();

    }
    //主线程下的handler
    //Handler用来发送消息和处理消息通知 估计和python中的queen差不多
    public  static Handler mhandler = new Handler();


    //UI线程执行TASK
    public static void runinUIthread(Runnable task){
        mhandler.post(task) ;

    }
}
