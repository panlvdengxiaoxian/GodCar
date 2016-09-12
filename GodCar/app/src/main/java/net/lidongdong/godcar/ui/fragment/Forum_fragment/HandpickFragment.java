package net.lidongdong.godcar.ui.fragment.Forum_fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.ui.fragment.AbsBaseFragment;
import net.lidongdong.godcar.ui.fragment.Forum_fragment.handpick_fragment.BeutiGirllFragment;
import net.lidongdong.godcar.ui.fragment.Forum_fragment.handpick_fragment.ForumHotManFragment;
import net.lidongdong.godcar.ui.fragment.Forum_fragment.handpick_fragment.TextFragment;
import net.lidongdong.godcar.ui.fragment.Forum_fragment.handpick_fragment.WifeForModelFragment;


/**
 * Created by dllo on 16/9/9.
 */
public class HandpickFragment extends AbsBaseFragment implements View.OnClickListener {

    private RadioButton rb1,rb2,rb3,rb4,rb5,rb6,rb7,rb8,rb9;
    private FrameLayout handpickFl;

    @Override
    protected int setLayout() {
        return R.layout.fragment_handpick;
    }

    @Override
    protected void initViews() {

        rb1=byView(R.id.rb1);
        rb2=byView(R.id.rb2);
        rb3=byView(R.id.rb3);
        rb4=byView(R.id.rb4);
        rb5=byView(R.id.rb5);
        rb6=byView(R.id.rb6);
        rb7=byView(R.id.rb7);
        rb8=byView(R.id.rb8);
        rb9=byView(R.id.rb9);

        handpickFl=byView(R.id.handpick_fl);

        rb1.setOnClickListener(this);
        rb2.setOnClickListener(this);
        rb3.setOnClickListener(this);
        rb4.setOnClickListener(this);
        rb5.setOnClickListener(this);
        rb6.setOnClickListener(this);
        rb7.setOnClickListener(this);
        rb8.setOnClickListener(this);
        rb9.setOnClickListener(this);
    }

    @Override
    protected void initDatas() {
        FragmentTransaction ft;
        ft=getFragmentManager().beginTransaction();
        ft.replace(R.id.handpick_fl,new TextFragment());
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction ft;
        ft=getFragmentManager().beginTransaction();
        switch (v.getId()){
            case R.id.rb1:
                ft.replace(R.id.handpick_fl,new WifeForModelFragment());
                ft.commit();
                break;
            case R.id.rb2:
                ft.replace(R.id.handpick_fl,new ForumHotManFragment());
                ft.commit();
                break;
            case R.id.rb3:
                ft.replace(R.id.handpick_fl,new BeutiGirllFragment());
                ft.commit();
                break;
            case R.id.rb4:
                ft.replace(R.id.handpick_fl,new TextFragment());
                ft.commit();
                break;
            case R.id.rb5:
                ft.replace(R.id.handpick_fl,new TextFragment());
                ft.commit();
                break;
            case R.id.rb6:
                ft.replace(R.id.handpick_fl,new TextFragment());
                ft.commit();
                break;
            case R.id.rb7:
                ft.replace(R.id.handpick_fl,new TextFragment());
                ft.commit();
                break;
            case R.id.rb8:
                ft.replace(R.id.handpick_fl,new TextFragment());
                ft.commit();
                break;
            case R.id.rb9:
                ft.replace(R.id.handpick_fl,new TextFragment());
                ft.commit();
                break;
        }
    }
}
