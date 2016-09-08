package net.lidongdong.godcar.utils;

import android.widget.Toast;

import net.lidongdong.godcar.ui.app.MyApp;

/**
 * Created by dllo on 16/9/8.
 * Toast的工具类
 * @author lidongdong
 * @time 2016-9-8
 * @version 1.0
 */
public final class T {
    //final修饰,不能继承
    //锁死这个类
    private T(){}
    private static boolean isDebug=true;

    public static void shortMsg(String msg){
        if (isDebug){
            Toast.makeText(MyApp.getContext(), msg, Toast.LENGTH_SHORT).show();
        }
    }
    public static void longMsg(String msg){
        if (isDebug){
            Toast.makeText(MyApp.getContext(), msg, Toast.LENGTH_LONG).show();
        }
    }
}
