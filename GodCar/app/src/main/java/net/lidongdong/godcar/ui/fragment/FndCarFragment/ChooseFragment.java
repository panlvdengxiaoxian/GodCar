package net.lidongdong.godcar.ui.fragment.FndCarFragment;

import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.model.bean.ChooseBean;
import net.lidongdong.godcar.model.net.IVolleyResult;
import net.lidongdong.godcar.model.net.VolleyInstance;
import net.lidongdong.godcar.ui.adapter.ChooseAdapter;
import net.lidongdong.godcar.ui.fragment.AbsBaseFragment;

import java.util.List;

/**
 * Created by dllo on 16/9/10.
 * 选择页
 */
public class ChooseFragment extends AbsBaseFragment {
    private ListView listView;
    private ChooseAdapter adapter;

    public static ChooseFragment newInstance(String strUrl) {

        Bundle args = new Bundle();
        args.putString("URL", strUrl);
        ChooseFragment fragment = new ChooseFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_choose;

    }

    @Override
    protected void initViews() {
        listView = byView(R.id.choose_lv);

    }

    @Override
    protected void initDatas() {
        adapter = new ChooseAdapter(context);
        listView.setAdapter(adapter);
        Bundle bundle=getArguments();
        String chooseUrl=bundle.getString("URL");
        VolleyInstance.getInstance().startRequest(chooseUrl, new IVolleyResult() {
            @Override
            public void success(String str, int who) {

            }

            @Override
            public void success(String str) {
                Gson gson=new Gson();
                ChooseBean bean=gson.fromJson(str,ChooseBean.class);
                List<ChooseBean.ResultBean.SeriesBean> datas=bean.getResult().getSeries();
                adapter.setDatas(datas);
            }

            @Override
            public void failure() {

            }
        });
    }
}
