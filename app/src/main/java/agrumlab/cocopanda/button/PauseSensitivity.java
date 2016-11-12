package agrumlab.cocopanda.button;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.MotionEvent;

import agrumlab.cocopanda.ressources.CanvasManager;
import agrumlab.cocopanda.ressources.EnumBitmaps;
import agrumlab.cocopanda.ressources.PreferenceMemory;
import agrumlab.cocopanda.ressources.Screen;
import agrumlab.cocopanda.scene.Scene;

/**
 * Created by Alexandre on 08/02/2015.
 */
public class PauseSensitivity {
    private Bitmap icon = null;
    private float[] coord = {0f, 0f};

    private float width_max, height_max;
    private float[] pointRepere;

    private boolean autorisation = false;
    private Scene scene;

    public PauseSensitivity(Scene scene) {
        this.scene = scene;
        pointRepere = new float[]{160f * Screen.adjustWidth, 968f * Screen.adjustHeight};
        width_max = 760 * Screen.adjustWidth;
        height_max = 65 * Screen.adjustHeight;
        this.icon = EnumBitmaps.PAUSE_SENSITIVITY.geBitmap();
        this.coord = new float[]{width_max * (PreferenceMemory.getSensitivity() - 1) + pointRepere[0], pointRepere[1]};
    }

    public void actionDown(MotionEvent event) {
        if (event.getX() >= pointRepere[0] && event.getX() <= pointRepere[0] + width_max & event.getY() >= pointRepere[1] - height_max / 2 && event.getY() <= pointRepere[1] + 2 * height_max) {
            this.coord[0] = event.getX();
            autorisation = true;
        }
    }

    public void actionMove(MotionEvent event) {
        if (autorisation && event.getX() >= pointRepere[0] && event.getX() <= pointRepere[0] + width_max) {
            this.coord[0] = event.getX();
        }
    }

    public void actionUp(MotionEvent event) {
        autorisation = false;
        float nvSensitivity = 1 + (this.coord[0] - pointRepere[0]) / width_max;
        PreferenceMemory.putSensitivity(nvSensitivity);
        this.scene.getSurface().getLevel().getPanda().setSensitivity(nvSensitivity);
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(icon, coord[0] - icon.getWidth() / 2, coord[1], CanvasManager.getPaint(CanvasManager.IMAGE_HD));
    }
}

