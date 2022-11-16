package com.wangzs.android.bluetoothdemo;

import android.app.Application;

/**
 * @Description $
 * @Date 2022/11/16 下午4:06
 * @Created by wangzs
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SimpleAudioManager.init(this);
    }
}
