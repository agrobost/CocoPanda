package agrumlab.cocopanda.ressources;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

import java.util.HashMap;

public class CanvasManager {

    private static HashMap<Integer, Paint> paint = null;

    public static final int IMAGE_HD = 1;
    public static final int TEXT_PAUSE_LOOSE = 2;
    public static final int TEXT_SCORE = 3;

    private static Typeface typeface = Typeface.createFromAsset(GameApplication.getAppContext().getAssets(), "POPLARSTD.OTF");

    private static void load() {

        paint = new HashMap<>();

        Paint imageHD = new Paint();
        imageHD.setAntiAlias(true);
        imageHD.setFilterBitmap(true);
        imageHD.setDither(true);
        paint.put(IMAGE_HD, imageHD);

        Paint textPause = new Paint();
        textPause.setARGB(255, 0, 0, 0);
        textPause.setTextAlign(Paint.Align.LEFT);
        textPause.setTextSize(22 * GameApplication.getAppContext().getResources().getDisplayMetrics().density);
        textPause.setTypeface(typeface);
        paint.put(TEXT_PAUSE_LOOSE, textPause);


        Paint textScore = new Paint();
        textScore.setARGB(185, 255, 255, 255);
        textScore.setTextAlign(Paint.Align.LEFT);
        textScore.setTextSize(22 * GameApplication.getAppContext().getResources().getDisplayMetrics().density);
        textScore.setTypeface(typeface);
        paint.put(TEXT_SCORE, textScore);
    }


    public static Paint getPaint(int ref) {
        if (paint == null) {
            load();
        }
        return paint.get(ref);
    }

    public static void drawBitmapAdjust(Canvas canvas, Bitmap bitmap, float x, float y, Paint paint1) {
        canvas.drawBitmap(bitmap, x * Screen.adjustWidth, y * Screen.adjustHeight, paint1);
    }

    public static void drawTextAdjust(Canvas canvas, String text, float x, float y, Paint paint1) {
        canvas.drawText(text, x * Screen.adjustWidth, y * Screen.adjustHeight, paint1);
    }

}
