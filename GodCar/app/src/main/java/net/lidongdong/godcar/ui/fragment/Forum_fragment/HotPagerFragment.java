package net.lidongdong.godcar.ui.fragment.Forum_fragment;

import android.os.Bundle;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.ui.fragment.AbsBaseFragment;

/**
 * Created by dllo on 16/9/9.
 */
public class HotPagerFragment extends AbsBaseFragment{
    public static HotPagerFragment newInstance() {

        Bundle args = new Bundle();

        HotPagerFragment fragment = new HotPagerFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_hotpager;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }
}
