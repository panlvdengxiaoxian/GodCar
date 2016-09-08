package net.lidongdong.godcar.ui.activity;



import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.ui.fragment.ArticleFragment;
import net.lidongdong.godcar.ui.fragment.FindCarFragment;
import net.lidongdong.godcar.ui.fragment.FindFragment;
import net.lidongdong.godcar.ui.fragment.ForumFragment;
import net.lidongdong.godcar.ui.fragment.SettingFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AbsActivity{
    private TabLayout mainTl;
    private ViewPager mainVp;
    private List<Fragment> fragments;
    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        mainTl=byView(R.id.main_tl);
        mainVp=byView(R.id.main_vp);
    }

    @Override
    protected void initDatas() {
        fragments=new ArrayList<>();
        //给集合添加fragment
        fragments.add(new ArticleFragment());
        fragments.add(new FindFragment());
        fragments.add(new FindCarFragment());
        fragments.add(new ForumFragment());
        fragments.add(new SettingFragment());

        mainVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        mainTl.setupWithViewPager(mainVp);
        mainTl.getTabAt(0).setCustomView(R.layout.tab_fragment_article);
        mainTl.getTabAt(2).setCustomView(R.layout.tab_fragment_findcar);
        mainTl.getTabAt(3).setCustomView(R.layout.tab_fragment_find);
        mainTl.getTabAt(1).setCustomView(R.layout.tab_fragment_forum);
        mainTl.getTabAt(4).setCustomView(R.layout.tab_fragment_setting);

    }
}
