package net.lidongdong.godcar.ui.activity;

import android.content.Intent;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import net.lidongdong.godcar.R;

/**
 * Created by 潘驴邓小娴 on 2016/9/23.
 * 最新详情页
 */
public class NewestFragmentToAty extends AbsActivity {
    private TextView titleTv;
    private WebView webView;

    @Override
    protected int setLayout() {
        return R.layout.activity_from_fragment;
    }

    @Override
    protected void initViews() {
        titleTv = byView(R.id.newFragmentToAty_titleTv);
        webView = byView(R.id.newest_web);
    }


    @Override
    protected void initDatas() {
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        titleTv.setText(title);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }

            @Override
            public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
                return false;
            }
        });
        WebSettings webSettings = webView.getSettings();
        // 让WebView能够执行javaScript
        webSettings.setJavaScriptEnabled(true);
        // 让JavaScript可以自动打开windows
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        // 设置缓存
        webSettings.setAppCacheEnabled(true);
        // 设置缓存模式,一共有四种模式
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        // 设置缓存路径
//        webSettings.setAppCachePath("");
        // 支持缩放(适配到当前屏幕)
        webSettings.setSupportZoom(true);
        // 将图片调整到合适的大小
        webSettings.setUseWideViewPort(true);
        // 支持内容重新布局,一共有四种方式
        // 默认的是NARROW_COLUMNS
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        // 设置可以被显示的屏幕控制
        webSettings.setDisplayZoomControls(true);
        // 设置默认字体大小
        webSettings.setDefaultFontSize(12);
//        webView.loadUrl(url2);

        // 2.加载Html的字符串
        // jquery
        // 设置编码格式
        // 使用WebView加载数据
        // 参数1: 字符串
        // 参数2: html格式的文本,编码格式是utf-8
//        webView.loadData(data,
//                "text/html; charset=UTF-8", null);

    }
}
