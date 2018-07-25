package com.aceplus.rxjavasearchmvp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import com.aceplus.rxjavasearchmvp.R;
import com.aceplus.rxjavasearchmvp.adapter.SearchListAdapter;
import com.aceplus.rxjavasearchmvp.data.vo.Contact;
import com.aceplus.rxjavasearchmvp.mvp.presenter.SearchPresenter;
import com.aceplus.rxjavasearchmvp.mvp.view.SearchView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements SearchView {
    @BindView(R.id.search_box)
    EditText searchBox;
    @BindView(R.id.rv_search)
    RecyclerView rvSearch;
    SearchListAdapter mAdapter;
    SearchPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mAdapter = new SearchListAdapter(getApplicationContext());
        rvSearch.setAdapter(mAdapter);
        rvSearch.setLayoutManager(new LinearLayoutManager(this));
        mPresenter = new SearchPresenter(this);
        mPresenter.searchData("");
        searchBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mPresenter.searchData(s.toString());
            }
        });
    }

    @Override
    public void showSearchResult(List<Contact> contacts) {
        mAdapter.setNewList(contacts);
    }

    @Override
    public void showErrorMessage(String str) {
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestory();
    }
}
