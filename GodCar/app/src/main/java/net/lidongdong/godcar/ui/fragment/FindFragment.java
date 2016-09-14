package net.lidongdong.godcar.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.ui.activity.SearchActivity;

/**
 * Created by dllo on 16/9/8.
 */
public class FindFragment extends AbsBaseFragment implements View.OnClickListener {
    private TextView titlemeTv;
    private ImageView searchImg;
    @Override
    protected int setLayout() {
        return R.layout.fragment_find;
    }

    public static FindFragment newInstance() {

        Bundle args = new Bundle();

        FindFragment fragment = new FindFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initViews() {
     titlemeTv=byView(R.id.title_me_tv);
        searchImg=byView(R.id.title_search_img);
        searchImg.setOnClickListener(this);
    }

    @Override
    protected void initDatas() {
      titlemeTv.setVisibility(View.GONE);



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
