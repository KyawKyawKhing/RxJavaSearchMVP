package com.aceplus.rxjavasearchmvp.mvp.presenter;

import com.aceplus.rxjavasearchmvp.data.model.SearchModel;
import com.aceplus.rxjavasearchmvp.data.vo.Contact;
import com.aceplus.rxjavasearchmvp.mvp.view.SearchView;

import java.util.List;

import io.reactivex.subjects.PublishSubject;

/**
 * Created by kkk on 7/9/2018.
 */

public class SearchPresenter extends BasePresenter<SearchView> {
    SearchModel searchModel;

    public SearchPresenter(SearchView mView) {
        super(mView);
        searchModel = SearchModel.getInstance();
    }


    public void searchData(PublishSubject<List<Contact>> contacts,String str) {
        searchModel.searchData(str, new SearchModel.GetDataCallback() {
            @Override
            public void onSucceedSearch(List<Contact> contacts) {
                mView.showSearchResult(contacts);
            }

            @Override
            public void onFailedSearch(String str) {
                mView.showErrorMessage(str);
            }
        });
    }

    @Override
    public void onDestory() {
        super.onDestory();
        searchModel.onDestory();
    }
}
