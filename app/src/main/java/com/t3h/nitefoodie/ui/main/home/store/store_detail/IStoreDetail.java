package com.t3h.nitefoodie.ui.main.home.store.store_detail;

import com.t3h.nitefoodie.model.Store;
import com.t3h.nitefoodie.ui.base.IBasePresenter;
import com.t3h.nitefoodie.ui.base.IViewMain;

/**
 * Created by thinhquan on 7/6/17.
 */

public class IStoreDetail {
    interface View extends IViewMain {
        void finishGetStoreDetail(Store store);
    }

    interface Presenter extends IBasePresenter {
        void getStoreInfo(String sId);
    }
}
