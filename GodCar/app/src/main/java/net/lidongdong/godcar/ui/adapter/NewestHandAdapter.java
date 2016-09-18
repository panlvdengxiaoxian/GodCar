package net.lidongdong.godcar.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.model.bean.NewestHandBean;

import java.util.List;

/**
 * Created by dllo on 16/9/18.
 */
public class NewestHandAdapter extends PagerAdapter {
    private List<NewestHandBean> datas;
    private Context context;
    private LayoutInflater inflater;

    public NewestHandAdapter(List<NewestHandBean> datas, Context context) {
        this.datas = datas;
        this.context = context;
        inflater=LayoutInflater.from(context);
    }

    public NewestHandAdapter(Context context) {
        this.context = context;
        inflater=LayoutInflater.from(context);

    }

    public void setDatas(List<NewestHandBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas==null?0:Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int newPosition=position%datas.size();
        View convertView=inflater.inflate(R.layout.item_newest_hand,container,false);
        ImageView imageView= (ImageView) convertView.findViewById(R.id.item_newest_hand_iv);
        TextView textView= (TextView) convertView.findViewById(R.id.item_newest_hand_tv);
        textView.setText("文字内容"+newPosition);
        imageView.setImageResource(datas.get(newPosition).getImgId());
        container.addView(convertView);
        return convertView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}
