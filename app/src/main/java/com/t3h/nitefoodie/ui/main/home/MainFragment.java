package com.t3h.nitefoodie.ui.main.home;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.transition.Explode;

import com.t3h.nitefoodie.R;
import com.t3h.nitefoodie.ui.base.fragment.BaseMVPFragment;
import com.t3h.nitefoodie.ui.main.home.store.list_store.ListHotSaleFragment;
import com.t3h.nitefoodie.ui.main.home.store.list_store.ListStoreFragment;

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
        Explode explode = new Explode();
        getBaseActivity().getWindow().setExitTransition(explode);
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

    public class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new ListHotSaleFragment();
            }
            return new ListStoreFragment();
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
                    return getContext().getString(R.string.all);

                default:
                    return getContext().getString(R.string.favourite);

            }
        }
    }
}
