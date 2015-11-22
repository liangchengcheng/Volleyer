package mddemo.library.com.volley;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;
import android.view.ViewGroup.LayoutParams;
import com.android.volley.toolbox.ImageLoader;

import java.lang.reflect.Field;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年11月22日17:05:55
 * Description:
 */
public class VolleyImageLoader {

    public static void getImage(Context context , ImageView v , String iamgeUrl , int defaultImageResId, int errorImageResId){
        getImage(context, v, iamgeUrl, defaultImageResId, errorImageResId, 0, 0);
    }


    public static void getImage(Context context , ImageView v , String iamgeUrl , int defaultImageResId, int errorImageResId,int maxWidth,int maxHeight){
        try {
            ImageLoader imageLoader = VolleyApplication.getInstance().getVolleyImageLoader();
            ImageLoader.ImageListener listener = ImageLoader.getImageListener(v, defaultImageResId, errorImageResId);
            ImageSize imageSize = getImageViewWidth(v);

            if(maxWidth != 0 && maxHeight != 0){
                imageSize.width = maxWidth;
                imageSize.height = maxHeight;
            }

            Log.d("imageSize", "width>>" + imageSize.width + "height>>" + imageSize.height);
            imageLoader.get(iamgeUrl, listener,imageSize.width,imageSize.height);

        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    /**
     * 根据ImageView获得适当的压缩的宽和高
     * @param imageView 图片控件
     * @return 尺寸
     */
    private static ImageSize getImageViewWidth(ImageView imageView) {
        ImageSize imageSize = new ImageSize();
        final DisplayMetrics displayMetrics = imageView.getContext().getResources().getDisplayMetrics();
        final LayoutParams params = imageView.getLayoutParams();

        int width = params.width == LayoutParams.WRAP_CONTENT ? 0 : imageView
                .getWidth();
        if (width <= 0)
            width = params.width;
        if (width <= 0)
            width = getImageViewFieldValue(imageView, "mMaxWidth");
        if (width <= 0)
            width = 350;
        int height = params.height == LayoutParams.WRAP_CONTENT ? 0 : imageView
                .getHeight();
        if (height <= 0)
            height = params.height;
        if (height <= 0)
            height = getImageViewFieldValue(imageView, "mMaxHeight");
        if (height <= 0)
            height = 350;
        imageSize.width = width;
        imageSize.height = height;
        return imageSize;

    }

    private static class ImageSize {
        int width;
        int height;
    }

    /**
     * 反射获得ImageView设置的最大宽度和高度
     * @param object
     * @param fieldName
     * @return
     */
    private static int getImageViewFieldValue(Object object, String fieldName) {
        int value = 0;
        try {
            Field field = ImageView.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            int fieldValue = (Integer) field.get(object);
            if (fieldValue > 0 && fieldValue < Integer.MAX_VALUE) {
                value = fieldValue;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

}
