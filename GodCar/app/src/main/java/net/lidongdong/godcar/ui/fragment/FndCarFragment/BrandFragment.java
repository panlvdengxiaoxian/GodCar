package net.lidongdong.godcar.ui.fragment.FndCarFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.google.gson.Gson;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.model.bean.BrandBean;
import net.lidongdong.godcar.model.net.IVolleyResult;
import net.lidongdong.godcar.model.net.VolleyInstance;
import net.lidongdong.godcar.ui.adapter.BrandAdapter;
import net.lidongdong.godcar.ui.fragment.AbsBaseFragment;

import java.util.List;

/**
 * Created by dllo on 16/9/10.
 * 品牌
 */
public class BrandFragment extends AbsBaseFragment {
    private String urlHand="http://223.99.255.20/cars.app.autohome.com.cn/dealer_v5.7.0/dealer/hotbrands-pm2.json";
     private ListView listView;
    BrandAdapter adapter;
    public static BrandFragment newInstance(String url) {

        Bundle args = new Bundle();
        args.putString("Url",url);

        BrandFragment fragment = new BrandFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_brand;
    }

    @Override
    protected void initViews() {
     listView=byView(R.id.brand_lv);
    }

    @Override
    protected void initDatas() {
        //添加头布局
        View headView= LayoutInflater.from(context).inflate(R.layout.head_brand_listview,null);
        buildDatas();
        listView.addHeaderView(headView);
        adapter=new BrandAdapter(context);
        listView.setAdapter(adapter);
        Bundle bundle=getArguments();
        String brandUrl=bundle.getString("Url");
        VolleyInstance.getInstance().startRequest(brandUrl, new IVolleyResult() {
            @Override
            public void success(String str, int who) {

            }

            @Override
            public void success(String str) {
                Gson gson=new Gson();
                BrandBean bean=gson.fromJson(str,BrandBean.class);
                List<BrandBean.ResultBean.BrandlistBean> datas=bean.getResult().getBrandlist();
                adapter.setDatas(datas);
            }

            @Override
            public void failure() {

            }
        });

    }

    private void buildDatas() {

    }
}
