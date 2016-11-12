package agrumlab.cocopanda.scene.game.game_objects;

import android.graphics.Canvas;

import java.util.Iterator;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

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
public class SlowingDown extends GameObject {

    private Random random = new Random();

    public SlowingDown(Scene scene, int vitesseY_min, int vitesseY_max) {
        super(scene);
        super.bitmap = EnumBitmaps.OBJECT_TIMER.geBitmap();

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
        SoundManager.playSoundEffect(R.raw.timer);
        Level level = scene.getSurface().getLevel();
        iterator.remove();
        scene.getSurface().getLevel().setSpeed(-10f * Screen.adjustHeight);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                scene.getSurface().getLevel().setSpeed(0);
            }
        },5000);
        //le top serait de créer une fonction destroy dans game_object_coco pour lancer une animation de l'explosion de la game_object_coco et la détruire par la suite
        //aussi lancer une animation sur le panda genre le front rouge
    }
}
