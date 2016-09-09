package net.lidongdong.godcar.ui.fragment;


import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.ui.fragment.article_fragment.BulletinFragment;
import net.lidongdong.godcar.ui.fragment.article_fragment.ChangeCarFragment;
import net.lidongdong.godcar.ui.fragment.article_fragment.EvaluationFragment;
import net.lidongdong.godcar.ui.fragment.article_fragment.NewestFragment;
import net.lidongdong.godcar.ui.fragment.article_fragment.NewsFragment;
import net.lidongdong.godcar.ui.fragment.article_fragment.TechnologyFragment;
import net.lidongdong.godcar.ui.fragment.article_fragment.UnihubFragment;
import net.lidongdong.godcar.ui.fragment.article_fragment.UserCarFragment;
import net.lidongdong.godcar.ui.fragment.article_fragment.VideoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/8.
 */
public class ArticleFragment extends AbsBaseFragment {

    private TabLayout articleTl;
    private ViewPager articleVp;
    private List<Fragment> fragments;

    @Override
    protected int setLayout() {
        return R.layout.fragment_article;
    }


    @Override
    protected void initViews() {
       articleTl=byView(R.id.article_tl);
        articleVp=byView(R.id.article_vp);
        fragments=new ArrayList<>();
        fragments.add(new NewestFragment());
        fragments.add(new UnihubFragment());
        fragments.add(new NewsFragment());
        fragments.add(new BulletinFragment());
        fragments.add(new EvaluationFragment());
        fragments.add(new ChangeCarFragment());
        fragments.add(new VideoFragment());
        fragments.add(new UserCarFragment());
        fragments.add(new TechnologyFragment());
        articleVp.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        articleTl.setupWithViewPager(articleVp);
        articleTl.getTabAt(0).setCustomView(R.layout.tab_newest);
        articleTl.getTabAt(1).setCustomView(R.layout.tab_unihub);
        articleTl.getTabAt(2).setCustomView(R.layout.tab_news);
        articleTl.getTabAt(3).setCustomView(R.layout.tab_bulletin);
        articleTl.getTabAt(4).setCustomView(R.layout.tab_evaluation);
        articleTl.getTabAt(5).setCustomView(R.layout.tab_changecar);
        articleTl.getTabAt(6).setCustomView(R.layout.tab_video);
        articleTl.getTabAt(7).setCustomView(R.layout.tab_usercar);
        articleTl.getTabAt(8).setCustomView(R.layout.tab_technology);


        articleTl.setTabMode(TabLayout.MODE_SCROLLABLE);

    }

    @Override
    protected void initDatas() {

    }


}
