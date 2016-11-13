package agrumlab.cocopanda.scene;


import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.Iterator;

import agrumlab.cocopanda.ressources.Screen;

public abstract class GameObject {

    protected float[] coord = {0f, 0f}, vitesse = {0f, 0f};
    protected Bitmap bitmap = null;
    protected Scene scene;

    public abstract void draw(Canvas canvas);

    public abstract void animation(Iterator iterator);

    public GameObject(Scene scene) {
        this.scene = scene;
    }

    public float[] getCoordOnScreen() {
        float[] coordbis = {((coord[0] - scene.getCamera().getCoordCamera()[0]) * Screen.width) / scene.getCamera().getDimCamera()[0], ((coord[1] - scene.getCamera().getCoordCamera()[1]) * Screen.height) / scene.getCamera().getDimCamera()[1]};
        return coordbis;
    }

    public float[] getCoord() {
        return coord;
    }

    public void setCoord(float[] coord) {
        this.coord = coord;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void ifCollision(GameObject gameObject, Iterator iterator) {

        boolean collisionX, collisionY;

        //collision x
        if ((getCoord()[0] >= gameObject.getCoord()[0] && getCoord()[0] <= (gameObject.getCoord()[0] + gameObject.getBitmap().getWidth())) || ((getCoord()[0] + getBitmap().getWidth()) > gameObject.getCoord()[0] && (getCoord()[0] + getBitmap().getWidth()) < (gameObject.getCoord()[0] + gameObject.getBitmap().getWidth()))) {
            collisionX = true;
        } else {
            collisionX = false;
        }
        //collision y
        if ((getCoord()[1] > gameObject.getCoord()[1] && getCoord()[1] < (gameObject.getCoord()[1] + gameObject.getBitmap().getHeight())) || ((getCoord()[1] + getBitmap().getHeight()) > gameObject.getCoord()[1] && (getCoord()[1] + getBitmap().getHeight()) < (gameObject.getCoord()[1] + gameObject.getBitmap().getHeight()))) {
            collisionY = true;
        } else {
            collisionY = false;
        }

        if (collisionX && collisionY) {
            inCollision(gameObject, iterator);
        }

    }

    protected abstract void inCollision(GameObject gameObject, Iterator iterator);

    public float[] getVitesse() {
        return vitesse;
    }

    public void setVitesse(float[] vitesse) {
        this.vitesse = vitesse;
    }

}
