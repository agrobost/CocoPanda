package agrumlab.cocopanda.ressources;

/**
 * Created by Alexandre on 12/11/2016.
 */


import android.app.Application;
import android.content.Context;

/**
 * Created by Alexandre on 29/12/2014.
 */
public class GameApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        GameApplication.context = getApplicationContext();
    }

    public static Context getAppContext(){
        return GameApplication.context;
    }
}
