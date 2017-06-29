package com.t3h.nitefoodie.ui.main;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.t3h.nitefoodie.R;
import com.t3h.nitefoodie.ui.base.activity.BaseActivity;

public class LoginActivity extends BaseActivity implements View.OnClickListener {


    private TextView tvTitle;

    @Override
    public int getLayoutMain() {
        return R.layout.activity_login;
    }

    @Override
    public void findViewByIds() {
        tvTitle = (TextView) findViewById(R.id.tv_title);
    }

    @Override
    public void initComponents() {
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Pacifico.ttf");
        tvTitle.setTypeface(typeface);
    }

    @Override
    public void setEvents() {
        findViewById(R.id.btn_fb_login).setOnClickListener(this);
        findViewById(R.id.btn_gg_login).setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        onBackMain();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
    }
}
