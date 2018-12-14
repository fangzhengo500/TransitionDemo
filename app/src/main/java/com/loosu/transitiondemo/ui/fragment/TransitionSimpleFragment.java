package com.loosu.transitiondemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.transition.Scene;
import android.support.transition.TransitionManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Spinner;

import com.loosu.transitiondemo.R;
import com.loosu.transitiondemo.adapter.TransitionModeAdapter;
import com.loosu.transitiondemo.utils.KLog;

public class TransitionSimpleFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "TransitionSimpleFragmen";

    private FrameLayout mLayoutTransitionContent;
    private Spinner mSpinnerTransitionMode;

    private View mBtn1;
    private View mBtn2;
    private View mBtn3;
    private View mBtn4;

    private TransitionModeAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_transition_simple, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        KLog.d(TAG, "view = " + view + ", savedInstanceState = " + savedInstanceState);
        super.onViewCreated(view, savedInstanceState);
        findView(view, savedInstanceState);
        initView(view, savedInstanceState);
        initListener(view, savedInstanceState);
    }

    private void findView(View view, Bundle savedInstanceState) {
        mLayoutTransitionContent = view.findViewById(R.id.layout_transition_content);
        mSpinnerTransitionMode = view.findViewById(R.id.spinner_transition);

        mBtn1 = view.findViewById(R.id.btn1);
        mBtn2 = view.findViewById(R.id.btn2);
        mBtn3 = view.findViewById(R.id.btn3);
        mBtn4 = view.findViewById(R.id.btn4);
    }

    private void initView(View view, Bundle savedInstanceState) {
        mAdapter = new TransitionModeAdapter();
        mSpinnerTransitionMode.setAdapter(mAdapter);
    }

    private void initListener(View view, Bundle savedInstanceState) {
        mBtn1.setOnClickListener(this);
        mBtn2.setOnClickListener(this);
        mBtn3.setOnClickListener(this);
        mBtn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                changeScene(R.layout.layout_scene1);
                break;
            case R.id.btn2:
                changeScene(R.layout.layout_scene2);
                break;
            case R.id.btn3:
                changeScene(R.layout.layout_scene3);
                break;
            case R.id.btn4:
                changeScene(R.layout.layout_scene4);
                break;
        }
    }

    private void changeScene(@LayoutRes int layoutId) {
        Scene scene = Scene.getSceneForLayout(mLayoutTransitionContent, layoutId, getContext());
        TransitionManager.go(scene, mAdapter.getItem(mSpinnerTransitionMode.getSelectedItemPosition()));

        View view = getView();
        mBtn1 = view.findViewById(R.id.btn1);
        mBtn2 = view.findViewById(R.id.btn2);
        mBtn3 = view.findViewById(R.id.btn3);
        mBtn4 = view.findViewById(R.id.btn4);

        mBtn1.setOnClickListener(this);
        mBtn2.setOnClickListener(this);
        mBtn3.setOnClickListener(this);
        mBtn4.setOnClickListener(this);
    }
}
