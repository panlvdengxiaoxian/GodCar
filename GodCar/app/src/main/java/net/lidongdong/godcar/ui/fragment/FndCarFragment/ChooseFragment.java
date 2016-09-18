package net.lidongdong.godcar.ui.fragment.FndCarFragment;

import android.os.Bundle;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.ui.fragment.AbsBaseFragment;

/**
 * Created by dllo on 16/9/10.
 */
public class ChooseFragment extends AbsBaseFragment {
    public static ChooseFragment newInstance() {

        Bundle args = new Bundle();

        ChooseFragment fragment = new ChooseFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_choose;

    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }
}
