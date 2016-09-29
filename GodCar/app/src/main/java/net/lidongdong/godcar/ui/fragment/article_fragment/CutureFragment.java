package net.lidongdong.godcar.ui.fragment.article_fragment;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.model.bean.CultureBean;
import net.lidongdong.godcar.model.net.IVolleyResult;
import net.lidongdong.godcar.model.net.VolleyInstance;
import net.lidongdong.godcar.ui.adapter.CutureAdapter;
import net.lidongdong.godcar.ui.app.MyApp;
import net.lidongdong.godcar.ui.fragment.AbsBaseFragment;

import java.util.List;

/**
 * Created by 潘驴邓小闲 on 16/9/13.
 * 文化fragment
 */
public class CutureFragment extends AbsBaseFragment {
    private ListView listView;
    private CutureAdapter adapter;

    public static CutureFragment newInstance(String str) {

        Bundle args = new Bundle();
        args.putString("URL", str);
        CutureFragment fragment = new CutureFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_culture;
    }

    @Override
    protected void initViews() {
        listView = byView(R.id.fragment_culture_lv);
    }

    @Override
    protected void initDatas() {
        adapter = new CutureAdapter(context);
        listView.setAdapter(adapter);
        Bundle bundle = getArguments();
        String CultureUrl = bundle.getString("URL");
        VolleyInstance.getInstance().startRequest(CultureUrl, new IVolleyResult() {
            @Override
            public void success(String str, int who) {

            }

            @Override
            public void success(String str) {
                Gson gson = new Gson();
                CultureBean bean = gson.fromJson(str, CultureBean.class);
                List<CultureBean.ResultBean.NewslistBean> data = bean.getResult().getNewslist();
                adapter.setDatas(data);
            }

            @Override
            public void failure() {

            }
        });


    }
}

