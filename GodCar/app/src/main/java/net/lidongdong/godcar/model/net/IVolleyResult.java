package net.lidongdong.godcar.model.net;

/**
 * Created by dllo on 16/9/21.
 * Volley结果的接口
 */
public interface IVolleyResult {
    /**
     * 请求成功的回调方法
     * @param str 返回的网络
     * @param who 谁发出的网络请求
     */
    void success(String str,int who);
    void success(String str);

    void failure();
}
