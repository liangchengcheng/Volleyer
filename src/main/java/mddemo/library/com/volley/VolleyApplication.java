package mddemo.library.com.volley;

import android.app.Application;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Author:  �����
 * Email:   1038127753@qq.com
 * Date:    2015��11��8��22:32:21
 * Description: �����application
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
     * ����һ��������NetApplication
     * @return ����һ��������NetApplication
     */
    public static VolleyApplication getInstance() {
        return mInstance;
    }

    /**
     * ����һ��volley������Ϊ�˴���һ�����������
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
     * �˳����е���Ϣ����
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

    //����һ��ͼƬ�Ļ���
    private LruBitmapCache getVolleyImageCache() {
        if (mLruBitmapCache == null) {
            mLruBitmapCache = new LruBitmapCache(mInstance);
        }
        return mLruBitmapCache;
    }

}

