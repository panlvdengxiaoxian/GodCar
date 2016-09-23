package net.lidongdong.godcar.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;


/**
 * Created by dllo on 16/9/8.
 * Activity的基类
 */
public abstract class AbsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //本应用不显示顶端的通知栏
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //定制流程
        setContentView(setLayout());
        //初始化组件
        initViews();
        //初始化数据
        initDatas();
    }
    /**
     * 设置布局文件
     * @return R.layout.xx
     */
    protected abstract  int setLayout();
    /**
     * 初始化组件
     */
    protected  abstract void initViews();

    /**
     * 初始化数据
     */
    protected  abstract void initDatas();
    /**
     *
     */
    protected <T extends View > T byView(int resId){
        return (T) findViewById(resId);
    }
    /**
     * 跳转不传值
     */
    protected  void goTo(Context from,Class<? extends AbsActivity> to){
        startActivity(new Intent(from,to));
    }
    /**
     * 跳转传值
     * Bundle:轻量级的存储类
     */
    protected  void goTo(Context from,Class<? extends AbsActivity> to,Bundle extras){
        Intent intent=new Intent(from,to);
        intent.putExtras(extras);
        startActivity(intent);
    }
    /**
     * Activity结束动画
     */
    @Override
    public void finish() {
        super.finish();
        //加一个动画
    }
}
