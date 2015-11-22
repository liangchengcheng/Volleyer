package mddemo.library.com.volley;

import android.graphics.Canvas;

import com.android.volley.Response;
import com.android.volley.VolleyError;



/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年11月8日22:26:49
 * Description:Volley的数据
 */
public class VolleyManager<T> {

    public void loadData(String URL_HEAD,  final Class<T> cls, final VolleyResponseCallback callback) {
        GsonDecode<T> mClubDd = new GsonDecode<T>();
        mClubDd.getGsonData(URL_HEAD, cls,new successListener(callback)
                ,new errorListener(callback)
        );
    }

    class  successListener implements Response.Listener<T>{

        VolleyResponseCallback callback;
        successListener(VolleyResponseCallback callback){
           this.callback=callback;
        }
        @Override
        public void onResponse(T response) {
            callback.onSuccess(response);
        }
    }

    class errorListener implements Response.ErrorListener{

        VolleyResponseCallback callback;
        errorListener(VolleyResponseCallback callback){
            this.callback=callback;
        }
        @Override
        public void onErrorResponse(VolleyError error) {
            callback.onError("time out");
        }
    }

}
