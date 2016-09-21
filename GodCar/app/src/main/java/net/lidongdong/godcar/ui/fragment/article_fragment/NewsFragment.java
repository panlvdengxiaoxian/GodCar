package net.lidongdong.godcar.ui.fragment.article_fragment;

import android.os.Bundle;
import android.widget.ListView;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.model.bean.NewsBean;
import net.lidongdong.godcar.model.bean.WebStatic;
import net.lidongdong.godcar.model.net.IVolleyResult;
import net.lidongdong.godcar.model.net.VolleyInstance;
import net.lidongdong.godcar.ui.adapter.NewsAdapter;
import net.lidongdong.godcar.ui.fragment.AbsBaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/9.
 * 新闻界面
 */
public class NewsFragment extends AbsBaseFragment {

    private ListView newsLv;
    private List<NewsBean.ResultBean.NewslistBean> datas;
    private NewsAdapter newsAdapter;

    public static NewsFragment newInstance() {

        Bundle args = new Bundle();

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
        newsAdapter=new NewsAdapter(context);
        newsAdapter.setDatas(datas);
        newsLv.setAdapter(newsAdapter);

    }

    @Override
    protected void initDatas() {
//        VolleyInstance.getInstance().startRequest(WebStatic.ARTICLE_NEWS_URL,);
    }
}
