package com.kepler.brandde;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kepler.brandde.support.BaseActivityNoActionBar;

public class SelectTags extends BaseActivityNoActionBar {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_select_tags;
    }
}
