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
import net.lidongdong.godcar.model.bean.ChooseBean;

import java.util.List;

/**
 * Created by dllo on 16/9/28.
 */
public class ChooseAdapter extends BaseAdapter {
    private Context context;
    private List<ChooseBean.ResultBean.SeriesBean> datas;

    public void setDatas(List<ChooseBean.ResultBean.SeriesBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public ChooseAdapter(Context context) {
        this.context = context;
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
        ChooseViewHolder chooseViewHolder=null;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_choose,parent,false);
            chooseViewHolder=new ChooseViewHolder(convertView);
            convertView.setTag(chooseViewHolder);
        }else {
            chooseViewHolder= (ChooseViewHolder) convertView.getTag();
        }
        ChooseBean.ResultBean.SeriesBean bean=datas.get(position);
        chooseViewHolder.nameTv.setText(bean.getSeriesname());
        chooseViewHolder.priceTv.setText(bean.getPricerange());
        chooseViewHolder.cornericon.setText(bean.getCornericon());
        Glide.with(context).load(bean.getThumburl()).into(chooseViewHolder.img);

        return convertView;
    }
    class ChooseViewHolder{
        ImageView img;
        TextView priceTv,nameTv,cornericon;

        public ChooseViewHolder(View view) {
            img = (ImageView) view.findViewById(R.id.item_choose_img);
            priceTv = (TextView) view.findViewById(R.id.item_choose_price);
            nameTv = (TextView) view.findViewById(R.id.item_choose_name);
            cornericon = (TextView) view.findViewById(R.id.item_choose_cornericon);
        }
    }
}
