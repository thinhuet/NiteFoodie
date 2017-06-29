package com.t3h.nitefoodie.ui.main.home.listshop;


import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.t3h.nitefoodie.R;
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

    @Override
    public void onClick(int position) {
        Toast.makeText(getContext(), "" + position, Toast.LENGTH_SHORT).show();
    }
}
