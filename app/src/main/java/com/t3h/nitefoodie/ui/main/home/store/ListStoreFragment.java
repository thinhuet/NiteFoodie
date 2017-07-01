package com.t3h.nitefoodie.ui.main.home.store;


import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.view.Gravity;
import android.widget.Toast;

import com.t3h.nitefoodie.R;
import com.t3h.nitefoodie.ui.base.animation.ScreenAnimation;
import com.t3h.nitefoodie.ui.base.fragment.BaseFragment;
import com.t3h.nitefoodie.ui.base.fragment.BaseMVPFragment;

/**
 * Created by thinhquan on 6/25/17.
 */

public class ListStoreFragment extends BaseMVPFragment implements StoreAdapter.IStoreAdapter {
    private RecyclerView rcStore;
    private StoreAdapter mStoreAdapter;

    @Override
    public int getLayoutMain() {
        return R.layout.list_shop_fragment;
    }

    @Override
    public void findViewByIds() {
        rcStore = (RecyclerView) getView().findViewById(R.id.rc_store_all);
    }

    @Override
    public void initComponents() {
        mStoreAdapter = new StoreAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rcStore.setLayoutManager(linearLayoutManager);
        rcStore.setAdapter(mStoreAdapter);
    }

    @Override
    public void setEvents() {

    }

    @Override
    public int getCount() {
        return 20;
    }
}
