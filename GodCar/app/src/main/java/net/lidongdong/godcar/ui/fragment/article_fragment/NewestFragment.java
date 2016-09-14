package net.lidongdong.godcar.ui.fragment.article_fragment;

import android.os.Bundle;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.ui.fragment.AbsBaseFragment;

/**
 * Created by dllo on 16/9/9.
 */
public class NewestFragment extends AbsBaseFragment {
    public static NewestFragment newInstance() {

        Bundle args = new Bundle();

        NewestFragment fragment = new NewestFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_newest;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }
}
