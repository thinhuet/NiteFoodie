package com.t3h.nitefoodie.ui.base;

import android.support.annotation.StringRes;

/**
 * Created by thinhquan on 6/24/17.
 */

public interface IViewMain {
    int getLayoutMain();

    void findViewByIds();

    void initComponents();

    void setEvents();

    void showProgress();

    void hideProgress();

    void showMessage(String content);

    void showMessage(@StringRes int content);

    void onBackRoot();
}
