package agrumlab.cocopanda.scene.game.game_objects;

import android.graphics.Canvas;

import java.util.Iterator;

import agrumlab.cocopanda.ressources.BitmapsManager;
import agrumlab.cocopanda.ressources.CanvasManager;
import agrumlab.cocopanda.scene.GameObject;
import agrumlab.cocopanda.scene.Scene;

/**
 * Created by Alexandre on 30/01/2015.
 */

public class Background extends GameObject {

    public Background(Scene scene) {
        super(scene, 0f);
        super.bitmap = BitmapsManager.GAME_BACKGROUND_GAMEOBJECT.getBitmap();
    }

    @Override
    protected void inCollision(GameObject gameObject, Iterator iterator) {
        //inutile ici
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, super.getCoordOnScreen()[0], super.getCoordOnScreen()[1], CanvasManager.getPaint(CanvasManager.IMAGE_HD));
    }

    @Override
    public void animation(Iterator<GameObject> iterator, float time) {

    }


}
