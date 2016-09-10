package net.lidongdong.godcar.ui.fragment;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.ui.fragment.FndCarFragment.BrandFragment;
import net.lidongdong.godcar.ui.fragment.FndCarFragment.ChooseFragment;
import net.lidongdong.godcar.ui.fragment.FndCarFragment.DepreciateFragment;
import net.lidongdong.godcar.ui.fragment.FndCarFragment.FindUesedCarFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/8.
 */
public class FindCarFragment extends AbsBaseFragment {
    private TabLayout findcarTl;
    private ViewPager findcarVp;
    private List<Fragment> fragments;

    @Override
    protected int setLayout() {
        return R.layout.fragment_findcar;
    }


    @Override
    protected void initViews() {
        findcarTl = byView(R.id.findCar_tl);
        findcarVp = byView(R.id.findCar_vp);
        fragments=new ArrayList<>();
        fragments.add(new BrandFragment());
        fragments.add(new ChooseFragment());
        fragments.add(new DepreciateFragment());
        fragments.add(new FindUesedCarFragment());
        findcarVp.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        findcarTl.setupWithViewPager(findcarVp);
        findcarTl.getTabAt(0).setCustomView(R.layout.tab_brand);
        findcarTl.getTabAt(1).setCustomView(R.layout.tab_choose);
        findcarTl.getTabAt(2).setCustomView(R.layout.tab_depreciate);
        findcarTl.getTabAt(3).setCustomView(R.layout.tab_findusedcar);

    }

    @Override
    protected void initDatas() {

    }
}
