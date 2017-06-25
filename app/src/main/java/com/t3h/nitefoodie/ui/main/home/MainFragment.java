package com.t3h.nitefoodie.ui.main.home;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.t3h.nitefoodie.R;
import com.t3h.nitefoodie.ui.base.fragment.BaseFragment;
import com.t3h.nitefoodie.ui.base.fragment.BaseMVPFragment;
import com.t3h.nitefoodie.ui.main.account.AccountFragment;
import com.t3h.nitefoodie.ui.main.home.listshop.ListShopFragment;

/**
 * Created by thinhquan on 6/24/17.
 */

public class MainFragment extends BaseMVPFragment implements ViewPager.OnPageChangeListener {
    private ViewPager vpMain;
    private TabLayout tabLayout;

    @Override
    public int getLayoutMain() {
        return R.layout.main_fragment;
    }

    @Override
    public void findViewByIds() {
        vpMain = (ViewPager) getView().findViewById(R.id.vp_main);
        tabLayout = (TabLayout) getView().findViewById(R.id.tablayout);
    }

    @Override
    public void initComponents() {
        tabLayout.setupWithViewPager(vpMain);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        vpMain.setAdapter(adapter);
    }

    @Override
    public void setEvents() {
        vpMain.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public class ViewPagerAdapter extends FragmentStatePagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new ListShopFragment();
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getContext().getString(R.string.hot_sale);

                case 1:
                    return getContext().getString(R.string.popular);

                default:
                    return getContext().getString(R.string.all);

            }
        }
    }
}
