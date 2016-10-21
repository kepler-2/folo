package com.kepler.brandde.support;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.kepler.brandde.HomeActivity;
import com.kepler.brandde.Login;
import com.kepler.brandde.R;

/**
 * Created by 12 on 9/12/2016.
 */
public class ActivityStarter {

    public static void startActivity(Context context, Bundle bundle, boolean isFinished,Class<? extends BaseActivity> activityClass) {
        Intent intent = new Intent(context, activityClass);
        if (bundle != null)
            intent.putExtras(bundle);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            activity.startActivity(intent);
            finishActivity(activity, isFinished);
            activity.overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
        } else {
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public static void _startActivity(Context context, Bundle bundle, boolean isFinished, Class<? extends BaseActivityNoActionBar> activityClass) {
        Intent intent = new Intent(context, activityClass);
        if (bundle != null)
            intent.putExtras(bundle);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            activity.startActivity(intent);
            finishActivity(activity, isFinished);
            activity.overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
        } else {
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }


    private static void finishActivity(Activity activity, boolean isFinish) {
        try {
            if (isFinish)
                activity.finish();
        } catch (Exception e) {

        }
    }
}
