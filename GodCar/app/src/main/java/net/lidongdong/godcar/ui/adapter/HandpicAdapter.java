package net.lidongdong.godcar.ui.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import net.lidongdong.godcar.R;
import net.lidongdong.godcar.utils.OnRecycleItemClick;

import java.util.List;
/**
 * Created by 潘驴邓小娴 on 2016/9/12.
 * 精品推荐的recycleView适配器
 */

public class HandpicAdapter extends RecyclerView.Adapter<HandpicAdapter.HandpicViewHolder> {
    private List<String> datas;
    private Context context;
    private OnRecycleItemClick onRecycleItemClik;

    public void setOnRecycleItemClik(OnRecycleItemClick onRecycleItemClik) {
        this.onRecycleItemClik = onRecycleItemClik;
    }

    public HandpicAdapter(List<String> datas, Context context) {
        this.datas = datas;
        this.context = context;
        notifyDataSetChanged();
    }

    @Override
    public HandpicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_handpic, parent, false);
        HandpicViewHolder holder = new HandpicViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final HandpicViewHolder holder, final int position) {
        holder.tv.setText(datas.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onRecycleItemClik != null) {
                    int p = holder.getLayoutPosition();
                    String string = datas.get(position);
                    onRecycleItemClik.OnRvItemClicListener(p, string);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas != null ? datas.size() : 0;
    }

    class HandpicViewHolder extends RecyclerView.ViewHolder {
        TextView tv;

        public HandpicViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.item_handpic_recycler_tv);
        }
    }
}

