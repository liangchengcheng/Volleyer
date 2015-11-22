package mddemo.library.com.volley;

import com.android.volley.Response;


/**
 * Author:  �����
 * Email:   1038127753@qq.com
 * Date:    2015��11��8��22:34:48
 * Description:
 */
public class GsonDecode<T> {

    public void getGsonData(String url, Class<T> cls, Response.Listener<T> listener,
                            Response.ErrorListener errorListener) {

        GsonRequest<T> gsonRequest = new GsonRequest<T>(
                url,
                cls, listener, errorListener);
        VolleyApplication.requestQueue.add(gsonRequest);
    }
}
