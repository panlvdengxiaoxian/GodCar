package net.lidongdong.godcar.ui.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by dllo on 16/9/8.
 * 当期应用 只能有一个
 * Context 环境
 *
 * 要记得在清单文件注册
 *
 */

public class MyApp extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }

}
