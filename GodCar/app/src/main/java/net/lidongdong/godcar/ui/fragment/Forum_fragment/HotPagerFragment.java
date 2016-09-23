package net.lidongdong.godcar.ui.fragment.Forum_fragment;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.model.bean.HotPagerBean;
import net.lidongdong.godcar.model.net.WebVelues;
import net.lidongdong.godcar.ui.adapter.HotpagerAdapter;
import net.lidongdong.godcar.ui.app.MyApp;
import net.lidongdong.godcar.ui.fragment.AbsBaseFragment;


import android.os.Bundle;
import android.widget.ListView;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by dllo on 16/9/12.
 * 热帖页
 */


public class HotPagerFragment extends AbsBaseFragment {
    public static HotPagerFragment newInstance() {
        
        Bundle args = new Bundle();
        
        HotPagerFragment fragment = new HotPagerFragment();
        fragment.setArguments(args);
        return fragment;
    }
    private ListView listView;
    private HotpagerAdapter adapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_hotpager;
    }

    @Override
    protected void initViews() {
        listView = byView(R.id.hot_topic_listView);
    }

    @Override
    protected void initDatas() {
        adapter = new HotpagerAdapter(context);
        listView.setAdapter(adapter);
        RequestQueue requestQueue = Volley.newRequestQueue(MyApp.getContext());
        StringRequest stringRequest = new StringRequest(WebVelues.HOTPAGER, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                HotPagerBean bean = gson.fromJson(response, HotPagerBean.class);
                List<HotPagerBean.ResultBean.ListBean> data = bean.getResult().getList();
                adapter.setData(data);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);

    }
}
