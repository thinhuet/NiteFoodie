package com.t3h.nitefoodie.ui.main.home.store;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.t3h.nitefoodie.R;
import com.t3h.nitefoodie.ui.base.fragment.BaseMVPFragment;
import com.t3h.nitefoodie.ui.model.Store;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thinhquan on 6/25/17.
 */

public class ListStoreFragment extends BaseMVPFragment {
    private RecyclerView rcStore;
    private StoreAdapter mStoreAdapter;
    private DatabaseReference mData;
    private List<Store> stores;

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
        stores = new ArrayList<>();
        mData = FirebaseDatabase.getInstance().getReference().child("Store");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

        rcStore.setLayoutManager(linearLayoutManager);
        mStoreAdapter = new StoreAdapter(stores);
        rcStore.setAdapter(mStoreAdapter);

        updateList();
    }

    @Override
    public void setEvents() {

    }


    private void updateList(){
        mData.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                stores.add(dataSnapshot.getValue(Store.class));
                mStoreAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Store store = dataSnapshot.getValue(Store.class);

                int index = getItemIndex(store);
                stores.set(index, store);
                mStoreAdapter.notifyItemChanged(index);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Store store = dataSnapshot.getValue(Store.class);

                int index = getItemIndex(store);
                stores.remove(index);
                mStoreAdapter.notifyItemRemoved(index);
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private int getItemIndex(Store store){
        int index = -1;

        for (int i = 0; i < stores.size(); i++){
            if (stores.get(i).getsId().equals(store.getsId())){
                index = i;
                break;
            }
        }

        return index;
    }

//    @Override
//    public int getCount() {
//        return 10;
//    }
//
//    @Override
//    public Store getData(int poisition) {
//        return null;
//    }
}
