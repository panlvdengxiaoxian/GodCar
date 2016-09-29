package net.lidongdong.godcar.ui.fragment.article_fragment;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.model.bean.UniHubBean;
import net.lidongdong.godcar.model.net.IVolleyResult;
import net.lidongdong.godcar.model.net.VolleyInstance;
import net.lidongdong.godcar.ui.adapter.UniHubAdapter;
import net.lidongdong.godcar.ui.fragment.AbsBaseFragment;
import net.lidongdong.godcar.view.AutoHomeListView;

import android.os.Bundle;

import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;


import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by 潘驴邓小闲 on 16/9/12.
 * 优创fragment
 */
public class UniHubFragment extends AbsBaseFragment implements AutoHomeListView.OnAutoHomeRefreshListener {
    private AutoHomeListView listView;
    private UniHubAdapter adapter;
    private List<UniHubBean.ResultBean.NewslistBean> datas;

    private final int REFRESH_COMPLETE = 0;
    private InterHandler mInterHandler = new InterHandler(this);

    private class InterHandler extends Handler {
        private WeakReference<UniHubFragment> mFragments;

        public InterHandler(UniHubFragment fragment) {
            mFragments = new WeakReference<UniHubFragment>(fragment);
        }

        public void handleMessage(Message msg) {
            UniHubFragment fragment = mFragments.get();
            if (fragment != null) {
                switch (msg.what) {
                    case REFRESH_COMPLETE:
                        fragment.listView.setOnRefreshComplete();
                        fragment.adapter.notifyDataSetChanged();
                        fragment.listView.setSelection(0);
                        break;
                }

            } else {
                super.handleMessage(msg);
            }
        }

    }

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
        listView.setOnAutoHomeRefreshListener(this);
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

    @Override
    public void onRefresh() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    mInterHandler.sendEmptyMessage(REFRESH_COMPLETE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}