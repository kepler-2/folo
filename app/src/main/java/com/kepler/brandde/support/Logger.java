package com.kepler.brandde.support;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by 12 on 1/11/2016.
 */
public class Logger {
    private static boolean isLoggable = true;

    public static void d(Class callingClass, String msg) {
        try {
            if (isLoggable)
                Log.d(callingClass.getSimpleName(), msg);
        } catch (Exception e) {
            printTrash(e);
        }
    }

    public static void i(Class callingClass, String msg) {
        try {
            if (isLoggable)
                Log.i(callingClass.getSimpleName(), msg);
        } catch (Exception e) {
            printTrash(e);
        }
    }

    public static void e(Class callingClass, String msg) {
        try {
            if (isLoggable)
                Log.e(callingClass.getSimpleName(), msg);
        } catch (Exception e) {
            printTrash(e);
        }
    }

    public static void printTrash(Exception e) {
        if (isLoggable)
            e.printStackTrace();
    }

    public static void makeSimpleToast(Context applicationContext, String msg) {
        if (applicationContext != null && msg != null) {
            Toast toast = Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }

    public static void makeSimpleToast(Context applicationContext, String msg, int length) {
        if (applicationContext != null && msg != null) {
            Toast toast = Toast.makeText(applicationContext, msg, length);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }

    public static void sendReport(byte[] responseBody, String message) {
        e(Logger.class, message);
    }

    public static void sendReport(byte[] responseBody, Exception e) {
        e.printStackTrace();
    }
}

