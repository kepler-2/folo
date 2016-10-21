package com.kepler.brandde;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.kepler.brandde.adapter.AdapterFollowBrand;
import com.kepler.brandde.dao.Brand;
import com.kepler.brandde.support.ActivityStarter;
import com.kepler.brandde.support.BaseActivity;
import com.kepler.brandde.support.OnOkayCancelListener;
import com.kepler.brandde.support.YoirDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class FollowBrand extends BaseActivity {

    @BindView(R.id.lv_follow_brand)
    ListView lv_follow_brand;
    @BindView(R.id.b_proceed)
    public Button b_proceed;
    private List<Brand> brands = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tool_bar_back.setVisibility(View.GONE);
        tool_bar_search.setVisibility(View.GONE);
//        mToolbarView.setBackgroundColor(Color.BLACK);
        toolbar_title.setGravity(Gravity.CENTER);
//        toolbar_title.setTextColor(Color.WHITE);
        toolbar_title.setText(getResources().getString(R.string.follow_brand));
        lv_follow_brand.setAdapter(new AdapterFollowBrand(this));

        b_proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityStarter.startActivity(FollowBrand.this, null, true, HomeActivity.class);
            }
        });
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_follow_brand;
    }

    @Override
    public void onBackPressed() {
        YoirDialog.openConfirmDialog(this, "Confirm", "Your Registration will be failed. Do you wanna continue ?", new OnOkayCancelListener() {
            @Override
            public void onOkay(Object object) {
                FollowBrand.super.onBackPressed();
            }

            @Override
            public void onCancel(Object object) {

            }
        }, true);
    }
}
