package net.lidongdong.godcar.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import net.lidongdong.godcar.R;

/**
 * Created by dllo on 16/9/10.
 */
public class SearchActivity extends AbsActivity implements View.OnClickListener {
    private TextView searchCancelTv;
    @Override
    protected int setLayout() {
        return R.layout.activity_search;

    }

    @Override
    protected void initViews() {
    searchCancelTv=byView(R.id.search_cancel_tv);
        searchCancelTv.setOnClickListener(this);
    }

    @Override
    protected void initDatas() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search_cancel_tv:
                goTo(SearchActivity.this,MainActivity.class);
        }
    }
}
