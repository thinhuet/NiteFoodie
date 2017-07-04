package com.t3h.nitefoodie.ui.main.home.store;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.t3h.nitefoodie.R;
import com.t3h.nitefoodie.ui.base.activity.BaseActivity;

/**
 * Created by thinhquan on 6/30/17.
 */

public class StoreDetailActivity extends BaseActivity implements View.OnClickListener, FoodAdapter.IRecipeAdapter {
    private Toolbar toolbar;
    private ImageView ivToolbar;
    private FloatingActionButton fabFavourite;
    private RecyclerView rcStoreMenu;
    private FoodAdapter mFoodAdapter;

    @Override
    public int getLayoutMain() {
        return R.layout.store_detail_fragment;
    }

    @Override
    public void findViewByIds() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        fabFavourite = (FloatingActionButton) findViewById(R.id.fab_favourite);
        ivToolbar = (ImageView) findViewById(R.id.iv_store);
        rcStoreMenu = (RecyclerView) findViewById(R.id.rc_store_menu);
    }

    @Override
    public void initComponents() {
        ivToolbar.setBackgroundResource(R.drawable.gongcha);
        //  ivToolbar.setScaleType(ImageView.ScaleType.CENTER_CROP);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Tra sua Gongcha");
        getSupportActionBar().setSubtitle("Ly Thuong Kiet");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mFoodAdapter = new FoodAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcStoreMenu.setLayoutManager(linearLayoutManager);
        rcStoreMenu.setAdapter(mFoodAdapter);
        rcStoreMenu.setFocusable(false);
        rcStoreMenu.setNestedScrollingEnabled(false);
    }

    @Override
    public void setEvents() {
        fabFavourite.setOnClickListener(this);
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
        }
    }

    @Override
    public int getCount() {
        return 15;
    }

    @Override
    public void onClick(int position) {
        final FoodDetailDialog detailDialog = new FoodDetailDialog(this, new FoodDetailDialog.OnClickDialog() {
            @Override
            public void onOrderSubmitClick(int numberFood) {
                Toast.makeText(StoreDetailActivity.this, "afdagdag"+numberFood, Toast.LENGTH_SHORT).show();
            }
        });
        detailDialog.show();
    }
}
