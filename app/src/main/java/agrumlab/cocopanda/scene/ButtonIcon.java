package agrumlab.cocopanda.scene;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.MotionEvent;

import java.util.ArrayList;

import agrumlab.cocopanda.ressources.CanvasManager;
import agrumlab.cocopanda.ressources.Screen;

public abstract class ButtonIcon{
    private ArrayList observers;
    private Bitmap icon = null;
    protected Scene scene;
    private float[] coord = {0f, 0f};

    public ButtonIcon(Scene scene, Bitmap icon, float[] coord) {
        //penser a adpater coord
        this.scene = scene;
        this.icon = icon;
        this.coord[0] = coord[0] * Screen.width / 1080f;
        this.coord[1] = coord[1] * Screen.height / 1920f;
        observers = new ArrayList();
    }

    protected abstract void click();

    private boolean down = false;

    public void actionDown(MotionEvent event) {
        if (event.getX() >= coord[0] && event.getX() <= coord[0] + icon.getWidth() && event.getY() >= coord[1] && event.getY() <= coord[1] + icon.getHeight()) {
            down = true;
        } else {
            down = false;
        }
    }

    //si le doigt ne sort pas du bouton
    public void actionMove(MotionEvent event) {
        if (!(event.getX() >= coord[0] && event.getX() <= coord[0] + icon.getWidth() && event.getY() >= coord[1] && event.getY() <= coord[1] + icon.getHeight())) {
            down = false;
        } else {
            down = true;
        }
    }

    public void actionUp(MotionEvent event) {
        if (down) {
            down = false;
            click();
        }
    }


    public void draw(Canvas canvas) {
        canvas.drawBitmap(icon, coord[0], coord[1], CanvasManager.getPaint(CanvasManager.IMAGE_HD));

    }

}