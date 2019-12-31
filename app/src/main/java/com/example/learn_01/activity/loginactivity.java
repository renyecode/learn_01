package com.example.learn_01.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learn_01.R;

public class loginactivity extends AppCompatActivity {

    private  static final String TGA = "loginactivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initListener();
    }
    private EditText mEtuserName ;
    private  EditText mEtPassword;
    private Button  mBtnLogin;
    private void initListener() {
        mBtnLogin.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                //id 填写错误
                //不用TEXTVIEW  用EditText
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
        mEtuserName = findViewById(R.id.username);
        mEtPassword = findViewById(R.id.password);
        mBtnLogin =  findViewById(R.id.login);
    }
}
