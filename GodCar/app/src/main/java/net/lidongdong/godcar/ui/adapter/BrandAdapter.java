package net.lidongdong.godcar.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import net.lidongdong.godcar.R;
import net.lidongdong.godcar.model.bean.BrandBean;

import java.util.List;

/**
 * Created by dllo on 16/9/28.
 * 品牌的适配器
 */
public class BrandAdapter extends BaseAdapter {
    private Context context;
    private List<BrandBean.ResultBean.BrandlistBean> datas;
    private LayoutInflater inflater;
    private static final int Type=0;//字母行
    private static final int TypeLETTER=1;//品牌行



    public BrandAdapter(Context context) {
        this.context = context;
        inflater=LayoutInflater.from(context);
    }

    public void setDatas(List<BrandBean.ResultBean.BrandlistBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas==null?0:datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas==null?null: datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        String type=datas.get(position).getLetter();
        String [] str=new String[26];
        return super.getItemViewType(position);
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        letterViewHolder holder=null;
        brandViewHolder holder1=null;
        int type=getItemViewType(position);
        if (convertView==null){
            convertView= inflater.inflate(R.layout.item_brand,parent,false);
            holder=new letterViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder= (letterViewHolder) convertView.getTag();
        }
        BrandBean.ResultBean.BrandlistBean bean=datas.get(position);
        holder.letter.setText(bean.getLetter());
        return convertView;
    }
    class letterViewHolder{
        TextView letter;
        public letterViewHolder(View view) {
            letter=(TextView)view.findViewById(R.id.letter);
        }
    }
    class brandViewHolder{
        ImageView img;
        TextView name;
        public brandViewHolder(View view) {
            img = (ImageView) view.findViewById(R.id.logo);
            name = (TextView) view.findViewById(R.id.name);
        }
    }
}
