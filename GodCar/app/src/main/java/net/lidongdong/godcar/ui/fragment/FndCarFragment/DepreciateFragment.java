package net.lidongdong.godcar.ui.fragment.FndCarFragment;

import android.os.Bundle;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.ui.fragment.AbsBaseFragment;

/**
 * Created by dllo on 16/9/10.
 */
public class DepreciateFragment extends AbsBaseFragment {
    public static DepreciateFragment newInstance() {

        Bundle args = new Bundle();

        DepreciateFragment fragment = new DepreciateFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_depreciate;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }
}
