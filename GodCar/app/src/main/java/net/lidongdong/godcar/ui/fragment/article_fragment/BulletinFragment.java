package net.lidongdong.godcar.ui.fragment.article_fragment;

import android.os.Bundle;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.ui.fragment.AbsBaseFragment;

/**
 * Created by dllo on 16/9/9.
 * 推荐界面的快报
 */
public class BulletinFragment extends AbsBaseFragment {
    public static BulletinFragment newInstance() {

        Bundle args = new Bundle();

        BulletinFragment fragment = new BulletinFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_bulletin;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }
}
