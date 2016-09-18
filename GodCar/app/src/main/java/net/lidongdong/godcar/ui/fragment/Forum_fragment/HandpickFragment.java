package net.lidongdong.godcar.ui.fragment.Forum_fragment;


import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.ui.fragment.AbsBaseFragment;

public class HandpickFragment extends AbsBaseFragment {
  private RecyclerView handpickRv;
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
     handpickRv=byView(R.id.handpick_rv);
    }

    @Override
    protected void initDatas() {

    }
}