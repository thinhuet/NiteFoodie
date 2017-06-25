package com.t3h.nitefoodie.ui.main.cart;

import android.app.Application;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;

import com.t3h.nitefoodie.R;
import com.t3h.nitefoodie.ui.base.fragment.BaseMVPFragment;

/**
 * Created by thinhquan on 6/25/17.
 */

public class CartFragment extends BaseMVPFragment {

    private android.support.v7.widget.Toolbar toolbar;
    @Override
    public int getLayoutMain() {
        return R.layout.cart_fragment;
    }

    @Override
    public void findViewByIds() {
        toolbar = (android.support.v7.widget.Toolbar) getView().findViewById(R.id.toolbar);
    }

    @Override
    public void initComponents() {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setTitle("Giỏ Hàng");
        activity.getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public void setEvents() {

    }
}
