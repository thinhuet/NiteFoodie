package com.t3h.nitefoodie.ui.main.home.store;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.t3h.nitefoodie.R;
import com.t3h.nitefoodie.ui.base.fragment.BaseMVPFragment;
import com.t3h.nitefoodie.ui.model.StoreInstance;

import java.util.List;

/**
 * Created by thinhquan on 6/25/17.
 */

public class ListStoreFragment extends BaseMVPFragment implements StoreAdapter.IStoreAdapter {
    private RecyclerView rcStore;
    private StoreAdapter mStoreAdapter;
    private DatabaseReference mData;
    private List<StoreInstance> storeInstances;

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
        mData = FirebaseDatabase.getInstance().getReference().child("Store");
        mStoreAdapter = new StoreAdapter(this);

//        mData.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                Store store = dataSnapshot.getValue(Store.class);
//
//                StoreInstance.getInstance().setName(store.getName());
//                StoreInstance.getInstance().setAddress(store.getAddress());
//                StoreInstance.getInstance().setPhone(store.getPhone());
//
//
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rcStore.setLayoutManager(linearLayoutManager);
        rcStore.setAdapter(mStoreAdapter);
    }

    @Override
    public void setEvents() {

    }

    @Override
    public int getCount() {
        return 10;
    }
}
