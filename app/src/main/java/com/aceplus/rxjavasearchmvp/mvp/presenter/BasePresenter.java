package com.aceplus.rxjavasearchmvp.mvp.presenter;


import com.aceplus.rxjavasearchmvp.mvp.view.BaseView;

/**
 * Created by kkk on 7/9/2018.
 */

public abstract class BasePresenter<V extends BaseView> {
    protected V mView;

    public BasePresenter(V mView) {
        this.mView = mView;
    }

    public void onDestory() {
    }
}
