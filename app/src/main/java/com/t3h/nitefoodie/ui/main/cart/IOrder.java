package com.t3h.nitefoodie.ui.main.cart;

import com.t3h.nitefoodie.model.Order;
import com.t3h.nitefoodie.ui.base.IBasePresenter;
import com.t3h.nitefoodie.ui.base.IViewMain;

/**
 * Created by thinhquan on 7/7/17.
 */

public class IOrder {
    interface View extends IViewMain {
        void onGetOrder(Order order);
    }

    interface Presenter extends IBasePresenter {
        void getListOrder();
    }
}
