package com.t3h.nitefoodie.ui.main.account;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.t3h.nitefoodie.R;
import com.t3h.nitefoodie.ui.base.fragment.BaseMVPFragment;

/**
 * Created by thinhquan on 6/25/17.
 */

public class AccountFragment extends BaseMVPFragment {
    private Toolbar toolbar;
    @Override
    public int getLayoutMain() {
        return R.layout.account_fragment;
    }

    @Override
    public void findViewByIds() {
        toolbar = (Toolbar) getView().findViewById(R.id.toolbar);
    }

    @Override
    public void initComponents() {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setTitle("Tài Khoản");
    }

    @Override
    public void setEvents() {

    }
}
