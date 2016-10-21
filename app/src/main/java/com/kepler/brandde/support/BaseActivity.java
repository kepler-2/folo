package com.kepler.brandde.support;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.kepler.brandde.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 12 on 9/23/2016.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    public Toolbar mToolbarView;
    @BindView(R.id.tool_bar_back)
    public ImageView tool_bar_back;
    @BindView(R.id.tool_bar_search)
    public ImageView tool_bar_search;
    @BindView(R.id.toolbar_title)
    public TextView toolbar_title;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        ButterKnife.bind(this);
        mToolbarView = (Toolbar) findViewById(R.id.toolbar);
        mToolbarView.setTitle("");
        mToolbarView.setContentInsetsAbsolute(0, 0);
        setSupportActionBar(mToolbarView);
    }

    protected abstract int getContentView();

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }



}
