package com.example.learn_01.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learn_01.R;
import com.example.learn_01.utils.ThreadUtils;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jxmpp.jid.impl.JidCreate;

import java.io.IOException;

public class loginactivity extends AppCompatActivity {

    private  static final String TGA = "loginactivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initListener();
    }
    private static final String DOMAIN = "tx-180029.tx.com";
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
                final String username=mEtuserName.getText().toString();

                //判断密码
                final String password=mEtPassword.getText().toString();
                if (TextUtils.isEmpty(username)){
                    mEtuserName.setError("用户名不能为空");

                    return;
                }
                if (TextUtils.isEmpty(password)){
                    mEtPassword.setError("密码不能为空");
                    return;
                }
                ThreadUtils.runiNthread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //  连接
                            Log.d(TGA,"连接1");
                            XMPPTCPConnectionConfiguration config =XMPPTCPConnectionConfiguration.builder()
                                    .setServiceName(JidCreate.domainBareFrom(DOMAIN))


                                    .setHost("172.24.101.26")
                                    .setPort(5222)
                                    //下面两条是额外的配置
                                    .setSecurityMode(ConnectionConfiguration.SecurityMode.disabled)//明文传输，调试状态下可用
                                    .setDebuggerEnabled(true)//开启调试模式，方便查看具体发送的内容
                                    .build();
                            Log.d(TGA,"连接1.4");
                            XMPPTCPConnection conn = new XMPPTCPConnection(config);
                            conn.connect();
                            //登录 传入用户账号信息
                            conn.login(username,password);

                            //登录成功
                            ThreadUtils.runinUIthread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(),"登录成功",Toast.LENGTH_SHORT).show();
                                }
                            });


                        } catch (IOException e) {

                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (XMPPException e) {
//                            ThreadUtils.runiNthread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    Toast.makeText(getApplicationContext(),"登录失败",Toast.LENGTH_SHORT).show();
//                                }
//                            });
                            e.printStackTrace();
                        } catch (SmackException e) {
                            e.printStackTrace();
                        }
                    }


                });


            };

        });
    }

    private void initView() {
        mEtuserName = findViewById(R.id.username);
        mEtPassword = findViewById(R.id.password);
        mBtnLogin =  findViewById(R.id.login);
    }
}
