package com.t3h.nitefoodie.ui.base.fragment;

import com.t3h.nitefoodie.ui.base.BasePresenter;
import com.t3h.nitefoodie.ui.base.IBasePresenter;

/**
 * Created by thinhquan on 6/24/17.
 */

public abstract class BaseMVPFragment<P extends IBasePresenter> extends BaseFragment {
    protected P mPresenter;

    @Override
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
        super.onDestroyView();
    }
}
