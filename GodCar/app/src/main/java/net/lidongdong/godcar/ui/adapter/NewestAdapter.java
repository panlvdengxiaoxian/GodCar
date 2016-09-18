package net.lidongdong.godcar.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import net.lidongdong.godcar.model.bean.NewestBean;

import java.util.List;

/**
 * Created by dllo on 16/9/18.
 * 最新页的适配器
 */
public class NewestAdapter extends BaseAdapter{
    private List<NewestBean> datas;
    private Context context;

    public NewestAdapter(List<NewestBean> datas) {
        this.datas = datas;
    }

    public NewestAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<NewestBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
