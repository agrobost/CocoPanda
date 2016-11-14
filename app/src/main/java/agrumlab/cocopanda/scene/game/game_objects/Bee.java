package agrumlab.cocopanda.scene.game.game_objects;

import android.graphics.Canvas;

import java.util.Iterator;

import agrumlab.cocopanda.R;
import agrumlab.cocopanda.ressources.CanvasManager;
import agrumlab.cocopanda.ressources.EnumBitmaps;
import agrumlab.cocopanda.ressources.Screen;
import agrumlab.cocopanda.ressources.SoundManager;
import agrumlab.cocopanda.scene.GameObject;
import agrumlab.cocopanda.scene.Scene;
import agrumlab.cocopanda.scene.game.Level;


public class Bee extends GameObject {


    public Bee(Scene scene, float startTime, float vitesseY, float vitesseX, float percentageX) {
        super(scene, startTime);
        super.bitmap = EnumBitmaps.OBJECT_BEE.getBitmap();
        super.coord = new float[]{Screen.width*percentageX - bitmap.getWidth()/2+Screen.width/2,-bitmap.getHeight()};

        super.speed[1] = vitesseY;
        super.speed[0] = vitesseX;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, super.getCoordOnScreen()[0], super.getCoordOnScreen()[1], CanvasManager.getPaint(CanvasManager.IMAGE_HD));
    }

    @Override
    public void animation(Iterator<GameObject> iterator, float time) {
        if(super.coord[1]> Screen.height){
            iterator.remove();
        }else {
            super.coord[1] = super.coord[1] + super.speed[1] * time / 1000f;
            if(super.coord[1]<Screen.height/3){
                return;
            }
            if(Math.abs(scene.getSurface().getLevel().getPanda().getCoord()[0]-this.coord[0])<10d){

            }
            else if(scene.getSurface().getLevel().getPanda().getCoord()[0]<this.coord[0]){
                super.coord[0] = super.coord[0] - super.speed[0] * time / 1000f;
            }else{
                super.coord[0] = super.coord[0] + super.speed[0] * time / 1000f;
            }
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
