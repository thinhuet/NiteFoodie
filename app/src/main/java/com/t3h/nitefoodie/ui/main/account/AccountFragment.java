package com.t3h.nitefoodie.ui.main.account;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.t3h.nitefoodie.R;
import com.t3h.nitefoodie.ui.base.animation.ScreenAnimation;
import com.t3h.nitefoodie.ui.base.fragment.BaseFragment;
import com.t3h.nitefoodie.ui.base.fragment.BaseMVPFragment;
import com.t3h.nitefoodie.ui.main.MainActivity;

/**
 * Created by thinhquan on 6/25/17.
 */

public class AccountFragment extends BaseMVPFragment implements View.OnClickListener {
    private Toolbar toolbar;
    private Button btnRegister;

    @Override
    public int getLayoutMain() {
        return R.layout.account_fragment;
    }

    @Override
    public void findViewByIds() {
        toolbar = (Toolbar) getView().findViewById(R.id.toolbar);
        btnRegister = (Button) getView().findViewById(R.id.btn_register);
    }

    @Override
    public void initComponents() {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setTitle("Tài Khoản");
    }

    @Override
    public void setEvents() {
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        MainActivity activity = (MainActivity)getActivity();

        BaseFragment fragment = BaseFragment.getCurrentBaseFragment(activity.getSupportFragmentManager());
        FragmentManager manager = activity.getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        if (fragment != null) {
            BaseFragment.hideFragment(manager, transaction, fragment.getClass(),
                    ScreenAnimation.OPEN_FULL, false, false);
        }

        BaseFragment.openFragment(manager, transaction,
                RegisterFragment.class, ScreenAnimation.OPEN_FULL, null, false, true);

    }
}
