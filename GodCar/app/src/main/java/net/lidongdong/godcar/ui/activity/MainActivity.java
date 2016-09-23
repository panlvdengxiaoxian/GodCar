package net.lidongdong.godcar.ui.activity;


import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.ui.fragment.ArticleFragment;
import net.lidongdong.godcar.ui.fragment.FindCarFragment;
import net.lidongdong.godcar.ui.fragment.FindFragment;
import net.lidongdong.godcar.ui.fragment.ForumFragment;
import net.lidongdong.godcar.ui.fragment.SettingFragment;


public class MainActivity extends AbsActivity implements View.OnClickListener {
    private RadioGroup mainRg;
    private FrameLayout mainFl;
    private RadioButton articleRb, forumRb, findCarRb, findRb, settingRb;
    private static boolean isExit=false;

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        mainRg = byView(R.id.main_rg);
        mainFl = byView(R.id.main_fl);
        articleRb = byView(R.id.article_rb);
        forumRb = byView(R.id.forum_rb);
        findCarRb = byView(R.id.findcar_rb);
        settingRb = byView(R.id.setting_rb);
        findRb = byView(R.id.find_rb);

        articleRb.setOnClickListener(this);
        forumRb.setOnClickListener(this);
        settingRb.setOnClickListener(this);
        findCarRb.setOnClickListener(this);
        findRb.setOnClickListener(this);

    }
    @Override
    protected void initDatas() {
         //显示默认页
        FragmentTransaction ft;
        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_fl, ArticleFragment.newInstance());
        ft.commit();
        articleRb.setChecked(true);
        mainRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction ft;
                ft=getSupportFragmentManager().beginTransaction();
                switch (checkedId){
                    case R.id.article_rb:
                        ft.replace(R.id.main_fl, ArticleFragment.newInstance());
                        ft.commit();
                        break;
                    case R.id.forum_rb:
                        ft.replace(R.id.main_fl,  ForumFragment.newInstance());
                        ft.commit();
                        break;
                    case R.id.findcar_rb:
                        ft.replace(R.id.main_fl,  FindCarFragment.newInstance());
                        ft.commit();
                        break;
                    case R.id.find_rb:
                        ft.replace(R.id.main_fl,  FindFragment.newInstance());
                        ft.commit();
                        break;
                    case R.id.setting_rb:
                        ft.replace(R.id.main_fl, SettingFragment.newInstance());
                        ft.commit();
                        break;
                    default:
                        ft.replace(R.id.main_fl, ArticleFragment.newInstance());
                        ft.commit();
                        break;
                }
            }
        });


    }
    Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit=false;
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            exit();
        }
        return false;
    }

    private void exit() {
        if (!isExit){
            isExit=true;
            Toast.makeText(this, "再一次退出程序", Toast.LENGTH_SHORT).show();
            //利用handler来延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed(0,2000);
        }else {
            finish();
//            System.exit(0);
        }
    }

    @Override
    public void onClick(View v) {

    }
}
