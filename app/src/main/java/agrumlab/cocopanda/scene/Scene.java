package agrumlab.cocopanda.scene;

import android.graphics.Canvas;
import android.view.MotionEvent;

import java.util.ArrayList;

import agrumlab.cocopanda.Surface;

public abstract class Scene {

    protected Camera camera = null;
    protected ArrayList<Button> buttons;
    protected ArrayList<GameObject> gameObjects;
    protected Surface surface;

    protected Scene(Surface surface) {
        this.surface = surface;
        this.buttons = new ArrayList<>();
        this.gameObjects = new ArrayList<>();
        initializeScene();
    }

    public abstract void drawScene(Canvas canvas);

    public abstract void initializeScene();


    public void touch(MotionEvent event) {
        for (Button button : buttons) {
            button.touch(event);
        }
    }

    public void addButton(Button button) {
        this.buttons.add(button);
    }

    private void addGameObject(GameObject gameObject) {
        this.gameObjects.add(gameObject);
    }

    public Camera getCamera() {
        return camera;
    }

    public Surface getSurface() {
        return surface;
    }
}
