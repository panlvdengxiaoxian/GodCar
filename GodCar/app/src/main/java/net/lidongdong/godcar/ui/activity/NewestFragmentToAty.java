package net.lidongdong.godcar.ui.activity;

import android.content.Intent;
import android.widget.TextView;

import net.lidongdong.godcar.R;

/**
 * Created by 潘驴邓小娴 on 2016/9/23.
 * 最新详情页
 */
public class NewestFragmentToAty extends AbsActivity {
    private TextView titleTv;

    @Override
    protected int setLayout() {
        return R.layout.activity_from_fragment;
    }

    @Override
    protected void initViews() {
        titleTv = byView(R.id.newFragmentToAty_titleTv);
    }


    @Override
    protected void initDatas() {
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        titleTv.setText(title);
    }
}
