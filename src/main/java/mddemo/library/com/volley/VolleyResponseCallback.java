package mddemo.library.com.volley;
/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年11月8日22:30:01
 * Description:
 */

public interface VolleyResponseCallback {
	void onSuccess(Object object);
	void onError(String msg);
}
