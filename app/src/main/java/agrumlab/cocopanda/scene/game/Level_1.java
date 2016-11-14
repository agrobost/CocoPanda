package agrumlab.cocopanda.scene.game;

import android.graphics.Canvas;
import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;

import agrumlab.cocopanda.Surface;
import agrumlab.cocopanda.scene.GameObject;
import agrumlab.cocopanda.scene.game.game_objects.Bee;
import agrumlab.cocopanda.scene.game.game_objects.Coco;
import agrumlab.cocopanda.scene.game.game_objects.Coeur;
import agrumlab.cocopanda.scene.game.game_objects.Wallpaper;

/**
 * Created by Alexandre on 28/01/2015.
 */
public class Level_1 extends Level {

    private double mark = 0;
    private double time = 0;
    private double lapse = 0;

    public Level_1(Surface surface) {
        super(surface);
        super.oneStar = 40; //60s
        super.twoStar = 65; //80s
        super.threeStar = 80; //100s
        super.reference = "level_one";
        float difficult = 500f;
        for(int i = 0; i<15; i++){
            gameObjects.add(new Coco(this,difficult*2*i,600f,0f));
            gameObjects.add(new Coco(this,difficult*2*i,600f,0.25f));
            gameObjects.add(new Coco(this,difficult*2*i,600f,0.5f));
            gameObjects.add(new Coco(this,difficult*2*i,600f,0.75f));
            gameObjects.add(new Coco(this,difficult*2*i,600f,1f));

            gameObjects.add(new Coco(this,difficult+difficult*2*i,600f,0.125f));
            gameObjects.add(new Coco(this,difficult+difficult*2*i,600f,0.375f));
            gameObjects.add(new Coco(this,difficult+difficult*2*i,600f,0.625f));
            gameObjects.add(new Coco(this,difficult+difficult*2*i,600f,0.875f));
        }







    }


    @Override
    public void drawScene(Canvas canvas) {
        wallpaper.draw(canvas);
        if (mark == 0) {
            mark = System.currentTimeMillis();
        }
        if (running) {
            pauseIcon.draw(canvas);
            lapse = System.currentTimeMillis() - mark;
            time += lapse;
            mark = System.currentTimeMillis();
        } else {
            mark = System.currentTimeMillis();
        }
        score.drawScene(canvas, running, (float) time);
        for (Iterator<GameObject> iterator = gameObjects.iterator(); iterator.hasNext(); ) {

            GameObject gameObject = iterator.next();
            if (gameObject.getStartTime() > time) {
                break;
            }

            if (running) {
                gameObject.animation(iterator, (float) lapse);
                gameObject.ifCollision(panda, iterator);
            }
            gameObject.draw(canvas);


        }

        panda.draw(canvas);


    }


}
