package net.lidongdong.godcar.ui.fragment.article_fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.wevey.selector.dialog.DialogOnItemClickListener;
import com.wevey.selector.dialog.NormalSelectionDialog;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.ui.fragment.AbsBaseFragment;

import java.util.ArrayList;

/**
 * Created by dllo on 16/9/9.
 * 推荐界面的优创
 */
public class UnihubFragment extends AbsBaseFragment implements View.OnClickListener {
    private RelativeLayout unihubRl;

    public static UnihubFragment newInstance() {

        Bundle args = new Bundle();

        UnihubFragment fragment = new UnihubFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_unihub;
    }

    @Override
    protected void initViews() {
        unihubRl = byView(R.id.unihub_popwindow_rl);
        unihubRl.setOnClickListener(this);
    }

    @Override
    protected void initDatas() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.unihub_popwindow_rl:
                popWindow();
                break;
        }
    }

    private void popWindow() {
        NormalSelectionDialog dialog= new NormalSelectionDialog.Builder(context)
                .setlTitleVisible(true)   //设置是否显示标题
                .setTitleHeight(65)   //设置标题高度
                .setTitleText("please select")  //设置标题提示文本
                .setTitleTextSize(14) //设置标题字体大小 sp
                .setTitleTextColor(R.color.colorPrimary) //设置标题文本颜色
                .setItemHeight(40)  //设置item的高度
                .setItemWidth(0.9f)  //屏幕宽度*0.9
                .setItemTextColor(R.color.colorPrimaryDark)  //设置item字体颜色
                .setItemTextSize(14)  //设置item字体大小
                .setCancleButtonText("取消")  //设置最底部“取消”按钮文本
                .setOnItemListener(new DialogOnItemClickListener() {  //监听item点击事件
                    @Override
                    public void onItemClick(Button button, int position) {
//                                dialog1.dismiss();
//                              Toast.makeText(context, s.get(position), Toast.LENGTH_SHORT).show();


                    }
                })
                .setCanceledOnTouchOutside(true)  //设置是否可点击其他地方取消dialog
                .build();
        ArrayList<String> s = new ArrayList<>();
        s.add("Weavey0");
        s.add("Weavey1");
        s.add("Weavey2");
        s.add("Weavey3");
        dialog.setDataList(s);
    }
}



