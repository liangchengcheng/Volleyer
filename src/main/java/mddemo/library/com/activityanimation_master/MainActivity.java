package mddemo.library.com.activityanimation_master;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import mddemo.library.com.volley.VolleyManager;
import mddemo.library.com.volley.VolleyResponseCallback;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        new Thread(new Runnable() {
            @Override
            public void run() {
                getData();
            }
        }).start();
    }

    private void getData(){
        VolleyManager manager=new VolleyManager();
        manager.loadData("http://www.17yxb.cn/GameHandler.ashx?pd=1", JavaBean.class, new VolleyResponseCallback() {
            @Override
            public void onSuccess(Object object) {
                Toast.makeText(MainActivity.this,((JavaBean)object).getDs().get(0).getId(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(String msg) {

            }
        });
    }
}
