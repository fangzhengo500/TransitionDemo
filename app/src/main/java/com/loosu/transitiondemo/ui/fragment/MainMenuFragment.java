package com.loosu.transitiondemo.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loosu.transitiondemo.R;
import com.loosu.transitiondemo.adapter.MainMenuItemAdapter;
import com.loosu.transitiondemo.adapter.base.recyclerview.IRecyclerItemClickListener;
import com.loosu.transitiondemo.utils.KLog;

import java.util.ArrayList;
import java.util.List;

public class MainMenuFragment extends Fragment implements IRecyclerItemClickListener {
    private static final String TAG = "MainMenuFragment";


    private RecyclerView mViewList;
    private LinearLayoutManager mLayoutManager;
    private MainMenuItemAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findView(view, savedInstanceState);
        initView(view, savedInstanceState);
        initListener(view, savedInstanceState);
    }

    private void init(Bundle savedInstanceState) {
        Context context = getContext();

        List<String> datas = new ArrayList<>();
        datas.add("Transition");

        mLayoutManager = new LinearLayoutManager(context);
        mAdapter = new MainMenuItemAdapter(datas);
    }

    private void findView(@NonNull View view, Bundle savedInstanceState) {
        mViewList = view.findViewById(R.id.view_list);
    }

    private void initView(View view, Bundle savedInstanceState) {
        mViewList.setLayoutManager(mLayoutManager);
        mViewList.setAdapter(mAdapter);
    }

    private void initListener(View view, Bundle savedInstanceState) {
        mAdapter.setItemClickListener(this);
    }

    @Override
    public void onItemClick(RecyclerView parent, int position, RecyclerView.ViewHolder holder, View view) {
        KLog.d(TAG, "position = " + position + ", holder = " + holder + ", view = " + view);
    }
}
