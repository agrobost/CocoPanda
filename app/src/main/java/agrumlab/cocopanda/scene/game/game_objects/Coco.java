package agrumlab.cocopanda.scene.game.game_objects;

import android.graphics.Canvas;

import java.util.Iterator;
import java.util.Random;

import agrumlab.cocopanda.R;
import agrumlab.cocopanda.ressources.CanvasManager;
import agrumlab.cocopanda.ressources.EnumBitmaps;
import agrumlab.cocopanda.ressources.Screen;
import agrumlab.cocopanda.ressources.SoundManager;
import agrumlab.cocopanda.scene.GameObject;
import agrumlab.cocopanda.scene.Scene;
import agrumlab.cocopanda.scene.game.Level;

/**
 * Created by Alexandre on 30/01/2015.
 */
public class Coco extends GameObject {


    public Coco(Scene scene, float startTime, float vitesseY, float percentageX) {
        super(scene, startTime);
        super.bitmap = EnumBitmaps.OBJECT_COCO.geBitmap();
        super.coord = new float[]{Screen.width*percentageX - bitmap.getWidth()/2+Screen.width/2, -bitmap.getHeight()};
        super.speed[1] = vitesseY;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, super.getCoordOnScreen()[0], super.getCoordOnScreen()[1], CanvasManager.getPaint(CanvasManager.IMAGE_HD));
    }


    @Override
    public void animation(Iterator<GameObject> iterator, float time) {
        if (super.coord[1] > Screen.height) {
            iterator.remove();
        } else {
            super.coord[1] = super.coord[1] + super.speed[1] * time / 1000f;
        }
    }

    @Override
    protected void inCollision(GameObject panda, Iterator iterator) {
        SoundManager.playSoundEffect(R.raw.collision_panda);
        Level level = scene.getSurface().getLevel();
        level.getScore().setNumberLife(level.getScore().getNumberLife() - 1);
        iterator.remove();
    }

}
