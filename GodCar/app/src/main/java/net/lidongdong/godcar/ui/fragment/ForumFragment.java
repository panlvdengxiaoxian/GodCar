package net.lidongdong.godcar.ui.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.model.net.WebVelues;
import net.lidongdong.godcar.ui.activity.SearchActivity;
import net.lidongdong.godcar.ui.fragment.Forum_fragment.CommonFragment;
import net.lidongdong.godcar.ui.fragment.Forum_fragment.HandpickFragment;
import net.lidongdong.godcar.ui.fragment.Forum_fragment.HotPagerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/8.
 * 论坛
 */
public class ForumFragment extends AbsBaseFragment implements View.OnClickListener {
    private ViewPager forumVp;
    private TabLayout forumTl;
    private List<Fragment> fragments;
    private ImageView forumSearchImg;
    @Override
    protected int setLayout() {
        return R.layout.fragment_forum;
    }

    public static ForumFragment newInstance() {

        Bundle args = new Bundle();

        ForumFragment fragment = new ForumFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected void initViews() {
       forumTl=byView(R.id.forum_tl);
        forumVp=byView(R.id.forum_vp);
        forumSearchImg=byView(R.id.forum_search_img);
        forumSearchImg.setOnClickListener(this);
        fragments=new ArrayList<>();
        fragments.add(HandpickFragment.newInstance());
        fragments.add(HotPagerFragment.newInstance(WebVelues.HOTPAGER));
        fragments.add(CommonFragment.newInstance());
        forumVp.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        forumTl.setupWithViewPager(forumVp);
        forumTl.getTabAt(0).setCustomView(R.layout.tab_handpick);
        forumTl.getTabAt(1).setCustomView(R.layout.tab_hotpager);
        forumTl.getTabAt(2).setCustomView(R.layout.tab_common);
        forumVp.setCurrentItem(0);
    }

    @Override
    protected void initDatas() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.forum_search_img:
                goTo(SearchActivity.class);
                break;
        }
    }
}
