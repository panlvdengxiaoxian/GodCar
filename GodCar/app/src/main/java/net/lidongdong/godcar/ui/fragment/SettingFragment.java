package net.lidongdong.godcar.ui.fragment;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.ui.activity.SearchActivity;

/**
 * Created by dllo on 16/9/8.
 */
public class SettingFragment extends AbsBaseFragment implements View.OnClickListener {
    private TextView titleFindTv;
    private ImageView searchImg;
    @Override
    protected int setLayout() {
        return R.layout.fragment_setting;

    }

    @Override
    protected void initViews() {
        titleFindTv=byView(R.id.title_find_tv);
        searchImg=byView(R.id.title_search_img);
        searchImg.setOnClickListener(this);
    }

    @Override
    protected void initDatas() {
       //标题栏设置(去掉发现)
        titleFindTv.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_search_img:
                goTo(SearchActivity.class);
                break;
        }
    }
}
