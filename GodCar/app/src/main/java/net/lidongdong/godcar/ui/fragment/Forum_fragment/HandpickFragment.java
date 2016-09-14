package net.lidongdong.godcar.ui.fragment.Forum_fragment;


import android.os.Bundle;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.ui.fragment.AbsBaseFragment;

public class HandpickFragment extends AbsBaseFragment {

    public static HandpickFragment newInstance() {

        Bundle args = new Bundle();

        HandpickFragment fragment = new HandpickFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_handpick;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }
}