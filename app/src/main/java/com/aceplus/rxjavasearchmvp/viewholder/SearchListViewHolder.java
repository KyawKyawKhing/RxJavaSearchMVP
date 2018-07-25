package com.aceplus.rxjavasearchmvp.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aceplus.rxjavasearchmvp.R;
import com.aceplus.rxjavasearchmvp.data.vo.Contact;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;

/**
 * Created by kkk on 7/9/2018.
 */

public class SearchListViewHolder extends BaseViewHolder<Contact> {

    @BindView(R.id.name)
    TextView name;

    @BindView(R.id.phone)
    TextView phone;

    @BindView(R.id.thumbnail)
    ImageView thumbnail;


    public SearchListViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(Contact contact) {
        name.setText(contact.getName());
        phone.setText(contact.getPhone());

        Glide.with(itemView.getContext())
                .load(contact.getProfileImage())
                .apply(RequestOptions.circleCropTransform())
                .into(thumbnail);
    }

}
