package net.lidongdong.godcar.ui.fragment;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.ui.fragment.Forum_fragment.CommonFragment;
import net.lidongdong.godcar.ui.fragment.Forum_fragment.HandpickFragment;
import net.lidongdong.godcar.ui.fragment.Forum_fragment.HotPagerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/8.
 */
public class ForumFragment extends AbsBaseFragment{
    private ViewPager forumVp;
    private TabLayout forumTl;
    private List<Fragment> fragments;
    @Override
    protected int setLayout() {
        return R.layout.fragment_forum;
    }



    @Override
    protected void initViews() {
       forumTl=byView(R.id.forum_tl);
        forumVp=byView(R.id.forum_vp);
        fragments=new ArrayList<>();
        fragments.add(new HandpickFragment());
        fragments.add(new HotPagerFragment());
        fragments.add(new CommonFragment());
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
    }

    @Override
    protected void initDatas() {

    }
}
