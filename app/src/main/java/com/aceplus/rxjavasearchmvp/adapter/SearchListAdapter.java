package com.aceplus.rxjavasearchmvp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.aceplus.rxjavasearchmvp.R;
import com.aceplus.rxjavasearchmvp.data.vo.Contact;
import com.aceplus.rxjavasearchmvp.viewholder.SearchListViewHolder;

/**
 * Created by kkk on 7/2/2018.
 */

public class SearchListAdapter extends BaseRecyclerAdapter<SearchListViewHolder, Contact> {

    public SearchListAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public SearchListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.contact_row_itemlist, parent, false);
        return new SearchListViewHolder(view);
    }
}
