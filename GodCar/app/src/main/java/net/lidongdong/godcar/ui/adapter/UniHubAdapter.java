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
import net.lidongdong.godcar.model.bean.UniHubBean;
import net.lidongdong.godcar.utils.ScreenSize;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by 潘驴邓小娴 on 2016/9/20.
 * 优创
 */

public class UniHubAdapter extends BaseAdapter {
    private List<UniHubBean.ResultBean.NewslistBean> data;
    private Context context;
    private LayoutInflater inflater;
    private static final int TYPE_1 = 0;
    private static final int TYPE_2 = 1;

    public UniHubAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setData(List<UniHubBean.ResultBean.NewslistBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return data != null ? data.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public int getItemViewType(int position) {
        int type =data.get(position).getMediatype();
        if (type==1){
            return TYPE_1;
        }else {
            return TYPE_2;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        unihubMajorViewHolder holderM=null;
        uniHubViewHolder holder=null;
        int type=getItemViewType(position);


        if (convertView == null) {
            switch (type){
                case TYPE_1:
                  convertView=inflater.inflate(R.layout.item_unihub,parent,false);
                    int height = ScreenSize.getHight(context);
                    convertView.setMinimumHeight(height / 3);
                    holder = new uniHubViewHolder(convertView);
                    convertView.setTag(holder);
                    break;
                case TYPE_2:
                    convertView=inflater.inflate(R.layout.item_unihub_,parent,false);
                    int height1 = ScreenSize.getHight(context);
                    convertView.setMinimumHeight(height1 / 3);
                    holderM = new unihubMajorViewHolder(convertView);
                    convertView.setTag(holderM);
                    break;
            }

        } else {
            switch (type){
                case TYPE_1:
                    holder = (uniHubViewHolder) convertView.getTag();
                    break;
                case TYPE_2:
                    holderM= (unihubMajorViewHolder) convertView.getTag();
            }

        }

        UniHubBean.ResultBean.NewslistBean bean = data.get(position);

        if (bean != null) {
            switch (type){
                case TYPE_1:
                    holder.authorTv.setText(bean.getUsername());
                    holder.titleTv.setText(bean.getTitle());
                    holder.zanTv.setText(bean.getPraisenum() + "");
                    holder.talkTv.setText(bean.getReplycount() + "");
                    holder.timeTv.setText(bean.getPublishtime());
                    Glide.with(context).load(bean.getIndexdetail().get(0)).into(holder.youchuangIv);
                    Glide.with(context).load(bean.getUserpic()).into(holder.circleIv);
                    break;
                case TYPE_2:
                    holderM.authorTv.setText(bean.getUsername());
                    holderM.titleTv.setText(bean.getTitle());
                    holderM.zanTv.setText(bean.getPraisenum() + "");
                    holderM.talkTv.setText(bean.getReplycount() + "");
                    holderM.timeTv.setText(bean.getPublishtime());
                    Glide.with(context).load(bean.getIndexdetail().get(0)).into(holderM.youchuangIv);
                    Glide.with(context).load(bean.getUserpic()).into(holderM.circleIv);
                    break;

            }

        }
        return convertView;
    }

    public class uniHubViewHolder {
        TextView titleTv, timeTv, zanTv, talkTv;
        ImageView youchuangIv;
        TextView authorTv;
        CircleImageView circleIv;

        public uniHubViewHolder(View view) {
            titleTv = (TextView) view.findViewById(R.id.item_unihub_titleTv);
            timeTv = (TextView) view.findViewById(R.id.item_unihub_timeTv);
            zanTv = (TextView) view.findViewById(R.id.item_unihub_zanTv);
            talkTv = (TextView) view.findViewById(R.id.item_unihub_talkTv);
            youchuangIv = (ImageView) view.findViewById(R.id.item_unihub_image);
            circleIv = (CircleImageView) view.findViewById(R.id.item_unihub_circleImage);
            authorTv = (TextView) view.findViewById(R.id.item_unihub_authorTv);
        }
    }

    public class unihubMajorViewHolder {
        TextView  titleTv, timeTv, zanTv, talkTv;
        ImageView youchuangIv;
        TextView authorTv;
        CircleImageView circleIv;
        public unihubMajorViewHolder(View view) {
            titleTv = (TextView) view.findViewById(R.id.item_unihub_titleTv_);
            timeTv = (TextView) view.findViewById(R.id.item_unihub_timeTv_);
            zanTv = (TextView) view.findViewById(R.id.item_unihub_zanTv_);
            talkTv = (TextView) view.findViewById(R.id.item_unihub_talkTv_);
            youchuangIv = (ImageView) view.findViewById(R.id.item_unihub_image_);
            circleIv = (CircleImageView) view.findViewById(R.id.item_unihub_circleImage_);
            authorTv = (TextView) view.findViewById(R.id.item_unihub_authorTv_);
        }
    }
}

