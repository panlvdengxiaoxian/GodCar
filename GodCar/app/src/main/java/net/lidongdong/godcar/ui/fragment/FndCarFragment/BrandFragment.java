package net.lidongdong.godcar.ui.fragment.FndCarFragment;

import android.os.Bundle;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.ui.fragment.AbsBaseFragment;

/**
 * Created by dllo on 16/9/10.
 */
public class BrandFragment extends AbsBaseFragment {
    public static BrandFragment newInstance() {

        Bundle args = new Bundle();

        BrandFragment fragment = new BrandFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_brand;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }
}
