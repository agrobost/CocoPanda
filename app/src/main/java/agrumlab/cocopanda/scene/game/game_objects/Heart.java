package agrumlab.cocopanda.scene.game.game_objects;

import android.graphics.Canvas;

import java.util.Iterator;
import java.util.Random;

import agrumlab.cocopanda.R;
import agrumlab.cocopanda.ressources.CanvasManager;
import agrumlab.cocopanda.ressources.BitmapsManager;
import agrumlab.cocopanda.ressources.ScreenManager;
import agrumlab.cocopanda.ressources.SoundManager;
import agrumlab.cocopanda.scene.GameObject;
import agrumlab.cocopanda.scene.Scene;
import agrumlab.cocopanda.scene.game.GameScene;

public class Heart extends GameObject {
    private Random random = new Random();
    //on peu rajouter une animation(par ex mouvement de feuille qui tombe), mais modifier collision et draw

    public Heart(Scene scene, float startTime, float vitesseY, float percentageX) {
        super(scene, startTime);
        super.bitmap = BitmapsManager.GAME_HEART_GAMEOBJECT.getBitmap();
        super.coord = new float[]{ScreenManager.width*percentageX - bitmap.getWidth()/2+ ScreenManager.width/2,-bitmap.getHeight()};
        super.speed[1] = vitesseY;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, super.getCoordOnScreen()[0], super.getCoordOnScreen()[1], CanvasManager.getPaint(CanvasManager.IMAGE_HD));
    }

    @Override
    public void animation(Iterator<GameObject> iterator, float time) {
        if(super.coord[1]> ScreenManager.height){
            iterator.remove();
        }else {
            super.coord[1] = super.coord[1] + super.speed[1] * time/1000f;
        }
    }



    @Override
    protected void inCollision(GameObject panda, Iterator iterator) {
        SoundManager.playSoundEffect(R.raw.vie);
        GameScene gameScene = scene.getSurface().getGameScene();
        gameScene.getScore().setNumberLife(gameScene.getScore().getNumberLife() + 1);
        iterator.remove();
    }
}
