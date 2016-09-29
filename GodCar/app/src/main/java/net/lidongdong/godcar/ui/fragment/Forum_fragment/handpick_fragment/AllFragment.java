package net.lidongdong.godcar.ui.fragment.Forum_fragment.handpick_fragment;


import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.model.bean.AllBean;
import net.lidongdong.godcar.model.net.IVolleyResult;
import net.lidongdong.godcar.model.net.VolleyInstance;
import net.lidongdong.godcar.ui.adapter.AllAdapter;
import net.lidongdong.godcar.ui.app.MyApp;
import net.lidongdong.godcar.ui.fragment.AbsBaseFragment;

import java.util.List;

/**
 * Created by 潘驴邓小娴 on 2016/9/20.
 * 论坛精选通用fragment
 */

public class AllFragment extends AbsBaseFragment {
    private ListView listView;
    private AllAdapter adapter;

    public static AllFragment newInstance(String str) {

        Bundle args = new Bundle();
        args.putString("URL", str);
        AllFragment fragment = new AllFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_all;
    }

    @Override
    protected void initViews() {
        listView = byView(R.id.fragment_all_lv);
    }


    @Override
    protected void initDatas() {
        adapter = new AllAdapter(context);
        listView.setAdapter(adapter);
        Bundle bundle = getArguments();
        String theUrl = bundle.getString("URL");
        VolleyInstance.getInstance().startRequest(theUrl, new IVolleyResult() {
            @Override
            public void success(String str, int who) {

            }

            @Override
            public void success(String str) {
                Gson gson = new Gson();
                AllBean bean = gson.fromJson(str, AllBean.class);
                List<AllBean.ResultBean.ListBean> data = bean.getResult().getList();
                adapter.setDatas(data);
            }

            @Override
            public void failure() {

            }
        });

    }
}

