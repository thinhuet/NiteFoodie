package com.t3h.nitefoodie.ui.main.home.store;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.t3h.nitefoodie.R;
import com.t3h.nitefoodie.ui.base.activity.BaseActivity;
import com.t3h.nitefoodie.ui.base.fragment.BaseMVPFragment;

/**
 * Created by thinhquan on 6/30/17.
 */

public class StoreDetailActivity extends BaseActivity implements View.OnClickListener, RecipeAdapter.IRecipeAdapter {
    private Toolbar toolbar;
    private ImageView ivToolbar;
    private FloatingActionButton fabFavourite;
    private RecyclerView rcStoreMenu;
    private RecipeAdapter mRecipeAdapter;

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
        ivToolbar.setScaleType(ImageView.ScaleType.CENTER_CROP);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Tra sua Gongcha");
        getSupportActionBar().setSubtitle("Ly Thuong Kiet");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRecipeAdapter = new RecipeAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcStoreMenu.setLayoutManager(linearLayoutManager);
        rcStoreMenu.setAdapter(mRecipeAdapter);
        rcStoreMenu.setFocusable(false);
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
}
