package com.kepler.brandde.support;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

/**
 * Created by 12 on 9/9/2016.
 */
public class CustomRequest {
    private static final int TIMEOUT = 90000;

    public static void callPostRequest(String url, RequestParams parems, SimpleNetworkHandler asyncHttpResponseHandler) {
        if (isNull(url, asyncHttpResponseHandler))
            return;
        AsyncHttpClient client = new AsyncHttpClient();
        client.setTimeout(TIMEOUT);
        Log.e("parems", parems.toString());
        client.post(url, parems, asyncHttpResponseHandler);
    }

    private static boolean isNull(String url, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        if (asyncHttpResponseHandler == null || url == null || url.trim().length() == 0)
            return true;
        return false;
    }
}
