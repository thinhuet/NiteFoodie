package com.t3h.nitefoodie.ui.base;

import android.view.View;

/**
 * Created by thinhquan on 6/24/17.
 */

public class BasePresenter<V extends IViewMain> implements IBasePresenter {

    protected V mView;

    public BasePresenter(V view) {
        mView = view;
    }

    @Override
    public void onDestroy() {

    }
}
