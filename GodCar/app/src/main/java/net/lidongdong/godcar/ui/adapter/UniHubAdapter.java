package net.lidongdong.godcar.ui.adapter;

/**
 * Created by 潘驴邓小娴 on 2016/9/20.
 */
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
 * Created by dllo on 16/9/18.
 * 优加+
 */
public class UniHubAdapter extends BaseAdapter {
    private List<UniHubBean.ResultBean.NewslistBean> data;
    private Context context;

    public UniHubAdapter(Context context) {
        this.context = context;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        UniHubViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_unihub, parent, false);
            int height = ScreenSize.getHight(context);
            convertView.setMinimumHeight(height / 3);
            holder = new UniHubViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (UniHubViewHolder) convertView.getTag();
        }
        UniHubBean.ResultBean.NewslistBean bean = data.get(position);
        if (bean != null) {
            holder.authorTv.setText(bean.getUsername());
            holder.titleTv.setText(bean.getTitle());
            holder.zanTv.setText(bean.getPraisenum()+"");
            holder.talkTv.setText(bean.getReplycount()+"");
            holder.timeTv.setText(bean.getPublishtime());
            Glide.with(context).load(bean.getIndexdetail().get(0)).into(holder.youchuangIv);
            Glide.with(context).load(bean.getUserpic()).into(holder.circleIv);
        }
        return convertView;
    }

    public class UniHubViewHolder {
        TextView authorTv, titleTv, timeTv, zanTv, talkTv;
        ImageView youchuangIv;
        CircleImageView circleIv;
        public UniHubViewHolder(View view) {
            authorTv = (TextView) view.findViewById(R.id.item_unihub_authorTv);
            titleTv = (TextView) view.findViewById(R.id.item_unihub_titleTv);
            timeTv = (TextView) view.findViewById(R.id.item_unihub_timeTv);
            zanTv = (TextView) view.findViewById(R.id.item_unihub_zanTv);
            talkTv = (TextView) view.findViewById(R.id.item_unihub_talkTv);
            circleIv = (CircleImageView) view.findViewById(R.id.item_unihub_circleImage);
            youchuangIv = (ImageView) view.findViewById(R.id.item_unihub_image);
        }
    }
}

