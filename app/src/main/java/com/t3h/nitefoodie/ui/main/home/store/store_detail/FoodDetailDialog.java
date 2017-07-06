package com.t3h.nitefoodie.ui.main.home.store.store_detail;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.t3h.nitefoodie.R;
import com.t3h.nitefoodie.model.Food;

/**
 * Created by thinhquan on 7/4/17.
 */

public class FoodDetailDialog extends Dialog implements View.OnClickListener {
    private ImageView ivFood;
    private TextView tvFoodName;
    private TextView tvFoodPrice;
    private TextView tvNumberFood;
    private OnClickDialog mInterf;
    private Food food;

    public FoodDetailDialog(@NonNull Context context, OnClickDialog interf) {
        super(context);
        mInterf = interf;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_food_detail);
        findViewByIds();
        setEvents();
    }

    private void setEvents() {
        findViewById(R.id.ib_add_food).setOnClickListener(this);
        findViewById(R.id.ib_remove_food).setOnClickListener(this);
        findViewById(R.id.btn_food_order).setOnClickListener(this);
    }

    private void findViewByIds() {
        ivFood = (ImageView) findViewById(R.id.iv_food);
        tvFoodName = (TextView) findViewById(R.id.tv_food_name);
        tvFoodPrice = (TextView) findViewById(R.id.tv_food_price);
        tvNumberFood = (TextView) findViewById(R.id.tv_number_food);
    }

    @Override
    public void onClick(View v) {
        int numberFood = Integer.parseInt(tvNumberFood.getText().toString());
        switch (v.getId()) {
            case R.id.ib_add_food:
                numberFood++;
                tvNumberFood.setText(numberFood + "");
                break;
            case R.id.ib_remove_food:
                if (numberFood > 0) {
                    numberFood--;
                    tvNumberFood.setText(numberFood + "");
                }
                break;
            case R.id.btn_food_order:
                mInterf.onOrderSubmitClick(numberFood);
                dismiss();
                break;
        }
    }

    public interface OnClickDialog {
        void onOrderSubmitClick(int numberFood);
    }
}
