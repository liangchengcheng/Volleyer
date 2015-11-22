package mddemo.library.com.volley;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年11月8日22:34:53
 * Description:volley请求的封装
 */
public class GsonRequest<T> extends Request<T> {
    private final Response.Listener<T> mListener;
    private Gson mGson;
    private Class<T> mClass;

    /**
     * GsonRequest的构造函数
     * @param method 请求的方式
     * @param url    请求的url地址
     * @param clazz  传入进来的类型[暂时删除]
     * @param listener 监听器
     * @param errorListener 错误的监听
     */
    public GsonRequest(int method, String url,Class<T> clazz,  Response.Listener<T> listener,
                       Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        mGson = new Gson();
        mClass = clazz;
        mListener = listener;
    }
    /**
     *构造函数
     * @param url    请求的url地址
     * @param clazz  传入进来的类型[暂时删除]
     * @param listener 监听器
     * @param errorListener 错误的监听
     */
    public GsonRequest(String url, Class<T> clazz, Response.Listener<T> listener,
                       Response.ErrorListener errorListener) {
        this(Method.GET, url, clazz, listener, errorListener);
    }
    /**
     * 在这里我先暂时的写死成具体的数据类，到时候看看怎么修改这块
     * @param response volleyresponse
     * @return  json  by  gson to list<Objetc>
     */
    @Override
    protected Response <T> parseNetworkResponse(NetworkResponse response) {
        try {
            String jsonString = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            //此处对数据是否为空做判断
            return Response.success(VolleyGson.getBean(jsonString,mClass),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }
    }
    /**
     * 处理错误
     * @param response 响应流
     */
    @Override
    protected void deliverResponse(T response) {
        mListener.onResponse(response);
    }

}
