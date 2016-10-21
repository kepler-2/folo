package com.kepler.brandde.support;

import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

/**
 * Created by 12 on 9/9/2016.
 */
public abstract class SimpleNetworkHandler extends AsyncHttpResponseHandler {

    public SimpleNetworkHandler() {

    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
        try {
            Logger.e(SimpleNetworkHandler.class, new String(responseBody));
            onResult(statusCode, headers, new String(responseBody));
        } catch (Exception e) {
            Logger.printTrash(e);
        }
    }

    public abstract void onResult(int statusCode, Header[] headers, Object responseBody);

    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
        try {
            Logger.e(SimpleNetworkHandler.class, new String(responseBody));
        } catch (Exception e) {
            Logger.printTrash(e);
        }
    }

}
