package net.lidongdong.godcar.ui.fragment.article_fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.model.bean.NewestHandBean;
import net.lidongdong.godcar.ui.adapter.NewestAdapter;
import net.lidongdong.godcar.ui.adapter.NewestHandAdapter;
import net.lidongdong.godcar.ui.fragment.AbsBaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/9.
 * 推荐界面的最新
 */
public class NewestFragment extends AbsBaseFragment {
//    private ListView listView;
//    private NewestAdapter newestAdapter;
    /**
     * 轮播图相关
     */
    private static final int TIME = 3000;
    private ViewPager viewPager;
    private LinearLayout pointLl;//轮播状态改变的小圆点容器
    private List<NewestHandBean> datas;
    private NewestHandAdapter vpAdapter;

    public static NewestFragment newInstance() {

        Bundle args = new Bundle();
        NewestFragment fragment = new NewestFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.hand_newest;
    }

    @Override
    protected void initViews() {
        viewPager = byView(R.id.rotate_vp);
        pointLl = byView(R.id.rotate_point_container);

//        newestAdapter = new NewestAdapter(context);
//        listView.setAdapter(newestAdapter);

        vpAdapter = new NewestHandAdapter(datas, context);
        viewPager.setAdapter(vpAdapter);
        viewPager.setCurrentItem(datas.size() * 10);
        handler = new Handler();

//        listView = byView(R.id.newest_lv);
//        View view = LayoutInflater.from(context).inflate(R.layout.item_newest_hand, null);
//        TextView headerTv = byView(R.id.item_newest_hand_tv);
//        headerTv.setText("这是一个轮播图");
//        listView.addHeaderView(view);
    }

    @Override
    protected void initDatas() {
        buildDatas();//处理数据
        startRotate();//添加轮播小点
        addPoints();//随着轮播改变小点
        changePoints();


    }

    private void changePoints() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (isRotate) {
                    //把所有小白点都设为白色
                    for (int i = 0; i < datas.size(); i++) {
                        ImageView pointIv = (ImageView) pointLl.getChildAt(i);
                        pointIv.setImageResource(R.mipmap.dog);

                    }
                    //设置当前位置小点为灰色
                    ImageView iv = (ImageView) pointLl.getChildAt(position % datas.size());
                    iv.setImageResource(R.mipmap.nvjing);

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void addPoints() {
        for (int i = 0; i < datas.size(); i++) {
            ImageView pointIv = new ImageView(context);
            pointIv.setPadding(5, 5, 5, 5);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20, 20);
            pointIv.setLayoutParams(params);
            //设置第0页的小点为灰色
            if (i == 0) {
                pointIv.setImageResource(R.mipmap.dog);

            } else {
                pointIv.setImageResource(R.mipmap.nvjing);
            }
            pointLl.addView(pointIv);
        }
    }

    private Handler handler;
    private boolean isRotate = false;
    private Runnable rotateRunnable;

    /**
     * 开始轮播
     */
    private void startRotate() {
        rotateRunnable = new Runnable() {
            @Override
            public void run() {
                int nowIndex = viewPager.getCurrentItem();
                viewPager.setCurrentItem(++nowIndex);
                if (isRotate) {
                    handler.postDelayed(rotateRunnable, TIME);
                }
            }
        };
        handler.postDelayed(rotateRunnable, TIME);
    }

    @Override
    public void onResume() {
        super.onResume();
        isRotate = true;
    }

    @Override
    public void onPause() {
        super.onPause();
        isRotate = false;
    }

    private void buildDatas() {
        datas = new ArrayList<>();
        datas.add(new NewestHandBean(R.mipmap.nvjing));
        datas.add(new NewestHandBean(R.mipmap.dog));
        datas.add(new NewestHandBean(R.mipmap.nvjing));
        datas.add(new NewestHandBean(R.mipmap.dog));

    }


}
