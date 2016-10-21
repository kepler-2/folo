package com.kepler.brandde;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.kepler.brandde.support.ActivityStarter;
import com.kepler.brandde.support.BaseActivityNoActionBar;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Splash extends BaseActivityNoActionBar implements GraphRequest.Callback {

    private static final long TIME_SPLASH = 3000;
    @BindView(R.id.brand_logo)
    ImageView brand_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ButterKnife.bind(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ActivityStarter._startActivity(Splash.this, null, true, Login.class);

//                ActivityStarter.statrtHome(Splash.this,null,true);

            }
        }, TIME_SPLASH);
//        startAnimation();

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_plash;
    }

    private void startAnimation() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        anim.reset();
        brand_logo.clearAnimation();
        brand_logo.startAnimation(anim);
        brand_logo.setVisibility(View.VISIBLE);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        pushClientManager.registerIfNeeded(null, getApplicationContext());
//                    }
//                }).start();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
//                        try {
//                            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
//                            for (Signature signature : info.signatures) {
//                                MessageDigest md = MessageDigest.getInstance("SHA");
//                                md.update(signature.toByteArray());
//                                Log.e("MY KEY HASH:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
//                            }
//                        } catch (PackageManager.NameNotFoundException e) {
//
//                        } catch (NoSuchAlgorithmException e) {
//
//                        }
//                        new GraphRequest(AccessToken.getCurrentAccessToken(), "/Levis.india/feed", null, HttpMethod.GET, Splash.this).executeAsync();
                        ActivityStarter._startActivity(Splash.this, null, true, Login.class);



                    }
                }, TIME_SPLASH);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    @Override
    public void onCompleted(GraphResponse response) {
        com.kepler.brandde.support.Logger.e(Splash.class, response.toString());

    }
}
