package application;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Jerry Mouse on 2016/8/8.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
