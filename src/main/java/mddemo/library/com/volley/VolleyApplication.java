package mddemo.library.com.volley;

import android.app.Application;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年11月8日22:32:21
 * Description: 程序的application
 */

public class VolleyApplication extends Application {
    // Singleton application mInstance
    private static VolleyApplication mInstance;
    // Volley request queue
    private RequestQueue mRequestQueue;
    // Volley image cache
    private LruBitmapCache mLruBitmapCache;
    // Volley image loader
    private ImageLoader mImageLoader;
    // Volley RequestQueue
    public static RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        requestQueue = Volley.newRequestQueue(this);
        mInstance = this;
    }

    /**
     * 返回一个单例的NetApplication
     * @return 返回一个单例的NetApplication
     */
    public static VolleyApplication getInstance() {
        return mInstance;
    }

    /**
     * 返回一个volley的请求为了创建一个网络的请求
     * @return {@link RequestQueue}
     */
    public RequestQueue getVolleyRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(this);
        }
        return mRequestQueue;
    }

    private static void addRequest(Request<?> request) {
        getInstance().getVolleyRequestQueue().add(request);
    }

    public static void addRequest(Request<?> request, String tag) {
        request.setTag(tag);
        addRequest(request);
    }

    /**
     * 退出所有的消息队列
     * @param tag associated with the Volley requests to be cancelled
     */
    public static void cancelAllRequests(String tag) {
        if (getInstance().getVolleyRequestQueue() != null) {
            getInstance().getVolleyRequestQueue().cancelAll(tag);
        }
    }

    public ImageLoader getVolleyImageLoader() {
        if (mImageLoader == null) {
            mImageLoader = new ImageLoader
                    (
                            getVolleyRequestQueue(),
                            VolleyApplication.getInstance().getVolleyImageCache()
                    );
        }
        return mImageLoader;
    }

    //创建一个图片的缓存
    private LruBitmapCache getVolleyImageCache() {
        if (mLruBitmapCache == null) {
            mLruBitmapCache = new LruBitmapCache(mInstance);
        }
        return mLruBitmapCache;
    }

}

