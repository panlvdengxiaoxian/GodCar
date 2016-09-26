package net.lidongdong.godcar.ui.fragment.article_fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.model.bean.NewsBean;
import net.lidongdong.godcar.ui.adapter.NewsAdapter;
import net.lidongdong.godcar.ui.app.MyApp;
import net.lidongdong.godcar.ui.fragment.AbsBaseFragment;
import net.lidongdong.godcar.view.AutoHomeListView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/9.
 * 新闻界面
 */
public class NewsFragment extends AbsBaseFragment implements AutoHomeListView.OnAutoHomeRefreshListener {
    private AutoHomeListView newsLv;
    private NewsAdapter newsAdapter;
    List<NewsBean.ResultBean.NewslistBean> datas;

    private final int REFRESH_COMPLETE = 0;
    private InterHandler mInterHandler=new InterHandler(this);

    private class InterHandler extends Handler{
        private WeakReference<NewsFragment> mFragments;
        public InterHandler(NewsFragment fragment){
            mFragments=new WeakReference<NewsFragment>(fragment);
        }
        public void handleMessage(Message msg){
            NewsFragment fragment=mFragments.get();
            if (fragment!=null){
                switch (msg.what){
                    case REFRESH_COMPLETE:
                        fragment.newsLv.setOnRefreshComplete();
                        fragment.newsAdapter.notifyDataSetChanged();
                        fragment.newsLv.setSelection(0);
                        break;
                }

            }else {
                super.handleMessage(msg);
            }
        }

    }

    public static NewsFragment newInstance(String str) {

        Bundle args = new Bundle();

        args.putString("URL",str);

        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initViews() {
        newsLv = byView(R.id.news_lv);
        datas=new ArrayList<>();
        newsLv.setOnAutoHomeRefreshListener(this);

    }

    @Override
    protected void initDatas() {
        newsAdapter=new NewsAdapter(context);
        newsLv.setAdapter(newsAdapter);
        Bundle bundle=getArguments();
        String NewsUrl=bundle.getString("URL");
        RequestQueue queue= Volley.newRequestQueue(MyApp.getContext());
        StringRequest request=new StringRequest(NewsUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Gson gson=new Gson();
                NewsBean bean=gson.fromJson(response,NewsBean.class);
                datas=bean.getResult().getNewslist();
                newsAdapter.setDatas(datas);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);

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
