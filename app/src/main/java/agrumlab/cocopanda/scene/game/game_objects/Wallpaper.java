package agrumlab.cocopanda.scene.game.game_objects;

import android.graphics.Canvas;

import java.util.Iterator;

import agrumlab.cocopanda.ressources.CanvasManager;
import agrumlab.cocopanda.ressources.EnumBitmaps;
import agrumlab.cocopanda.scene.GameObject;
import agrumlab.cocopanda.scene.Scene;

/**
 * Created by Alexandre on 30/01/2015.
 */

public class Wallpaper extends GameObject {

    public Wallpaper(Scene scene) {
        super(scene, 0f);
        super.bitmap = EnumBitmaps.GAME_BACKGROUND.getBitmap();
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
