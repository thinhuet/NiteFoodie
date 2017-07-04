package com.t3h.nitefoodie.ui.main;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.t3h.nitefoodie.R;
import com.t3h.nitefoodie.ui.base.activity.BaseActivity;


public class LoginActivity extends BaseActivity implements View.OnClickListener {


    private static final String TAG = LoginActivity.class.getSimpleName();
    private TextView tvTitle;
    private LoginButton btnFbLogin;
    private CallbackManager mCallBackManager;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private boolean mIsSucces;

    @Override
    public int getLayoutMain() {
        return R.layout.activity_login;
    }

    @Override
    public void findViewByIds() {
        tvTitle = (TextView) findViewById(R.id.tv_title);
        btnFbLogin = (LoginButton) findViewById(R.id.btn_fb_login);
    }

    @Override
    public void initComponents() {
        mIsSucces = false;
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Pacifico.ttf");
        tvTitle.setTypeface(typeface);
        mCallBackManager = CallbackManager.Factory.create();
        btnFbLogin.setReadPermissions("email", "public_profile");
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

    }

    @Override
    public void setEvents() {
        findViewById(R.id.btn_gg_login).setOnClickListener(this);
        findViewById(R.id.btn_fb_login).setOnClickListener(this);

    }

    private void fbLogin(){
        btnFbLogin.registerCallback(mCallBackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d(TAG, "facebook:onSuccess:" + loginResult);
                handleFacebookAccessTokken(loginResult.getAccessToken());
                Toast.makeText(LoginActivity.this, "onSuccess", Toast.LENGTH_SHORT).show();
                mIsSucces = true;
            }

            @Override
            public void onCancel() {
                Log.d(TAG, "facebook:onCancel");

            }

            @Override
            public void onError(FacebookException error) {
                Log.d(TAG, "facebook:onError", error);

            }
        });

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Log.d(TAG, "onAuthStateChanged"+user.getUid());
                }else {
                    Log.d(TAG, "onAuthStateChanged:signed_out");

                }
            }
        };
    }

    private void handleFacebookAccessTokken(AccessToken accessToken) {
        Log.d(TAG, "handleFacebookAccessToken:" + accessToken);
        AuthCredential authCredential = FacebookAuthProvider.getCredential(accessToken.getToken());
        mAuth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.d(TAG, "signInWithCredential:success");

                } else {
                    Log.w(TAG, "signInWithCredential:failure", task.getException());
                    Toast.makeText(LoginActivity.this, "Authentication failed.",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallBackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onStart() {
        super.onStart();
//        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
//        if (mAuthListener != null){
//            mAuth.removeAuthStateListener(mAuthListener);
//        }
    }

    @Override
    public void onBackPressed() {
        onBackMain();
    }

    private void loginSucces(){
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_fb_login:
//                fbLogin();
//                if (mIsSucces == true){
//                    loginSucces();
//                }
                loginSucces();
                break;

            case R.id.btn_gg_login:

                break;
        }
    }
}
