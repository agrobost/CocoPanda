package agrumlab.cocopanda.scene.game;

import android.graphics.Canvas;

import java.util.Iterator;

import agrumlab.cocopanda.Surface;
import agrumlab.cocopanda.scene.GameObject;
import agrumlab.cocopanda.scene.game.game_objects.Coconut;

/**
 * Created by Alexandre on 28/01/2015.
 */
public class Level1Scene extends GameScene {

    private double mark = 0;
    private double time = 0;
    private double lapse = 0;

    public Level1Scene(Surface surface) {
        super(surface);
        super.oneStar = 40; //60s
        super.twoStar = 65; //80s
        super.threeStar = 80; //100s
        super.reference = "level_one";
        float difficult = 525;
        for (int i = 0; i < 15; i++) {
            gameObjects.add(new Coconut(this, difficult * 2 * i, 600f, 0f));
            gameObjects.add(new Coconut(this, difficult * 2 * i, 600f, 0.25f));
            gameObjects.add(new Coconut(this, difficult * 2 * i, 600f, 0.5f));
            gameObjects.add(new Coconut(this, difficult * 2 * i, 600f, 0.75f));
            gameObjects.add(new Coconut(this, difficult * 2 * i, 600f, 1f));
            gameObjects.add(new Coconut(this, difficult + difficult * 2 * i, 600f, 0.125f));
            gameObjects.add(new Coconut(this, difficult + difficult * 2 * i, 600f, 0.375f));
            gameObjects.add(new Coconut(this, difficult + difficult * 2 * i, 600f, 0.625f));
            gameObjects.add(new Coconut(this, difficult + difficult * 2 * i, 600f, 0.875f));
        }
    }

    @Override
    public void drawScene(Canvas canvas) {
        background.draw(canvas);
        if (mark == 0) {
            mark = System.currentTimeMillis();
        }
        if (running) {
            pauseButton.draw(canvas);
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
