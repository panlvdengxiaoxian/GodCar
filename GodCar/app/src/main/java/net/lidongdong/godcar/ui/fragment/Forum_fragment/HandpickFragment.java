package net.lidongdong.godcar.ui.fragment.Forum_fragment;



import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.model.net.WebVelues;
import net.lidongdong.godcar.ui.adapter.HandpicAdapter;
import net.lidongdong.godcar.ui.fragment.AbsBaseFragment;
import net.lidongdong.godcar.ui.fragment.Forum_fragment.handpick_fragment.AllFragment;
import net.lidongdong.godcar.utils.OnRecycleItemClick;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;




import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/10.
 * 精品推荐的fragment
 */
public class HandpickFragment extends AbsBaseFragment implements View.OnClickListener {
    public static HandpickFragment newInstance() {
        
        Bundle args = new Bundle();
        
        HandpickFragment fragment = new HandpickFragment();
        fragment.setArguments(args);
        return fragment;
    }
    private RecyclerView rv;
    private HandpicAdapter adapter;
    private List<String> data;
    private ImageView popWindowImageView;
    private DrawerLayout rootView;
    private LinearLayout drawerView;
    private RecyclerView rvDrawer;
    private String list[] = {WebVelues.FORUM_ANSLESE_0, WebVelues.FORUM_ANSLESE_1, WebVelues.FORUM_ANSLESE_2, WebVelues.FORUM_ANSLESE_3
            , WebVelues.FORUM_ANSLESE_4, WebVelues.FORUM_ANSLESE_5, WebVelues.FORUM_ANSLESE_6, WebVelues.FORUM_ANSLESE_7
            , WebVelues.FORUM_ANSLESE_8, WebVelues.FORUM_ANSLESE_9, WebVelues.FORUM_ANSLESE_10, WebVelues.FORUM_ANSLESE_11
            , WebVelues.FORUM_ANSLESE_12, WebVelues.FORUM_ANSLESE_13, WebVelues.FORUM_ANSLESE_14, WebVelues.FORUM_ANSLESE_15
            , WebVelues.FORUM_ANSLESE_16, WebVelues.FORUM_ANSLESE_17, WebVelues.FORUM_ANSLESE_18, WebVelues.FORUM_ANSLESE_19
            , WebVelues.FORUM_ANSLESE_20, WebVelues.FORUM_ANSLESE_21, WebVelues.FORUM_ANSLESE_22, WebVelues.FORUM_ANSLESE_23
            , WebVelues.FORUM_ANSLESE_24, WebVelues.FORUM_ANSLESE_25, WebVelues.FORUM_ANSLESE_26, WebVelues.FORUM_ANSLESE_27
            , WebVelues.FORUM_ANSLESE_28, WebVelues.FORUM_ANSLESE_29, WebVelues.FORUM_ANSLESE_30, WebVelues.FORUM_ANSLESE_31
            , WebVelues.FORUM_ANSLESE_32, WebVelues.FORUM_ANSLESE_33, WebVelues.FORUM_ANSLESE_34, WebVelues.FORUM_ANSLESE_35
            , WebVelues.FORUM_ANSLESE_36, WebVelues.FORUM_ANSLESE_37, WebVelues.FORUM_ANSLESE_38, WebVelues.FORUM_ANSLESE_39, WebVelues.FORUM_ANSLESE_40};

    @Override
    protected int setLayout() {
        return R.layout.fragment_handpick;
    }

    @Override
    protected void initViews() {
        rv = byView(R.id.fragment_handpick_recycler);
        popWindowImageView = byView(R.id.handpick_popWindow_img);
        rootView = byView(R.id.main_foot);
        drawerView = byView(R.id.handpick_lL);
        rvDrawer = byView(R.id.handpick_rv);

    }

    @Override
    protected void initDatas() {
        //recycleView的行布局
        buildDatas();
        adapter = new HandpicAdapter(data, context);
        LinearLayoutManager manager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        rv.setLayoutManager(manager);
        rv.setAdapter(adapter);
        /**
         * 抽屉的recycle
         */
        LinearLayoutManager managers = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        rvDrawer.setLayoutManager(managers);
        rvDrawer.setAdapter(adapter);
        adapter.setOnRecycleItemClik(new OnRecycleItemClick() {
            @Override
            public void OnRvItemClicListener(int pos, String str) {
                FragmentManager managers = getChildFragmentManager();
                FragmentTransaction transaction = managers.beginTransaction();
                transaction.replace(R.id.fragment_picRecommend_replaceView, AllFragment.newInstance(list[pos]));
                transaction.commit();
            }
        });
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_picRecommend_replaceView, AllFragment.newInstance(WebVelues.FORUM_ANSLESE_0));
        fragmentTransaction.commit();
        /**
         * 抽屉点击事件
         */
        popWindowImageView.setOnClickListener(this);
    }

    private void buildDatas() {
        data = new ArrayList<>();
        data.
//        data.add("全部");
//        data.add("媳妇当车模");
//        data.add("美人" + "'记'");
//        data.add("论坛红人馆");
//        data.add("论坛讲师");
//        data.add("汽车之家十年");
//        data.add("精挑细选");
//        data.add("现身说法");
//        data.add("高端阵地");
//        data.add("电动车");
//        data.add("汇买车");
//        data.add("行车点评");
//        data.add("超级驾驶员");
//        data.add("海外购车");
//        data.add("经典老车");
//        data.add("妹子选车");
//        data.add("优惠购车");
//        data.add("原创大片");
//        data.add("顶配风采");
//        data.add("改装有理");
//        data.add("养车有道");
//        data.add("首发阵营");
//        data.add("新车直播");
//        data.add("历史选题");
//        data.add("摩友天地");
//        data.add("蜜月之旅");
//        data.add("甜蜜婚礼");
//        data.add("摄影课堂");
//        data.add("车友聚会");
//        data.add("单车部落");
//        data.add("杂谈俱乐部");
//        data.add("华北游记");
//        data.add("西南游记");
//        data.add("东北游记");
//        data.add("西北游记");
//        data.add("华中游记");
//        data.add("华南游记");
//        data.add("华东游记");
//        data.add("港澳台游记");
//        data.add("海外游记");
//        data.add("沧海遗珠");
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.handpick_popWindow_img:
                rootView.openDrawer(drawerView);
                break;
        }
    }
}
