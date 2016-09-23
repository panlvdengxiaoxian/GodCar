package net.lidongdong.godcar.model.net;

import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.lidongdong.godcar.R;
import net.lidongdong.godcar.ui.app.MyApp;

import org.json.JSONObject;

import java.util.Map;

/**
 * Created by dllo on 16/9/21.
 * 封装Volley
 */
public class VolleyInstance {
    /**
     * 如何单例一个类的对象
     * 1.定义当前类的静态对象
     * 2.对外提供获取方法
     * 3.私有化构造方法
     */
    /**
     * 网络请求单例需要的内容
     * 1.定义请求队列并初始化
     * 2.提供请求方法
     */

    private RequestQueue queue;
    private ImageLoader imageLoader;
    //定义加载图片的ImageLoader
    private VolleyInstance(){
        queue= Volley.newRequestQueue(MyApp.getContext());
        //在构造方法中实例化ImageLoader
        imageLoader=new ImageLoader(queue,new MemoryCache());
    }
    private static  VolleyInstance instance;
    public static VolleyInstance getInstance(){
        if (instance==null){
            synchronized (VolleyInstance.class){
                if (instance==null){
                    instance=new VolleyInstance();
                }
            }
        }
        return instance;
    }
   /**~~~~~~~~~~~~~~~  请求数据   ~~~~~~~~~~~~~~~~*/
    /**
     * 对外提供的方法
     * @param url
     * @param result
     * @param who
     */
   public void startRequest(String url,IVolleyResult result,int who){
       getInstance()._startRequest(url,result,who);
   }

    /**
     *
     * @param url 网址
     * @param result 网络请求的结果的接口对象
     * @param who 区分是谁发出的请求
     */

    private void _startRequest(String url, final IVolleyResult result, final int who) {
        StringRequest sr=new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                 result.success(response,who);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                result.failure();
            }
        });
     getInstance().addQueue(sr);

    }


    public void startRequest(int method,String url,final IVolleyResult result,final int who,final Map<String,String> heads){
        getInstance()._startRequest(method,url,result,who,heads);
    }


    /**
     *
     其他:带请求头,带请求方法的请求
          对内提供
     * @param method
     * @param url
     * @param result
     * @param who
     * @param heads
     */
    private void _startRequest(int method, String url, final IVolleyResult result, final int who,final Map<String,String> heads ) {
        JsonObjectRequest jor=new JsonObjectRequest(method, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                result.success(response.toString(),who);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                result.failure();
            }
        }){
           public Map<String,String> getheaders() throws AuthFailureError{
               return heads;
           }
        };
        getInstance().addQueue(jor);
    }

    private void addQueue(Request request) {
       if (queue!=null){
           queue.add(request);
       }
    }


    /**~~~~~~~~~~~~图片缓存加载~~~~~~~~~*/
    /**
     * 对外提供方法
     * @param imgUrl 图片网址
     * @param imageView 默认的图片
     */
    public void loadImage(String imgUrl, ImageView imageView){
        getInstance()._loadImage(imgUrl,imageView);
    }
    private void _loadImage(String imgUrl,ImageView imageView){
        ImageLoader.ImageListener imageListener=ImageLoader.getImageListener(imageView,R.mipmap.nvjing,R.mipmap.nvjing);
        imageLoader.get(imgUrl,imageListener);
    }

    /**
     *
     * @param url  图片网址
     * @param imageView 显示的imageView
     * @param defaultImgId  默认的图片,
     * @param errorImgId  加载失败后显示的图片
     */
    public void loadImage(String url,ImageView imageView,int defaultImgId,int errorImgId){
        getInstance()._loadImage(url,imageView,defaultImgId,errorImgId);
    }

    private void _loadImage(String url, ImageView imageView, int defaultImgId, int errorImgId) {
        ImageLoader.ImageListener imageListener=ImageLoader.getImageListener(imageView,defaultImgId,errorImgId);
        imageLoader.get(url,imageListener);
    }


}
