package net.lidongdong.godcar.ui.fragment.Forum_fragment;

import android.os.Bundle;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.ui.fragment.AbsBaseFragment;

/**
 * Created by dllo on 16/9/9.
 * 常用论坛
 */
public class CommonFragment extends AbsBaseFragment {
    public static CommonFragment newInstance() {

        Bundle args = new Bundle();

        CommonFragment fragment = new CommonFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_common;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }
}
