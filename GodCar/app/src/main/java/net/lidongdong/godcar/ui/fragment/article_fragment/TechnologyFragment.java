package net.lidongdong.godcar.ui.fragment.article_fragment;

import android.os.Bundle;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.ui.fragment.AbsBaseFragment;

/**
 * Created by dllo on 16/9/9.
 */
public class TechnologyFragment extends AbsBaseFragment {
    public static TechnologyFragment newInstance() {

        Bundle args = new Bundle();

        TechnologyFragment fragment = new TechnologyFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_technology;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }
}
