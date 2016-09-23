package net.lidongdong.godcar.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import net.lidongdong.godcar.R;
import net.lidongdong.godcar.model.bean.NewFragmentRoateBean;
import java.util.List;
import com.bumptech.glide.Glide;
/**
 * Created by 潘驴邓小娴 on 2016/9/18.
 * 推荐页最新的头布局
 */

public class NewestHandAdapter extends PagerAdapter {
    private List<NewFragmentRoateBean> datas;
    private Context context;
    private LayoutInflater inflater;

    public NewestHandAdapter(List<NewFragmentRoateBean> datas, Context context) {
        this.datas = datas;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public NewestHandAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setDatas(List<NewFragmentRoateBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int newPosition = position % datas.size();
        View convertView = inflater.inflate(R.layout.item_newest_hand, container, false);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.new_fragment_item_viewPager_iv);
        Glide.with(context).load(datas.get(newPosition).getImgUrl()).into(imageView);
        container.addView(convertView);
        return convertView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }
}
