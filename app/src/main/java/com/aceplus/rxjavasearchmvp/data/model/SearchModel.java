package com.aceplus.rxjavasearchmvp.data.model;

import com.aceplus.rxjavasearchmvp.data.vo.Contact;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by kkk on 7/02/2018.
 */

public class SearchModel extends BaseModel {
    private static SearchModel INSTANCE;
    private CompositeDisposable compositeDisposable;

    private SearchModel() {
        super();
        compositeDisposable = new CompositeDisposable();
    }

    public static SearchModel getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SearchModel();
        }
        return INSTANCE;
    }

    public void searchData(String str, final GetDataCallback callback) {
        compositeDisposable.add(mApiService.getContacts(null, str)
                .delay(300, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<Contact>>() {
                    @Override
                    public void onSuccess(List<Contact> contacts) {
                        callback.onSucceedSearch(contacts);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFailedSearch(e.getMessage());
                    }
                }));

/*********normal call************/
//        mApiService.getContacts(null, str)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new SingleObserver<List<Contact>>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onSuccess(List<Contact> contacts) {
//                        callback.onSucceedSearch(contacts);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        callback.onFailedSearch(e.getMessage());
//                    }
//                });
    }

    public void onDestory() {
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }

    public interface GetDataCallback {
        void onSucceedSearch(List<Contact> contacts);

        void onFailedSearch(String str);
    }

}
