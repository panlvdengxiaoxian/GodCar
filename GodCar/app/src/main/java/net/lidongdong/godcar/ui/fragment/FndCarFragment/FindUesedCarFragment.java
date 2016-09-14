package net.lidongdong.godcar.ui.fragment.FndCarFragment;

import android.os.Bundle;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.ui.fragment.AbsBaseFragment;

/**
 * Created by dllo on 16/9/10.
 */
public class FindUesedCarFragment extends AbsBaseFragment {
    public static FindUesedCarFragment newInstance() {

        Bundle args = new Bundle();

        FindUesedCarFragment fragment = new FindUesedCarFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_findusedcar;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }
}
