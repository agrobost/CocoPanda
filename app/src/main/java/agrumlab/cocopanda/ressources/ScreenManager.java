package agrumlab.cocopanda.ressources;

import android.app.Activity;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;

import java.lang.reflect.Method;

/**
 * Created by Alexandre on 03/02/2015.
 */
public class ScreenManager {
    public static float width, height, adjustWidth, adjustHeight;

    public static void initialize(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();

        if (Build.VERSION.SDK_INT >= 17) {
            //new pleasant way to get real metrics
            DisplayMetrics realMetrics = new DisplayMetrics();
            display.getRealMetrics(realMetrics);
            width = realMetrics.widthPixels;
            height = realMetrics.heightPixels;

        } else if (Build.VERSION.SDK_INT >= 14) {
            //reflection for this weird in-between time
            try {
                Method mGetRawH = Display.class.getMethod("getRawHeight");
                Method mGetRawW = Display.class.getMethod("getRawWidth");
                width = (Integer) mGetRawW.invoke(display);
                height = (Integer) mGetRawH.invoke(display);
            } catch (Exception e) {
                //this may not be 100% accurate, but it's all we've got
                width = display.getWidth();
                height = display.getHeight();
                Log.e("Display Info", "Couldn't use reflection to get the real display metrics.");
            }

        } else {
            //This should be close, as lower API devices should not have window navigation bars
            width = display.getWidth();
            height = display.getHeight();
        }
        ScreenManager.adjustWidth = width / 1080f;
        ScreenManager.adjustHeight = height / 1920f;

    }

}
