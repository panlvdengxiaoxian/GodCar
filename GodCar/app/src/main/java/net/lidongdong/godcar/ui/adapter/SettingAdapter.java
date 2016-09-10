package net.lidongdong.godcar.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.model.bean.SettingBean;

import java.util.List;

/**
 * Created by dllo on 16/9/10.
 * 设置界面的适配器
 */
public class SettingAdapter extends BaseAdapter {
    private Context context;
    private List<SettingBean> datas;

    public SettingAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<SettingBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas==null?0:datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas==null?null:datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SettingViewHolder settingViewHolder=null;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_setting,parent,false);
            settingViewHolder=new SettingViewHolder(convertView);
            convertView.setTag(settingViewHolder);

        }else {
            settingViewHolder= (SettingViewHolder) convertView.getTag();
        }
        SettingBean settingBean=new SettingBean();
        settingViewHolder.settingTv.setText(datas.get(position).getTitle());
        settingViewHolder.iconImg.setImageResource(Integer.parseInt(datas.get(position).getIcon()));
        return convertView;
    }
    class SettingViewHolder{
        TextView settingTv;
        ImageView iconImg;

        public SettingViewHolder(View view) {
            settingTv = (TextView) view.findViewById(R.id.item_setting_tv);
            iconImg = (ImageView) view.findViewById(R.id.item_setting_img);

        }
    }
}
