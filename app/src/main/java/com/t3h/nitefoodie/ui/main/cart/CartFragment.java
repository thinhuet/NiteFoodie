package com.t3h.nitefoodie.ui.main.cart;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.t3h.nitefoodie.R;
import com.t3h.nitefoodie.model.Order;
import com.t3h.nitefoodie.ui.base.fragment.BaseMVPFragment;
import com.t3h.nitefoodie.ui.main.cart.order_detail.OrderDetailDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thinhquan on 6/25/17.
 */

public class CartFragment extends BaseMVPFragment implements IOrder.View, OrderAdapter.IOrderAdapter {

    private RecyclerView rcOrder;
    private List<Order> mOrders;
    private OrderAdapter mAdapter;
    private Toolbar toolbar;
    private CartPresenter mPresenter;

    @Override
    public int getLayoutMain() {
        return R.layout.cart_fragment;
    }

    @Override
    public void findViewByIds() {
        toolbar = (Toolbar) getView().findViewById(R.id.toolbar);
        rcOrder = (RecyclerView) getView().findViewById(R.id.rc_order);
    }

    @Override
    public void initComponents() {
        mPresenter = new CartPresenter(this);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setTitle("Giỏ Hàng");
        activity.getSupportActionBar().setHomeButtonEnabled(true);

        mOrders = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rcOrder.setLayoutManager(linearLayoutManager);
        mAdapter = new OrderAdapter(this);
        rcOrder.setAdapter(mAdapter);

        mPresenter.getListOrder();
    }

    @Override
    public void setEvents() {

    }

    @Override
    public int getCount() {
        return mOrders.size();
    }

    @Override
    public Order getItem(int position) {
        return mOrders.get(position);
    }

    @Override
    public void onClick(int position) {
        Order order = mOrders.get(position);
        OrderDetailDialog dialog = new OrderDetailDialog(getContext(), order, new OrderDetailDialog.OnClickButton() {
            @Override
            public void onClick() {

            }
        });
        dialog.show();
    }

    @Override
    public void onGetOrder(Order order) {
        mOrders.add(order);
        mAdapter.notifyDataSetChanged();
    }
}
