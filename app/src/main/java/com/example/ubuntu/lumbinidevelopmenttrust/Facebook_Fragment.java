package com.example.ubuntu.lumbinidevelopmenttrust;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import static com.facebook.FacebookSdk.getApplicationContext;

public class Facebook_Fragment extends AppCompatActivity {
    TextView textView;
    Button button;
    CallbackManager callbackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_facebook__fragment);

        initialization();
        loginWithFacebook();

    }

    private void initialization(){
        textView = findViewById(R.id.tv);
        button = findViewById(R.id.login_button);

        callbackManager = CallbackManager.Factory.create();
    }

    private void loginWithFacebook(){
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
            textView.setText("Login Success\n" + loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
            textView.setText("Login cancel");
            }

            @Override
            public void onError(FacebookException error) {
            textView.setText("Login Error:" + error.getMessage());
            }
        });


    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
