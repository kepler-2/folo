package com.kepler.brandde;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.kepler.brandde.fragment.HomeFragment;
import com.kepler.brandde.support.BaseActivity;
import com.kepler.brandde.support.OnOkayCancelListener;
import com.kepler.brandde.support.YoirDialog;

import butterknife.BindView;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.drawer_layout)
    public DrawerLayout drawer_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        YoirDialog.showDialog(this, tool_bar_back);
        tool_bar_back.setVisibility(View.GONE);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                drawer_layout,
                mToolbarView,
                R.string.app_name,
                R.string.app_name
        )

        {
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
//                invalidateOptionsMenu();
//                syncState();
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
//                invalidateOptionsMenu();
//                syncState();
            }


        };
        drawer_layout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        mToolbarView.setNavigationIcon(R.drawable.drawer_icon);
        replaceMainFragmentTransaction(new HomeFragment(), null);
    }

    private void replaceMainFragmentTransaction(Fragment fragment, Bundle bundle) {
        FragmentTransaction ft_one = getSupportFragmentManager()
                .beginTransaction();
        fragment.setArguments(bundle);
        ft_one.add(R.id.home_fragment_container, fragment);
//        ft_one.addToBackStack(fragment.getClass().getSimpleName());
        ft_one.commit();
    }


    @Override
    protected int getContentView() {
        return R.layout.activity_home;
    }

    @Override
    public void onBackPressed() {
        YoirDialog.openCustomConfirmDialog(this, "Exit Application", "Exit Now ?", new OnOkayCancelListener() {
            @Override
            public void onOkay(Object object) {
                HomeActivity.super.onBackPressed();
            }

            @Override
            public void onCancel(Object object) {

            }
        }, true);
    }
}
