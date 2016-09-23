package net.lidongdong.godcar.utils;


import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import net.lidongdong.godcar.ui.app.MyApp;

/**
 * Created by 潘驴邓小娴 on 2016/9/23.
 * 管理屏幕尺寸的工具类
 */

public class ScreenSize {
    public static int getHight(Context context) {
        //获取窗口管理者
        WindowManager manager = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);
        //创建显示尺寸类
        DisplayMetrics metrics = new DisplayMetrics();
        //将窗口的尺寸设置给显示尺寸类
        manager.getDefaultDisplay().getMetrics(metrics);
        //返回屏幕宽度
        return metrics.heightPixels;
    }

    public enum screenState {
        WIDTH, HEIGHT
    }

    public static int getScreenSize(screenState state) {
        //获取窗口管理者
        WindowManager manager = (WindowManager) MyApp.getContext().getSystemService(MyApp.getContext().WINDOW_SERVICE);
        //创建显示尺寸类
        DisplayMetrics metrics = new DisplayMetrics();
        //将窗口的尺寸设置给显示的尺寸类
        manager.getDefaultDisplay().getMetrics(metrics);
        if (state.equals(screenState.HEIGHT)) {
            return metrics.heightPixels;
        } else {
            return metrics.widthPixels;
        }
    }
}

