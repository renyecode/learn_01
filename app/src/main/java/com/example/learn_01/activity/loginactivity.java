package com.example.learn_01.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learn_01.R;

public class loginactivity extends AppCompatActivity {

    private  static final String TGA = "loginactivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login3);
        initView();
        initListener();
    }
    private TextView mEtuserName ;
    private  TextView mEtPassword;
    private Button  mBtnLogin;
    private void initListener() {
        mBtnLogin.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                Log.d(TGA,"测试了");
                //判断账号
                String username=mEtuserName.getText().toString();
                Log.d(TGA,"测试了2");
                //判断密码
                String password=mEtPassword.getText().toString();
                if (TextUtils.isEmpty(username)){
                    mEtuserName.setError("用户名不能为空");
                    Log.d(TGA,"测试了3");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    mEtPassword.setError("密码不能为空");
                    return;
                }

            }

        });
    }

    private void initView() {
        mEtuserName=(TextView)findViewById(R.id.username);
        mEtPassword=(TextView)findViewById(R.id.password);
        mBtnLogin = (Button)findViewById(R.id.button);
    }
}
