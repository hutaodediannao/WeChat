package com.hutao.chunchun;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.hyphenate.easeui.EaseUI;

/**
 * Created by hutao on 2018-11-16.
 */

public class CcApplication extends Application {

    public static Context applicationContext;
    private static CcApplication instance;
    // login user name
    public final String PREF_USERNAME = "username";

    /**
     * nickname for current user, the nickname instead of ID be shown when user receive notification from APNs
     */
    public static String currentUserNick = "";

    @Override
    public void onCreate() {
        MultiDex.install(this);
        super.onCreate();
        applicationContext = this;
        instance = this;

        //init demo helper
        DemoHelper.getInstance().init(applicationContext);

        // 请确保环信SDK相关方法运行在主进程，子进程不会初始化环信SDK（该逻辑在EaseUI.java中）
        if (EaseUI.getInstance().isMainProcess(this)) {
            // 初始化华为 HMS 推送服务, 需要在SDK初始化后执行
            HMSPushHelper.getInstance().initHMSAgent(instance);
        }
    }

    public static CcApplication getInstance() {
        return instance;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
