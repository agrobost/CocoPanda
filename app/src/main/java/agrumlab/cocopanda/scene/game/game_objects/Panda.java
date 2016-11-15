package agrumlab.cocopanda.scene.game.game_objects;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.MotionEvent;

import java.util.Iterator;

import agrumlab.cocopanda.ressources.BitmapsManager;
import agrumlab.cocopanda.ressources.CanvasManager;
import agrumlab.cocopanda.ressources.PreferenceMemory;
import agrumlab.cocopanda.ressources.ScreenManager;
import agrumlab.cocopanda.scene.GameObject;
import agrumlab.cocopanda.scene.Scene;

/**
 * Created by Alexandre on 30/01/2015.
 */

public class Panda extends GameObject {

    //un peu rajouter une animation(par ex pour simuler un leger mouvemen), mais modifier collision et draw

    public Panda(Scene scene) {
        super(scene,0f);
        super.bitmap = BitmapsManager.GAME_PANDA_GAMEOBJECT.getBitmap();

        float x, y;
        x = ScreenManager.width - bitmap.getWidth() / 2;
        y = ScreenManager.height * 1531 / 1920 - bitmap.getHeight();

        super.coord = new float[]{x, y};
        this.sensitivity = PreferenceMemory.getSensitivity();
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, super.getCoordOnScreen()[0], super.getCoordOnScreen()[1], CanvasManager.getPaint(CanvasManager.IMAGE_HD));
    }

    @Override
    public void animation(Iterator<GameObject> iterator, float time) {

    }




    public Bitmap getBitmap() {
        return bitmap;
    }

    @Override
    protected void inCollision(GameObject gameObject, Iterator iterator) {
        //inutile
    }


    private float xDown = 0f, xMove = 0f, distanceDowntoMove = 0f;
    private float[] pandaInitial = {0f, 0f};
    private float sensitivity = (float) 1.7;

    public void actionDown(MotionEvent event) {
        if (event.getPointerCount() == 1 && event.getPointerId(0) == 0 && scene.getSurface().getGameScene().isRunning()) {
            xDown = event.getX();
            pandaInitial = getCoord();
        }
    }

    public void actionMove(MotionEvent event) {
        if (event.getPointerCount() == 1 && event.getPointerId(0) == 0 && scene.getSurface().getGameScene().isRunning()) {
            xMove = event.getX();
            //pour width screen
            distanceDowntoMove = xMove - xDown;
            //pour les ecran dont la largeur nest pas 1080 => produit en crois pour conversion
            //* ScreenManager.dimScreen[0] / ActivityMain.size.x;

            if (pandaInitial[0] + distanceDowntoMove * sensitivity > ScreenManager.width /2-getBitmap().getWidth()/2 && pandaInitial[0] + distanceDowntoMove * sensitivity < (3* ScreenManager.width /2)-getBitmap().getWidth()/2) {
                setCoord(new float[]{pandaInitial[0] + distanceDowntoMove * sensitivity, pandaInitial[1]});
                scene.getSurface().getGameScene().getCamera().setCoordCamera(new float[]{ScreenManager.width / 2 - ScreenManager.width + getCoord()[0], scene.getSurface().getGameScene().getCamera().getCoordCamera()[1]});
            }else{
                xDown = event.getX();
                pandaInitial = getCoord();
            }
        }else{
            xDown = event.getX();
            pandaInitial = getCoord();
        }
    }

    public void setSensitivity(float sensitivity) {
        this.sensitivity = sensitivity;
    }
}
