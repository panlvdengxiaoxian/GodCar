package net.lidongdong.godcar.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.model.bean.NewestBean;
import net.lidongdong.godcar.utils.ScreenSize;

import java.util.List;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
/**
 * Created by 潘驴邓小闲 xxx
 * 最新页的适配器
 */
public class NewestAdapter extends BaseAdapter {
    private List<NewestBean.ResultBean.NewslistBean> data;
    private Context context;

    public NewestAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<NewestBean.ResultBean.NewslistBean> data) {
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
        NewestFragmentViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_newest_fragment, parent, false);
            int height = ScreenSize.getHight(context);
            convertView.setMinimumHeight(height / 5);
            holder = new NewestFragmentViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (NewestFragmentViewHolder) convertView.getTag();
        }
        NewestBean.ResultBean.NewslistBean bean = data.get(position);
        if (bean != null) {
            holder.titleTv.setText(bean.getTitle());
            holder.timeTv.setText(bean.getTime());
            Glide.with(context).load(bean.getSmallpic()).into(holder.iv);
        }
        return convertView;
    }

    public class NewestFragmentViewHolder {
        ImageView iv;
        TextView titleTv, timeTv;

        public NewestFragmentViewHolder(View view) {
            iv = (ImageView) view.findViewById(R.id.item_newest_iv);
            titleTv = (TextView) view.findViewById(R.id.item_newest_titleTv);
            timeTv = (TextView) view.findViewById(R.id.item_newest_timeTv);
        }
    }
}
