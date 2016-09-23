package net.lidongdong.godcar.model.net;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by dllo on 16/9/21.
 * 内存缓存类
 */
public class MemoryCache implements ImageLoader.ImageCache {
    private LruCache<String,Bitmap> cache;

    public MemoryCache() {
        //手机最大内存
        long maxMemory=Runtime.getRuntime().maxMemory();
        //分配给图片缓存的内存,做单位换算和分配空间
        int maxSize= (int) (maxMemory/1024/4);
        cache =new LruCache<String, Bitmap>(maxSize){
            //设置每张图片占据的内存

            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes()*bitmap.getHeight()/1024;
            }
        };
    }

    @Override
    public Bitmap getBitmap(String url) {
        return cache.get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        cache.put(url,bitmap);
    }
}
