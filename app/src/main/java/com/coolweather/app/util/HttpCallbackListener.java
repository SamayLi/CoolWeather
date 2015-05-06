package com.coolweather.app.util;

/**
 * Created by dysis on 2015/5/6.
 */
public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
