package agrumlab.cocopanda.scene;

import android.graphics.Canvas;
import android.view.MotionEvent;

import agrumlab.cocopanda.ActivityMain;
import agrumlab.cocopanda.Surface;

/**
 * Created by Alexandre on 28/01/2015.
 */
public abstract class Scene {

    protected Camera camera = null;
    protected Surface surface;

    protected Scene(Surface surface) {
        this.surface = surface;
        initializeScene();
    }

    public abstract void drawScene(Canvas canvas);

    public abstract void initializeScene();

    public abstract void touch(MotionEvent event);


    public Camera getCamera() {
        return camera;
    }

    public Surface getSurface() {
        return surface;
    }
}
