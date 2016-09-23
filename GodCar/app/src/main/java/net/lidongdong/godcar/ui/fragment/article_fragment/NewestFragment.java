package net.lidongdong.godcar.ui.fragment.article_fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.model.bean.NewFragmentRoateBean;
import net.lidongdong.godcar.model.bean.NewestBean;
import net.lidongdong.godcar.ui.activity.NewestFragmentToAty;
import net.lidongdong.godcar.ui.adapter.NewestAdapter;
import net.lidongdong.godcar.ui.adapter.NewestHandAdapter;
import net.lidongdong.godcar.ui.app.MyApp;
import net.lidongdong.godcar.ui.fragment.AbsBaseFragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.util.Log;
import android.widget.AdapterView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

/**
 * Created by ccc on 16/9/13.
 * 推荐界面的最新页面
 */
public class NewestFragment extends AbsBaseFragment {
    private static final int TIME = 3000;
    private ListView lv;
    private NewestAdapter adapter;
    private ViewPager newFragmentVp;
    private LinearLayout pointLl;//轮播图状态改变的小圆点
    private List<NewFragmentRoateBean> data;
    private NewestHandAdapter vpAadpter;

    public static NewestFragment newInstance(String string) {

        Bundle args = new Bundle();
        args.putString("URL", string);
        NewestFragment fragment = new NewestFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_newest;
    }

    @Override
    protected void initViews() {
        lv = byView(R.id.fragment_newest_lv);
    }


    @Override
    protected void initDatas() {
        adapter = new NewestAdapter(context);
        lv.setAdapter(adapter);
        Bundle bundle = getArguments();
        String NewFragmentUrl = bundle.getString("URL");
        RequestQueue queue = Volley.newRequestQueue(MyApp.getContext());
        StringRequest sr = new StringRequest(NewFragmentUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("1111", response);
                Gson gson = new Gson();
                NewestBean bean = gson.fromJson(response, NewestBean.class);
                Log.d("1111", "bean:" + bean);
                List<NewestBean.ResultBean.NewslistBean> datas = bean.getResult().getNewslist();
                adapter.setData(datas);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(sr);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NewestBean.ResultBean.NewslistBean bean = (NewestBean.ResultBean.NewslistBean) parent.getItemAtPosition(position);
                String title = bean.getTitle();
                Intent intent = new Intent(getContext(), NewestFragmentToAty.class);
                intent.putExtra("title", title);
                startActivity(intent);
            }
        });
        //头布局
        View headView = LayoutInflater.from(context).inflate(R.layout.item_newest_head, null);
        newFragmentVp = (ViewPager) headView.findViewById(R.id.new_fragment_rotate_vp);
        pointLl = (LinearLayout) headView.findViewById(R.id.new_fragemnt_rotate_point_container);
        builDatas();
        vpAadpter = new NewestHandAdapter(data, getContext());
        newFragmentVp.setAdapter(vpAadpter);
        vpAadpter.setDatas(data);
        newFragmentVp.setCurrentItem(data.size() * 100);
        //开始轮播
        handler = new Handler();
        startRotate();
        //添加小圆点
        addPoints();
        //随着轮播改变小点
        changePoints();
        lv.addHeaderView(headView);
    }

    private void changePoints() {
        newFragmentVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (isRotate) {
                    // 把所有小点设置为白色
                    for (int i = 0; i < data.size(); i++) {
                        ImageView pointIv = (ImageView) pointLl.getChildAt(i);
                        pointIv.setImageResource(R.mipmap.point_white);
                    }
                    // 设置当前位置小点为灰色
                    ImageView iv = (ImageView) pointLl.getChildAt(position % data.size());
                    iv.setImageResource(R.mipmap.point_grey);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void addPoints() {
        // 有多少张图加载多少个小点
        for (int i = 0; i < data.size(); i++) {
            ImageView pointIv = new ImageView(getContext());
            pointIv.setPadding(5, 5, 5, 5);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20, 20);
            pointIv.setLayoutParams(params);

            // 设置第0页小点的为灰色
            if (i == 0) {
                pointIv.setImageResource(R.mipmap.point_grey);
            } else {
                pointIv.setImageResource(R.mipmap.point_white);
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
                int nowIndex = newFragmentVp.getCurrentItem();
                newFragmentVp.setCurrentItem(++nowIndex);
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

    private void builDatas() {
        data = new ArrayList<>();
        data.add(new NewFragmentRoateBean("http://www3.autoimg.cn/newsdfs/g16/M09/4C/16/640x320_0_autohomecar__wKgH11ff_siAT39EAAb11cjL4MY067.jpg"));
        data.add(new NewFragmentRoateBean("http://www3.autoimg.cn/newsdfs/g6/M13/4C/41/640x320_0_autohomecar__wKjB0VffV46AVS3xAAr_7RZVkJo343.jpg"));
        data.add(new NewFragmentRoateBean("http://www2.autoimg.cn/newsdfs/g18/M01/48/51/640x320_0_autohomecar__wKgH2VfdXsOAENBxAAHlhJ5YO-I087.jpg"));
        data.add(new NewFragmentRoateBean("http://www2.autoimg.cn/newsdfs/g17/M13/45/3D/640x320_0_autohomecar__wKgH2FfeYnWAAOUJAALmvKVjQsI150.jpg"));
        data.add(new NewFragmentRoateBean("http://www3.autoimg.cn/newsdfs/g17/M09/47/9E/640x320_0_autohomecar__wKgH51feKYCAQ02oAAhFNzn7tVU182.jpg"));
        data.add(new NewFragmentRoateBean("http://www3.autoimg.cn/newsdfs/g17/M06/48/EB/640x320_0_autohomecar__wKgH51ffQBSASzHZAAfasiEN3g4753.jpg"));
    }

}
