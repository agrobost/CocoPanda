package agrumlab.cocopanda.scene.game;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.Iterator;

import agrumlab.cocopanda.Surface;
import agrumlab.cocopanda.ressources.SoundManager;
import agrumlab.cocopanda.scene.game.game_objects.Bee;
import agrumlab.cocopanda.scene.game.game_objects.Coco;
import agrumlab.cocopanda.scene.game.game_objects.Coeur;
import agrumlab.cocopanda.scene.GameObject;
import agrumlab.cocopanda.scene.game.game_objects.Coin;
import agrumlab.cocopanda.scene.game.game_objects.SlowingDown;

/**
 * Created by Alexandre on 28/01/2015.
 */
public class Level_1 extends Level {

    private double repere = 0;
    private double duree = 0;
    private int difficult = 0;

    public Level_1(Surface surface) {
        super(surface);
        super.oneStar = 40; //60s
        super.twoStar = 65; //80s
        super.threeStar = 80; //100s
        super.reference = "level_one";
        gameObjtByLvl.put(0, new GameObject[]{new Coco(this, 20, 25), new Coeur(this, 10, 20), new Bee(this, 20, 25)});
        gameObjtByLvl.put(1, new GameObject[]{new Coco(this, 20, 25), new Coeur(this, 10, 20)});
        gameObjtByLvl.put(2, new GameObject[]{new Coco(this, 25, 30), new Bee(this, 20, 25)});
        gameObjtByLvl.put(3, new GameObject[]{new Coco(this, 25, 30), new Coeur(this, 10, 20)});
        gameObjtByLvl.put(4, new GameObject[]{new Coco(this, 30, 31), new SlowingDown(this, 10, 20)});
        gameObjtByLvl.put(5, new GameObject[]{new Coco(this, 30, 32), new Bee(this, 20, 25), new Coin(this, 20, 25)});
        gameObjtByLvl.put(6, new GameObject[]{new Coco(this, 30, 33), new Coeur(this, 10, 20)});
        gameObjtByLvl.put(7, new GameObject[]{new Coco(this, 30, 34), new Coin(this, 20, 25)});
        gameObjtByLvl.put(8, new GameObject[]{new Coco(this, 35, 36), new Coeur(this, 20, 30), new Bee(this, 20, 25)});
        gameObjtByLvl.put(9, new GameObject[]{new Coco(this, 35, 37), new SlowingDown(this, 20, 30)});
        gameObjtByLvl.put(10, new GameObject[]{new Coco(this, 35, 38), new Coeur(this, 10, 20), new Coin(this, 20, 25)});
        gameObjtByLvl.put(11, new GameObject[]{new Coco(this, 35, 39), new SlowingDown(this, 20, 30), new Coeur(this, 20, 30)});
        gameObjtByLvl.put(12, new GameObject[]{new Coco(this, 40, 41), new Coeur(this, 10, 20), new Bee(this, 20, 25)});
        gameObjtByLvl.put(13, new GameObject[]{new Coco(this, 40, 42), new SlowingDown(this, 20, 30), new Coeur(this, 20, 30)});
        gameObjtByLvl.put(14, new GameObject[]{new Coco(this, 40, 43), new Coeur(this, 10, 20), new Coin(this, 20, 25)});
        gameObjtByLvl.put(15, new GameObject[]{new Coco(this, 40, 44), new SlowingDown(this, 30, 40)});
        gameObjtByLvl.put(16, new GameObject[]{new Coco(this, 45, 46), new Coeur(this, 30, 40), new Bee(this, 20, 25)});
        gameObjtByLvl.put(17, new GameObject[]{new Coco(this, 45, 47), new SlowingDown(this, 30, 40)});
        gameObjtByLvl.put(18, new GameObject[]{new Coco(this, 45, 60), new Coeur(this, 30, 40), new Coin(this, 20, 25)});
        gameObjtByLvl.put(19, new GameObject[]{new Coco(this, 45, 60), new SlowingDown(this, 30, 40), new Bee(this, 20, 25)});

    }


    @Override
    public void drawScene(Canvas canvas) {


        wallpaper.draw(canvas);

        if (running) {
            pauseIcon.draw(canvas);
        }
        score.drawScene(canvas, running);

        //update difficult lvl
        if (running && difficult < gameObjtByLvl.size()) {
            duree = System.currentTimeMillis() - repere;
            if (7e3 < duree || difficult == 0) {
                repere = System.currentTimeMillis();
                for (GameObject gameObjectParcouru : gameObjtByLvl.get(difficult)) {
                    gameObjects.add(gameObjectParcouru);
                }
                difficult++;
            }

        } else {
            repere = System.currentTimeMillis() - duree;
        }

        //fetch gameObject
        for (Iterator<GameObject> iterator = getGameObjects().iterator(); iterator.hasNext(); ) {
            GameObject gameObjectParcouru = iterator.next();


            gameObjectParcouru.draw(canvas);

            //update data
            if (running) {
                gameObjectParcouru.animation(iterator);
                gameObjectParcouru.ifCollision(panda, iterator);
            }
        }
        panda.draw(canvas);


    }

    public ArrayList<GameObject> getGameObjects() {
        return gameObjects;
    }

}
