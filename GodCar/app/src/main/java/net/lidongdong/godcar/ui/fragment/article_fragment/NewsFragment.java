package net.lidongdong.godcar.ui.fragment.article_fragment;

import android.os.Bundle;
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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/9.
 * 新闻界面
 */
public class NewsFragment extends AbsBaseFragment {
    private ListView newsLv;
    private NewsAdapter newsAdapter;

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
                List<NewsBean.ResultBean.NewslistBean> datas=bean.getResult().getNewslist();
                newsAdapter.setDatas(datas);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
    }
}
