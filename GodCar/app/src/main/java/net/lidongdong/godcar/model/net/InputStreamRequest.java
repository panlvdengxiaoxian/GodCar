package net.lidongdong.godcar.model.net;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Created by dllo on 16/9/21.
 * 自定义Volley请求
 */
public class InputStreamRequest extends Request<InputStream> {

    private final Response.Listener<InputStream> listener;

    public InputStreamRequest(int method, String url, Response.ErrorListener listener, Response.Listener<InputStream> listener1) {
        super(method, url, listener);
        this.listener = listener1;
    }

    public InputStreamRequest(String url, Response.Listener<InputStream> listener, Response.ErrorListener err) {
        this(Method.GET,url, err, listener);
    }


    @Override
    protected Response<InputStream> parseNetworkResponse(NetworkResponse response) {
        InputStream is = new ByteArrayInputStream(response.data);
        return Response.success(is, HttpHeaderParser.parseCacheHeaders(response));
    }

    @Override
    protected void deliverResponse(InputStream response) {
        listener.onResponse(response);
    }

}
