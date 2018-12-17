package com.loosu.transitiondemo.ui.activity;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.loosu.transitiondemo.R;
import com.loosu.transitiondemo.ui.fragment.ChangeBoundsFragment;
import com.loosu.transitiondemo.ui.fragment.TransitionSimpleFragment;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mLayoutDrawer;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView(savedInstanceState);
        initView(savedInstanceState);
    }


    private void findView(Bundle savedInstanceState) {
        mToolbar = findViewById(R.id.toolbar);
        mLayoutDrawer = findViewById(R.id.layout_drawer);
    }

    private void initView(Bundle savedInstanceState) {
        // toolbar
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        // toolbar - toggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mLayoutDrawer, mToolbar,
                R.string.main_drawer_open_desc, R.string.main_drawer_close_desc);
        mLayoutDrawer.addDrawerListener(toggle);
        toggle.syncState();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.layout_main_content, new ChangeBoundsFragment())
                .commit();
    }
}
