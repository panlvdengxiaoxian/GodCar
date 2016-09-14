package net.lidongdong.godcar.ui.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.ui.activity.SearchActivity;
import net.lidongdong.godcar.ui.fragment.FndCarFragment.BrandFragment;
import net.lidongdong.godcar.ui.fragment.FndCarFragment.ChooseFragment;
import net.lidongdong.godcar.ui.fragment.FndCarFragment.DepreciateFragment;
import net.lidongdong.godcar.ui.fragment.FndCarFragment.FindUesedCarFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/8.
 */
public class FindCarFragment extends AbsBaseFragment implements View.OnClickListener {
    private TabLayout findcarTl;
    private ViewPager findcarVp;
    private List<Fragment> fragments;
//     private TextView findCarAreaTv;
    private ImageView findCarSearchImg;
    @Override
    protected int setLayout() {
        return R.layout.fragment_findcar;
    }

    public static FindCarFragment newInstance() {

        Bundle args = new Bundle();

        FindCarFragment fragment = new FindCarFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected void initViews() {
        findcarTl = byView(R.id.findCar_tl);
        findcarVp = byView(R.id.findCar_vp);
//        findCarAreaTv=byView(R.id.findCar_area_tv);
        findCarSearchImg=byView(R.id.findCar_search_img);
        findCarSearchImg.setOnClickListener(this);
//        findCarAreaTv.setOnClickListener(this);
        fragments=new ArrayList<>();
        fragments.add(BrandFragment.newInstance());
        fragments.add(ChooseFragment.newInstance());
        fragments.add(DepreciateFragment.newInstance());
        fragments.add(FindUesedCarFragment.newInstance());
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.findCar_search_img:
                goTo(SearchActivity.class);
                break;
        }
    }
}
