package net.lidongdong.godcar.ui.fragment.article_fragment;

import android.os.Bundle;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.ui.fragment.AbsBaseFragment;

/**
 * Created by dllo on 16/9/9.
 */
public class UserCarFragment extends AbsBaseFragment {
    public static UserCarFragment newInstance() {

        Bundle args = new Bundle();

        UserCarFragment fragment = new UserCarFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_usercar;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }
}
