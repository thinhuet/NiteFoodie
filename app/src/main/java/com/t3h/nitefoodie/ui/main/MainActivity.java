package com.t3h.nitefoodie.ui.main;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.t3h.nitefoodie.R;
import com.t3h.nitefoodie.ui.base.activity.BaseActivity;
import com.t3h.nitefoodie.ui.base.animation.ScreenAnimation;
import com.t3h.nitefoodie.ui.base.fragment.BaseFragment;
import com.t3h.nitefoodie.ui.main.account.AccountFragment;
import com.t3h.nitefoodie.ui.main.cart.CartFragment;
import com.t3h.nitefoodie.ui.main.favourite.FavoriteFragment;
import com.t3h.nitefoodie.ui.main.home.MainFragment;
import com.t3h.nitefoodie.ui.main.notification.NotificationFragment;

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private BottomNavigationView mBottomNav;

    @Override
    public int getLayoutMain() {
        return R.layout.activity_main;
    }

    @Override
    public void findViewByIds() {
        mBottomNav = (BottomNavigationView) findViewById(R.id.bottom_navigation);
    }

    @Override
    public void initComponents() {
        mBottomNav.getMenu().getItem(2).setChecked(true);
        FragmentManager manager = getSupportFragmentManager();
        BaseFragment.openFragment(manager, manager.beginTransaction(),
                MainFragment.class, ScreenAnimation.OPEN_FULL, null, false, true);
    }

    @Override
    public void setEvents() {
        if (mBottomNav != null) {
            mBottomNav.setOnNavigationItemSelectedListener(this);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        //item.setChecked(true);
        BaseFragment fragment = BaseFragment.getCurrentBaseFragment(getSupportFragmentManager());
        //Log.d(TAG, fragment.getClass().getName() + "");
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        BaseFragment.hideFragment(manager, transaction, fragment.getClass(),
                ScreenAnimation.OPEN_FULL, false, false);
        switch (item.getItemId()) {
            case R.id.action_store:
                BaseFragment.openFragment(manager, transaction,
                        CartFragment.class, ScreenAnimation.OPEN_FULL, null, false, true);
                break;
            case R.id.action_favorite:
                BaseFragment.openFragment(manager, transaction,
                        FavoriteFragment.class, ScreenAnimation.OPEN_FULL, null, false, true);
                break;
            case R.id.action_notification:
                BaseFragment.openFragment(manager, transaction,
                        NotificationFragment.class, ScreenAnimation.OPEN_FULL, null, false, true);
                break;
            case R.id.action_home:
                BaseFragment.openFragment(manager, transaction,
                        MainFragment.class, ScreenAnimation.OPEN_FULL, null, false, true);
                break;
            case R.id.action_account:
                BaseFragment.openFragment(manager, transaction, AccountFragment.class,
                        ScreenAnimation.OPEN_FULL, null, false, true);
                break;
        }
        return true;
    }
}
