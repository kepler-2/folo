package com.kepler.brandde.support;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.kepler.brandde.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 12 on 9/23/2016.
 */
public abstract class BaseActivityNoActionBar extends AppCompatActivity {

//    @BindView(R.id.toolbar)
//    public Toolbar mToolbarView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        ButterKnife.bind(this);
    }

    protected abstract int getContentView();

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }

}
