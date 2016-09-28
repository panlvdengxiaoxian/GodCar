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
import net.lidongdong.godcar.model.bean.DepreciateBean;

import java.util.List;

/**
 * Created by dllo on 16/9/28.
 */
public class DepreciateApater extends BaseAdapter {
    private Context context;
    private List<DepreciateBean.ResultBean.CarlistBean> datas;

    public DepreciateApater(Context context) {
        this.context = context;
    }

    public void setDatas(List<DepreciateBean.ResultBean.CarlistBean> datas) {
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
        depreciateViewHolder holder=null;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_depreciate,parent,false);
            holder=new depreciateViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder= (depreciateViewHolder) convertView.getTag();
        }
        DepreciateBean.ResultBean.CarlistBean bean=datas.get(position);
        holder.city.setText(bean.getDealer().getCity());
        holder.seriesname.setText(bean.getSeriesname());
        holder.shortname.setText(bean.getDealer().getShortname());
        holder.distance.setText("距离"+bean.getDealer().getDistance());
        holder.specprice.setText(bean.getDealer().getSpecprice());
        holder.orderrange.setText(bean.getOrderrange());
        holder.fctprice.setText(bean.getFctprice());
        holder.specname.setText(bean.getSpecname());
        holder.item_teltext.setText(bean.getDealer().getTeltext());
        Glide.with(context).load(bean.getSpecpic()).into(holder.img);

        return convertView;
    }
    class depreciateViewHolder{
        ImageView img;
        TextView seriesname,specname,specprice,fctprice,city,shortname,distance,orderrange,item_teltext;

        public depreciateViewHolder(View view) {
            img = (ImageView) view.findViewById(R.id.styledinventorystate);
            seriesname = (TextView) view.findViewById(R.id.seriesname);
            specname = (TextView) view.findViewById(R.id.specname);
            specprice = (TextView) view.findViewById(R.id.specprice);
            fctprice = (TextView) view.findViewById(R.id.fctprice);
            city = (TextView) view.findViewById(R.id.city);
            shortname = (TextView) view.findViewById(R.id.shortname);
            distance = (TextView) view.findViewById(R.id.distance);
            orderrange = (TextView) view.findViewById(R.id.orderrange);
            item_teltext = (TextView) view.findViewById(R.id.item_teltext);
        }
    }
}
