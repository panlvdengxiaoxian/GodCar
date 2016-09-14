package net.lidongdong.godcar.ui.fragment.article_fragment;

import android.os.Bundle;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.ui.fragment.AbsBaseFragment;

/**
 * Created by dllo on 16/9/9.
 */
public class VideoFragment extends AbsBaseFragment {
    public static VideoFragment newInstance() {

        Bundle args = new Bundle();

        VideoFragment fragment = new VideoFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_video;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }
}
