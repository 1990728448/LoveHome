package org.example.xinda_05.util.SharedPreferences;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Jerry Mouse on 2016/8/14.
 */
public class SharedPreferencesUtil {

    private static Context contexts;
    private SharedPreferences instance=null;
    private SharedPreferences.Editor editor=null;

    public SharedPreferencesUtil(Context contexts) {
        this.contexts=contexts;
    }

    public void addInfo(String state, String Values){
        instance=contexts.getSharedPreferences(state, Activity.MODE_APPEND);
        editor=instance.edit();
        editor.putString(state,Values);
        editor.commit();
    }

    /**
     *  全局的登录信息，默认为0,未登录， 1为登录中。
     * @author Jerry Mouse
     * @time 2016/8/14 23:21
     * @effect 
     */
    
    public String queryLogin(String state){
        instance=contexts.getSharedPreferences(state,Activity.MODE_APPEND);
        String msg=instance.getString(state,"0");
        return msg;
    }


}
