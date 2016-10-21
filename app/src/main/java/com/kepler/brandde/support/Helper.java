package com.kepler.brandde.support;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityEvent;

import com.nostra13.universalimageloader.core.DisplayImageOptions;

import java.util.StringTokenizer;

/**
 * Created by 12 on 1/9/2016.
 */
public class Helper {


    public static DisplayImageOptions.Builder getImageOption(int showImageOnLoading, int showImageForEmptyUri,
                                                     int showImageOnFail, boolean cacheInMemory,
                                                      boolean cacheOnDisk, boolean considerExifParams) {
        DisplayImageOptions.Builder optionBuilder = new DisplayImageOptions.Builder()
                .showImageOnLoading(showImageOnLoading)
                .showImageForEmptyUri(showImageForEmptyUri)
                .showImageOnFail(showImageOnFail).cacheInMemory(cacheInMemory)
                .cacheOnDisk(cacheOnDisk).considerExifParams(considerExifParams);
        return optionBuilder;
    }


    public static String getCamelCaseString(String key) {
        if (key == null || key.trim().length() == 0)
            return "";
        try {
            String[] words = key.split(" ");
            StringBuilder sb = new StringBuilder();
            if (words[0].length() > 0) {
                sb.append(Character.toUpperCase(words[0].charAt(0)) + words[0].subSequence(1, words[0].length()).toString().toLowerCase());
                for (int i = 1; i < words.length; i++) {
                    sb.append(" ");
                    sb.append(Character.toUpperCase(words[i].charAt(0)) + words[i].subSequence(1, words[i].length()).toString().toLowerCase());
                }
            }
            String titleCaseValue = sb.toString();
            return titleCaseValue;
        } catch (Exception e) {
            return key;
        }
    }


}
