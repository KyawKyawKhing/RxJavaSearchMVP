package com.aceplus.rxjavasearchmvp.mvp.view;

import com.aceplus.rxjavasearchmvp.data.vo.Contact;

import java.util.List;

/**
 * Created by hakerfaker on 7/24/2018.
 */

public interface SearchView extends BaseView {
    void showSearchResult(List<Contact> contacts);
}
