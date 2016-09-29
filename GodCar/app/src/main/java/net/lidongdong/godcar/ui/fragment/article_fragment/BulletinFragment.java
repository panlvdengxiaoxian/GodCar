package net.lidongdong.godcar.ui.fragment.article_fragment;

import android.os.Bundle;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.model.bean.BulletinBean;
import net.lidongdong.godcar.model.net.IVolleyResult;
import net.lidongdong.godcar.model.net.VolleyInstance;
import net.lidongdong.godcar.ui.adapter.BulletinAdapter;
import net.lidongdong.godcar.ui.app.MyApp;
import net.lidongdong.godcar.ui.fragment.AbsBaseFragment;

import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by 潘驴邓小闲 on 16/9/13.
 * 快报页面
 */
public class BulletinFragment extends AbsBaseFragment {
    private ListView listView;
    private BulletinAdapter adapter;

    public static BulletinFragment newInstance(String str) {

        Bundle args = new Bundle();
        args.putString("URL", str);
        BulletinFragment fragment = new BulletinFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_bulletin;
    }

    @Override
    protected void initViews() {
        listView = byView(R.id.fragment_bulletin_lv);
    }


    @Override
    protected void initDatas() {
        adapter = new BulletinAdapter(context);
        listView.setAdapter(adapter);
        Bundle bundle = getArguments();
        String bulletinURL = bundle.getString("URL");
        VolleyInstance.getInstance().startRequest(bulletinURL, new IVolleyResult() {
            @Override
            public void success(String str, int who) {

            }

            @Override
            public void success(String str) {
                Gson gson = new Gson();
                BulletinBean bean = gson.fromJson(str, BulletinBean.class);
                List<BulletinBean.ResultBean.ListBean> data = bean.getResult().getList();
                adapter.setData(data);
            }

            @Override
            public void failure() {

            }
        });

    }
}
