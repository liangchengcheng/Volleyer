package mddemo.library.com.volley;

import com.android.volley.Response;


/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年11月8日22:34:48
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
