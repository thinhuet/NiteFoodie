package com.t3h.nitefoodie.ui.main.home.store.store_detail;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.t3h.nitefoodie.R;
import com.t3h.nitefoodie.common.Constants;
import com.t3h.nitefoodie.model.Food;
import com.t3h.nitefoodie.model.Store;
import com.t3h.nitefoodie.ui.base.activity.BaseActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by thinhquan on 6/30/17.
 */

public class StoreDetailActivity extends BaseActivity implements IStoreDetail.View, View.OnClickListener, FoodAdapter.IRecipeAdapter {
    private Toolbar toolbar;
    private ImageView ivToolbar;
    private TextView tvAddress;
    private RatingBar ratingBar;
    private TextView tvNumberRating;
    private ImageView ivOnlineState;
    private TextView tvOnlineState;
    private Button btnPhone;
    private FloatingActionButton fabFavourite;

    private RecyclerView rcStoreMenu;
    private List<Food> mFoods;
    private FoodAdapter mFoodAdapter;
    private StoreDetailPresenter mPresenter;
    private String sId;

    @Override
    public int getLayoutMain() {
        return R.layout.store_detail_fragment;
    }

    @Override
    public void findViewByIds() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        fabFavourite = (FloatingActionButton) findViewById(R.id.fab_favourite);
        ivToolbar = (ImageView) findViewById(R.id.iv_store);
        tvAddress = (TextView) findViewById(R.id.tv_store_address);
        ratingBar = (RatingBar) findViewById(R.id.rating_bar);
        tvNumberRating = (TextView) findViewById(R.id.tv_number_rating);
        ivOnlineState = (ImageView) findViewById(R.id.iv_online_state);
        tvOnlineState = (TextView) findViewById(R.id.tv_online_state);
        btnPhone = (Button) findViewById(R.id.btn_store_phone);

        rcStoreMenu = (RecyclerView) findViewById(R.id.rc_store_menu);
    }

    @Override
    public void initComponents() {
        sId = getIntent().getStringExtra(Constants.ID_USER);
        mPresenter = new StoreDetailPresenter(this);

        mFoods = new ArrayList<>();
        mFoodAdapter = new FoodAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcStoreMenu.setLayoutManager(linearLayoutManager);
        rcStoreMenu.setAdapter(mFoodAdapter);
        rcStoreMenu.setFocusable(false);
        rcStoreMenu.setNestedScrollingEnabled(false);

        mPresenter.getStoreInfo(sId);
    }

    @Override
    public void setEvents() {
        fabFavourite.setOnClickListener(this);
        btnPhone.setOnClickListener(this);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackMain();
            }
        });
    }

    @Override
    public void onBackRoot() {
        onBackMain();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_favourite:
                fabFavourite.setImageResource(R.drawable.ic_favorite_white_24dp);
                break;
            case R.id.btn_store_phone:
                break;
        }
    }

    @Override
    public int getCount() {
        return mFoods.size();
    }

    @Override
    public void onClick(int position) {
        final FoodDetailDialog detailDialog = new FoodDetailDialog(this, new FoodDetailDialog.OnClickDialog() {
            @Override
            public void onOrderSubmitClick(int numberFood) {
                Toast.makeText(StoreDetailActivity.this, "afdagdag" + numberFood, Toast.LENGTH_SHORT).show();
            }
        });
        detailDialog.show();
    }

    @Override
    public Food getFood(int position) {
        return mFoods.get(position);
    }

    @Override
    public void finishGetStoreDetail(Store store) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(store.getName());
        Picasso.with(this).load(store.getPhotoUrl()).into(ivToolbar);
        ivToolbar.setScaleType(ImageView.ScaleType.CENTER_CROP);
        tvAddress.setText(store.getAddress());
        ratingBar.setRating((float) store.getRate());
        tvNumberRating.setText(store.getNumberRating() + "");
        btnPhone.setText(store.getPhone());

        HashMap<String, Food> menu = store.getMenu();
        for (Food food : menu.values()) {
            mFoods.add(food);
            mFoodAdapter.notifyDataSetChanged();
        }
    }
}
