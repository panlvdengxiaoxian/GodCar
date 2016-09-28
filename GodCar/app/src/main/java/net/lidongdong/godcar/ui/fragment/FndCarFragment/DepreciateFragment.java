package net.lidongdong.godcar.ui.fragment.FndCarFragment;

import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.model.bean.DepreciateBean;
import net.lidongdong.godcar.model.net.IVolleyResult;
import net.lidongdong.godcar.model.net.VolleyInstance;
import net.lidongdong.godcar.ui.adapter.DepreciateApater;
import net.lidongdong.godcar.ui.fragment.AbsBaseFragment;

import java.util.List;

/**
 * Created by dllo on 16/9/10.
 */
public class DepreciateFragment extends AbsBaseFragment {
    private ListView listView;
    private DepreciateApater apater;
    public static DepreciateFragment newInstance(String url) {

        Bundle args = new Bundle();
        args.putString("URL",url);

        DepreciateFragment fragment = new DepreciateFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_depreciate;
    }

    @Override
    protected void initViews() {
        listView=byView(R.id.depreciate_lv);

    }

    @Override
    protected void initDatas() {
       apater=new DepreciateApater(context);
        listView.setAdapter(apater);
        Bundle bundle=getArguments();
        String depreciateUrl=bundle.getString("URL");
        VolleyInstance.getInstance().startRequest(depreciateUrl, new IVolleyResult() {
            @Override
            public void success(String str, int who) {

            }

            @Override
            public void success(String str) {
                Gson gson=new Gson();
                DepreciateBean bean=gson.fromJson(str,DepreciateBean.class);
                List<DepreciateBean.ResultBean.CarlistBean> datas=bean.getResult().getCarlist();
                apater.setDatas(datas);
            }

            @Override
            public void failure() {

            }
        });
    }
}
