package net.lidongdong.godcar.ui.activity;


import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

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
        FragmentTransaction ft;
        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_fl, new ArticleFragment());
        ft.commit();

    }

    @Override
    public void onClick(View v) {
        FragmentTransaction ft;
        ft = getSupportFragmentManager().beginTransaction();
        switch (v.getId()) {
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
                break;
        }
    }
}
