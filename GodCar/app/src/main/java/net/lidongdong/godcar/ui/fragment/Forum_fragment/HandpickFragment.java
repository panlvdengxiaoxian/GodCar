package net.lidongdong.godcar.ui.fragment.Forum_fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

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
    private TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9;
    private HorizontalScrollView handpickHs;
    private FrameLayout handpickFl;

    @Override
    protected int setLayout() {
        return R.layout.fragment_handpick;
    }

    @Override
    protected void initViews() {

        tv1=byView(R.id.tv1);
        tv2=byView(R.id.tv2);
        tv3=byView(R.id.tv3);
        tv4=byView(R.id.tv4);
        tv5=byView(R.id.tv5);
        tv6=byView(R.id.tv6);
        tv7=byView(R.id.tv7);
        tv8=byView(R.id.tv8);
        tv9=byView(R.id.tv9);

        handpickFl=byView(R.id.handpick_fl);
        handpickHs=byView(R.id.handpick_hs);

        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        tv4.setOnClickListener(this);
        tv5.setOnClickListener(this);
        tv6.setOnClickListener(this);
        tv7.setOnClickListener(this);
        tv8.setOnClickListener(this);
        tv9.setOnClickListener(this);




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
            case R.id.tv1:
                ft.replace(R.id.handpick_fl,new WifeForModelFragment());
                ft.commit();
                break;
            case R.id.tv2:
                ft.replace(R.id.handpick_fl,new ForumHotManFragment());
                ft.commit();
                break;
            case R.id.tv3:
                ft.replace(R.id.handpick_fl,new BeutiGirllFragment());
                ft.commit();
                break;
            case R.id.tv4:
                ft.replace(R.id.handpick_fl,new TextFragment());
                ft.commit();
                break;
            case R.id.tv5:
                ft.replace(R.id.handpick_fl,new TextFragment());
                ft.commit();
                break;
            case R.id.tv6:
                ft.replace(R.id.handpick_fl,new TextFragment());
                ft.commit();
                break;
            case R.id.tv7:
                ft.replace(R.id.handpick_fl,new TextFragment());
                ft.commit();
                break;
            case R.id.tv8:
                ft.replace(R.id.handpick_fl,new TextFragment());
                ft.commit();
                break;
            case R.id.tv9:
                ft.replace(R.id.handpick_fl,new TextFragment());
                ft.commit();
                break;
        }
    }
}
