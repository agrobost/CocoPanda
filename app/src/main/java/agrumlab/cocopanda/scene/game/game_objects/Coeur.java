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
 * Created by Alexandre on 31/01/2015.
 */
public class Coeur extends GameObject {
    private Random random = new Random();
    //on peu rajouter une animation(par ex mouvement de feuille qui tombe), mais modifier collision et draw

    public Coeur(Scene scene, int vitesseY_min, int vitesseY_max) {
        super(scene);
        super.bitmap = EnumBitmaps.OBJECT_HEART.geBitmap();

        float x, y;
        y = -bitmap.getHeight();
        x = (random.nextInt((int) Screen.width) - (bitmap.getWidth() / 2))+ Screen.width /2;
        super.coord = new float[]{x,y};

        super.vitesse[1] = Screen.height *(random.nextInt(vitesseY_max - vitesseY_min + 1) + vitesseY_min)/1920;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, super.getCoordOnScreen()[0], super.getCoordOnScreen()[1], CanvasManager.getPaint(CanvasManager.IMAGE_HD));
    }


    @Override
    public void animation(Iterator iterator) {
        if(super.coord[1]> Screen.height){
            /*
            super.coord[1] = -bitmap.getHeight();
            super.coord[0] = (random.nextInt(1080) - (bitmap.getWidth() / 2))+1080/2;
            */
            iterator.remove();

        }else {
            super.coord[1] = super.coord[1] + super.vitesse[1] + scene.getSurface().getLevel().getSpeed();
        }
    }

    @Override
    protected void inCollision(GameObject panda, Iterator iterator) {
        SoundManager.playSoundEffect(R.raw.vie);
        Level level = scene.getSurface().getLevel();
        level.getScore().setNumberLife(level.getScore().getNumberLife() + 1);
        iterator.remove();
    }
}
