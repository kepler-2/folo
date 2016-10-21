package com.kepler.brandde.support;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.kepler.brandde.R;

/**
 * Created by 12 on 9/27/2016.
 */
public class YoirDialog {

    public static void showDialog(Activity activity, final View anchor) {
        View view = activity.getLayoutInflater().inflate(R.layout.error_page, null);
        final PopupWindow popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, false);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        popupWindow.setOutsideTouchable(false);
        new Handler().postDelayed(new Runnable() {

            public void run() {
                popupWindow.showAsDropDown(anchor, 0, 0);
            }

        }, 100L);
    }

    public static Dialog openConfirmDialog(Activity activity, final String title, final String message, final OnOkayCancelListener onOkCancel, boolean isCustomAnimation) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setPositiveButton("Sure", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                onOkCancel.onOkay(null);
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                onOkCancel.onCancel(null);
            }
        }).setCancelable(false).setMessage(message);
        final Dialog dialog = builder.create();
        if (title == null)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        else
            dialog.setTitle(title);
        if (isCustomAnimation)
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
//        dialog.setCancelable(false);
        dialog.show();
        return dialog;
    }

    public static Dialog openCustomConfirmDialog(Activity activity, final String title, final String message, final OnOkayCancelListener onOkCancel, boolean isCustomAnimation) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = activity.getLayoutInflater().inflate(R.layout.custom_dialog, null);
        TextView tv_custom_dialog_sure = (TextView) view.findViewById(R.id.tv_custom_dialog_sure);
        TextView tv_custom_dialog_cancel = (TextView) view.findViewById(R.id.tv_custom_dialog_cancel);
        TextView tv_custom_dialog_title = (TextView) view.findViewById(R.id.tv_custom_dialog_title);
        TextView tv_custom_dialog_message = (TextView) view.findViewById(R.id.tv_custom_dialog_message);
        tv_custom_dialog_title.setText(title);
        tv_custom_dialog_message.setText(message);
        tv_custom_dialog_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                onOkCancel.onCancel(null);
            }
        });
        tv_custom_dialog_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                onOkCancel.onOkay(null);
            }
        });
        dialog.setContentView(view);
//        dialog.setTitle(title);
        if (isCustomAnimation)
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
//        dialog.setCancelable(false);
        dialog.show();
        return dialog;
    }

}
