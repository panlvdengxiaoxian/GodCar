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
import net.lidongdong.godcar.model.bean.BulletinBean;
import net.lidongdong.godcar.utils.ScreenSize;

import java.util.List;

/**
 * Created by 潘驴邓小娴 on 2016/9/17;
 */

public class BulletinAdapter extends BaseAdapter{
    private List<BulletinBean.ResultBean.ListBean> data;
    private Context context;

    public BulletinAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<BulletinBean.ResultBean.ListBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data!=null?data.size():0;
    }

    @Override
    public Object getItem(int position) {
        return data!=null?data.get(position):null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BulletinViewHolder holder=null;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_bulletin,parent,false);
            int height= ScreenSize.getHight(context);
            convertView.setMinimumHeight(height/3);
            holder=new BulletinViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (BulletinViewHolder) convertView.getTag();
        }
        BulletinBean.ResultBean.ListBean bean=data.get(position);
        if (bean!=null){
            holder.titleTv.setText(bean.getTitle());
            holder.peopleCoundTv.setText(bean.getReviewcount()+"人浏览");
            holder.timeTv.setText(bean.getCreatetime());
            Glide.with(context).load(bean.getBgimage()).into(holder.showImage);
        }
        return convertView;
    }
    public class BulletinViewHolder{
        TextView titleTv,peopleCoundTv,timeTv;
        ImageView showImage;
        public BulletinViewHolder(View view){
            titleTv= (TextView) view.findViewById(R.id.item_fasereport_titleTv);
            peopleCoundTv= (TextView) view.findViewById(R.id.item_fasereport_peopleCoundTv);
            timeTv= (TextView) view.findViewById(R.id.item_fasereport_timeTv);
            showImage= (ImageView) view.findViewById(R.id.item_fasereport_showImage);
        }
    }
}

