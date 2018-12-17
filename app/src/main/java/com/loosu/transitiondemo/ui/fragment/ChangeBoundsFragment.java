package com.loosu.transitiondemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.transition.ChangeBounds;
import android.support.transition.TransitionManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loosu.transitiondemo.R;

public class ChangeBoundsFragment extends Fragment implements View.OnClickListener {

    private View mBtn1;
    private View mBtn2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_change_bounds, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        findView(view, savedInstanceState);
        initView(view, savedInstanceState);
        initListener(view, savedInstanceState);
    }

    private void initView(View view, Bundle savedInstanceState) {

    }

    private void findView(View view, Bundle savedInstanceState) {
        mBtn1 = view.findViewById(R.id.btn1);
        mBtn2 = view.findViewById(R.id.btn2);
    }

    private void initListener(View view, Bundle savedInstanceState) {
        mBtn1.setOnClickListener(this);
        mBtn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                onClickBtn1();
                break;
            case R.id.btn2:
                onClickBtn2();
                break;
        }
    }

    private void onClickBtn1() {
        ChangeBounds bounds = new ChangeBounds();
        bounds.setDuration(1000);
        TransitionManager.beginDelayedTransition((ViewGroup) getView(), bounds);

        ViewGroup.LayoutParams params1 = mBtn1.getLayoutParams();
        params1.width = 400;
        params1.height = 400;
        mBtn1.setLayoutParams(params1);

        ViewGroup.LayoutParams params2 = mBtn2.getLayoutParams();
        params2.width = 100;
        params2.height = 100;
        mBtn2.setLayoutParams(params2);
    }

    private void onClickBtn2() {
        ChangeBounds bounds = new ChangeBounds();
        bounds.setDuration(1000);
        TransitionManager.beginDelayedTransition((ViewGroup) getView(), bounds);

        ViewGroup.LayoutParams params1 = mBtn1.getLayoutParams();
        params1.width = 100;
        params1.height = 100;
        mBtn1.setLayoutParams(params1);

        ViewGroup.LayoutParams params2 = mBtn2.getLayoutParams();
        params2.width = 400;
        params2.height = 400;
        mBtn2.setLayoutParams(params2);
    }
}
