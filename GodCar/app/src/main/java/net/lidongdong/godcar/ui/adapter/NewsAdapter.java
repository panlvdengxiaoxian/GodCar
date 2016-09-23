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
import net.lidongdong.godcar.model.bean.NewsBean;

import java.util.List;

/**
 * Created by dllo on 16/9/21.
 * 新闻界面的适配器
 *
 */
public class NewsAdapter extends BaseAdapter{
   private List<NewsBean.ResultBean.NewslistBean> datas;
    private Context context;


    public NewsAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<NewsBean.ResultBean.NewslistBean> datas) {
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
        NewsViewHolder newsViewHolder=null;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_news,parent,false);
            newsViewHolder=new NewsViewHolder(convertView);
            convertView.setTag(newsViewHolder);
        }else {
            newsViewHolder= (NewsViewHolder) convertView.getTag();
        }
         NewsBean.ResultBean.NewslistBean bean=datas.get(position);
        if (bean!=null){
            newsViewHolder.newsTitle.setText(bean.getTitle());
            newsViewHolder.newsTime.setText(bean.getTime());
            newsViewHolder.relayCount.setText(bean.getReplycount()+"评论");
            Glide.with(context).load(bean.getSmallpic()).into(newsViewHolder.newsImg);

        }
        return convertView;
    }
    class NewsViewHolder{
        ImageView newsImg;
        TextView newsTitle,newsTime,relayCount;
        public NewsViewHolder(View view) {
            newsImg = (ImageView) view.findViewById(R.id.item_news_img);
            newsTime = (TextView) view.findViewById(R.id.item_news_time_tv);
            newsTitle = (TextView) view.findViewById(R.id.item_news_title_tv);
            relayCount = (TextView) view.findViewById(R.id.item_news_replyCount_tv);
        }
    }


}
