package com.kepler.brandde;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.kepler.brandde.support.ActivityStarter;
import com.kepler.brandde.support.BaseActivityNoActionBar;
import com.kepler.brandde.support.Logger;
import com.kepler.brandde.support.LoginDialog;

import org.json.JSONObject;

import java.util.Arrays;

import butterknife.BindView;

public class Login extends BaseActivityNoActionBar implements View.OnClickListener {

    @BindView(R.id.b_cwf)
    Button b_cwf;
    @BindView(R.id.b_sign_up)
    Button b_sign_up;
    @BindView(R.id.tv_login)
    TextView tv_login;
    @BindView(R.id.tv_policy)
    TextView tv_policy;
    @BindView(R.id.tv_skip)
    TextView tv_skip;
    @BindView(R.id.iv_logo)
    ImageView iv_logo;
    @BindView(R.id.login_button)
    LoginButton login_button;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iv_logo.animate()
                .setDuration(1000)
                .alpha(1.0f)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                    }
                });
        b_cwf.setOnClickListener(this);
        b_sign_up.setOnClickListener(this);
        tv_login.setOnClickListener(this);
        tv_policy.setOnClickListener(this);
        tv_skip.setOnClickListener(this);
        callbackManager = CallbackManager.Factory.create();
        login_button.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(LoginResult loginResult) {
                Logger.e(Login.class, loginResult.getAccessToken().getUserId());
                Logger.e(Login.class, loginResult.getAccessToken().getToken());
                Logger.e(Login.class, loginResult.getRecentlyGrantedPermissions().toString());
                Logger.e(Login.class, loginResult.getRecentlyDeniedPermissions().toString());
                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(JSONObject object, GraphResponse response) {
                                Logger.e(Login.class, response.toString());
                                Logger.e(Login.class, object.toString());

                                // Application code
                            }
                        });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,email,gender,birthday,picture,link");
                request.setParameters(parameters);
                request.executeAsync();

                new GraphRequest(
                        AccessToken.getCurrentAccessToken(),
                        "/" + loginResult.getAccessToken().getUserId() + "/friendlists",
                        null,
                        HttpMethod.GET,
                        new GraphRequest.Callback() {
                            public void onCompleted(GraphResponse response) {
                                Logger.e(Login.class, response.toString());

                            }
                        }
                ).executeAsync();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {
                Logger.printTrash(error);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_ogin;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.b_cwf:
                LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile", "user_friends", "email", "user_birthday", "user_photos", "read_custom_friendlists"));
                break;
            case R.id.b_sign_up:
                LoginDialog.createAnAccount(this, true);
                break;
            case R.id.tv_login:
                LoginDialog.login(this, true);
                break;
            case R.id.tv_policy:
                break;
            case R.id.tv_skip:
                ActivityStarter.startActivity(this, null, true, HomeActivity.class);
                break;
        }
    }

    private void followBrand() {
        Intent intent = new Intent(this, FollowBrand.class);
        startActivity(intent);
        onBackPressed();
    }
}
