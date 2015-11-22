package mddemo.library.com.volley;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;

/**
 * Author:  �����
 * Email:   1038127753@qq.com
 * Date:    2015��11��8��22:34:53
 * Description:volley����ķ�װ
 */
public class GsonRequest<T> extends Request<T> {
    private final Response.Listener<T> mListener;
    private Gson mGson;
    private Class<T> mClass;

    /**
     * GsonRequest�Ĺ��캯��
     * @param method ����ķ�ʽ
     * @param url    �����url��ַ
     * @param clazz  �������������[��ʱɾ��]
     * @param listener ������
     * @param errorListener ����ļ���
     */
    public GsonRequest(int method, String url,Class<T> clazz,  Response.Listener<T> listener,
                       Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        mGson = new Gson();
        mClass = clazz;
        mListener = listener;
    }
    /**
     *���캯��
     * @param url    �����url��ַ
     * @param clazz  �������������[��ʱɾ��]
     * @param listener ������
     * @param errorListener ����ļ���
     */
    public GsonRequest(String url, Class<T> clazz, Response.Listener<T> listener,
                       Response.ErrorListener errorListener) {
        this(Method.GET, url, clazz, listener, errorListener);
    }
    /**
     * ������������ʱ��д���ɾ���������࣬��ʱ�򿴿���ô�޸����
     * @param response volleyresponse
     * @return  json  by  gson to list<Objetc>
     */
    @Override
    protected Response <T> parseNetworkResponse(NetworkResponse response) {
        try {
            String jsonString = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            //�˴��������Ƿ�Ϊ�����ж�
            return Response.success(VolleyGson.getBean(jsonString,mClass),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }
    }
    /**
     * �������
     * @param response ��Ӧ��
     */
    @Override
    protected void deliverResponse(T response) {
        mListener.onResponse(response);
    }

}
