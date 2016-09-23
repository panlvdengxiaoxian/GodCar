package net.lidongdong.godcar.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.model.bean.AllBean;

import java.util.List;


/**
 * Created by 潘驴邓小娴 on 2016/9/20.
 * 论坛精选推荐通用Adapter
 */

public class AllAdapter extends BaseAdapter {
    private List<AllBean.ResultBean.ListBean> datas;
    private Context context;

    public AllAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<AllBean.ResultBean.ListBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas != null ? datas.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return datas != null ? datas.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AllViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_all, parent, false);
            holder = new AllViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (AllViewHolder) convertView.getTag();
        }
        AllBean.ResultBean.ListBean bean = datas.get(position);
        if (bean != null) {
            holder.jiTv.setText(bean.getBbsname());
            holder.titleTv.setText(bean.getTitle());
            holder.huiTv.setText(bean.getReplycounts() + "回");
            Glide.with(context).load(bean.getSmallpic()).into(holder.showIv);
        }
        return convertView;
    }

    public class AllViewHolder {
        ImageView showIv;
        TextView titleTv, jiTv, huiTv;

        public AllViewHolder(View view) {
            showIv = (ImageView) view.findViewById(R.id.item_manyIv);
            titleTv = (TextView) view.findViewById(R.id.item_many_titleTv);
            jiTv = (TextView) view.findViewById(R.id.item_many_jiTv);
            huiTv = (TextView) view.findViewById(R.id.item_many_huiTv);
        }
    }
}

