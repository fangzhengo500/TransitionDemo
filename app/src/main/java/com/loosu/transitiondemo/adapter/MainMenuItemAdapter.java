package com.loosu.transitiondemo.adapter;

import android.support.annotation.Nullable;

import com.loosu.transitiondemo.R;
import com.loosu.transitiondemo.adapter.base.recyclerview.ARecyclerAdapter;
import com.loosu.transitiondemo.adapter.base.recyclerview.RecyclerHolder;

import java.util.List;

public class MainMenuItemAdapter extends ARecyclerAdapter<String> {

    public MainMenuItemAdapter(@Nullable List<String> datas) {
        super(datas);
    }

    @Override
    protected void onBindViewData(RecyclerHolder holder, int position, List<String> datas) {
        holder.setText(R.id.tv_label, getItem(position));
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_main_menu;
    }

    @Override
    public String getItem(int position) {
        return getDatas().get(position);
    }
}
