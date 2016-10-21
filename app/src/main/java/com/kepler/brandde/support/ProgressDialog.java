package com.kepler.brandde.support;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;

import com.kepler.brandde.R;

/**
 * Created by 12 on 9/22/2016.
 */
public class ProgressDialog {

    public static Dialog show(Activity activity) {
        final Dialog dialog = new Dialog(activity);
        dialog.setContentView(R.layout.progress_bar);
        dialog.show();
        return dialog;
    }


}
