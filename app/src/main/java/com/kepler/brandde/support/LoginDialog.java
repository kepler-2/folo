package com.kepler.brandde.support;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.kepler.brandde.Login;
import com.kepler.brandde.R;

/**
 * Created by 12 on 9/27/2016.
 */

public class LoginDialog {

    public static Dialog createAnAccount(Activity activity, boolean isCustomAnimation) {
        Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = activity.getLayoutInflater().inflate(R.layout.create_an_account, null);
        dialog.setContentView(view);
//        dialog.getWindow().getAttributes()
        if (isCustomAnimation) {
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        }
        dialog.show();
        return dialog;
    }

    public static Dialog login(Activity activity, boolean isCustomAnimation) {
        Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = activity.getLayoutInflater().inflate(R.layout.sign_in, null);
        dialog.setContentView(view);
        if (isCustomAnimation)
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.show();
//        dialog.getWindow().getAttributes()
        return dialog;
    }
}
