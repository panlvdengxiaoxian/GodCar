package net.lidongdong.godcar.ui.fragment.Forum_fragment.handpick_fragment;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.model.bean.AllBean;
import net.lidongdong.godcar.model.net.IVolleyResult;
import net.lidongdong.godcar.model.net.VolleyInstance;
import net.lidongdong.godcar.ui.adapter.AllAdapter;
import net.lidongdong.godcar.ui.fragment.AbsBaseFragment;
import net.lidongdong.godcar.view.AutoHomeListView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 潘驴邓小娴 on 2016/9/20.
 * 论坛精选通用fragment
 */

public class AllFragment extends AbsBaseFragment implements AutoHomeListView.OnAutoHomeRefreshListener {
    private AutoHomeListView listView;
    private AllAdapter adapter;
    private final int REFRESH_COMPLETE = 0;

    List<AllBean.ResultBean.ListBean> datas;
    private InterHandler mInterHandler = new InterHandler(this);

    private class InterHandler extends Handler {
        private WeakReference<AllFragment> mFragments;

        public InterHandler(AllFragment fragment) {
            mFragments = new WeakReference<AllFragment>(fragment);
        }

        public void handleMessage(Message msg) {
            AllFragment fragment = mFragments.get();
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
        datas = new ArrayList<>();

    }


    @Override
    protected void initDatas() {
        listView.setOnAutoHomeRefreshListener(this);
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

