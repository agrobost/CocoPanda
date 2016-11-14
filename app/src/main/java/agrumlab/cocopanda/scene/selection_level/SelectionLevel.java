package agrumlab.cocopanda.scene.selection_level;

import android.graphics.Canvas;

import agrumlab.cocopanda.Surface;
import agrumlab.cocopanda.ressources.CanvasManager;
import agrumlab.cocopanda.ressources.EnumBitmaps;
import agrumlab.cocopanda.ressources.Screen;
import agrumlab.cocopanda.scene.Camera;
import agrumlab.cocopanda.scene.Scene;
import agrumlab.cocopanda.scene.selection_level.button.ButtonBack;

/**
 * Created by Alexandre on 13/11/2016.
 */

public class SelectionLevel extends Scene {
    private ButtonBack buttonBack;

    public SelectionLevel(Surface surface) {
        super(surface);
        buttonBack = new ButtonBack(this);
        this.addButton(buttonBack);
    }

    @Override
    public void drawScene(Canvas canvas) {
        canvas.drawBitmap(EnumBitmaps.SELECT_LEVEL_BACKGROUND.geBitmap(),0f,0f, CanvasManager.getPaint(CanvasManager.IMAGE_HD));
        buttonBack.draw(canvas);
    }

    @Override
    public void initializeScene() {
        super.camera = new Camera(new float[]{0, 0}, new float[]{Screen.width, Screen.height});

    }
}
