package net.lidongdong.godcar.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dllo on 16/9/13.
 */
public class HandpickAdapter extends RecyclerView.Adapter<HandpickAdapter.ViewHolser> {
    private LayoutInflater layoutInflater;
    private List<Integer> datas;
    private Context context;

    public HandpickAdapter(List<Integer> datas, Context context) {
        this.datas = datas;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public ViewHolser onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolser holder, int position) {

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolser extends RecyclerView.ViewHolder {
        public ViewHolser(View itemView) {
            super(itemView);
        }
        TextView handpickTv;

    }
}
