package net.lidongdong.godcar.ui.fragment.article_fragment;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.model.bean.UniHubBean;
import net.lidongdong.godcar.model.net.IVolleyResult;
import net.lidongdong.godcar.model.net.VolleyInstance;
import net.lidongdong.godcar.ui.adapter.UniHubAdapter;
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
 * Created by 潘驴邓小闲 on 16/9/12.
 * 优创fragment
 */
public class UniHubFragment extends AbsBaseFragment {
    private ListView listView;
    private UniHubAdapter adapter;

    public static UniHubFragment newInstance(String str) {

        Bundle args = new Bundle();
        args.putString("URL", str);
        UniHubFragment fragment = new UniHubFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_unihub;
    }

    @Override
    protected void initViews() {
        listView = byView(R.id.fragment_unihub_lv);
    }

    @Override
    protected void initDatas() {
        adapter = new UniHubAdapter(context);
        listView.setAdapter(adapter);
        Bundle bundle = getArguments();
        String UniHubFragmentURL = bundle.getString("URL");
        VolleyInstance.getInstance().startRequest(UniHubFragmentURL, new IVolleyResult() {
            @Override
            public void success(String str, int who) {

            }

            @Override
            public void success(String str) {
                Gson gson = new Gson();
                UniHubBean bean = gson.fromJson(str, UniHubBean.class);
                List<UniHubBean.ResultBean.NewslistBean> data = bean.getResult().getNewslist();
                adapter.setData(data);
            }

            @Override
            public void failure() {

            }
        });

    }
}