package net.lidongdong.godcar.ui.activity;


import android.view.View;
import android.widget.TextView;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.utils.T;

public class MainActivity extends AbsActivity{
   private TextView tv;
    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        tv=byView(R.id.tv);
    }

    @Override
    protected void initDatas() {
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                T.longMsg("自己的吐司");
            }
        });
    }
}
