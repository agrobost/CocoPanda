package agrumlab.cocopanda.scene.selection_level;

import android.graphics.Canvas;

import agrumlab.cocopanda.Surface;
import agrumlab.cocopanda.ressources.CanvasManager;
import agrumlab.cocopanda.ressources.BitmapsManager;
import agrumlab.cocopanda.ressources.ScreenManager;
import agrumlab.cocopanda.scene.Camera;
import agrumlab.cocopanda.scene.Scene;
import agrumlab.cocopanda.scene.selection_level.button.BackButton;
import agrumlab.cocopanda.scene.selection_level.button.Level1Button;

/**
 * Created by Alexandre on 13/11/2016.
 */

public class ChooseLevelScene extends Scene {
    private BackButton backButton;
    private Level1Button level1Button;

    public ChooseLevelScene(Surface surface) {
        super(surface);
        backButton = new BackButton(this);
        level1Button = new Level1Button(this);
        this.addButton(backButton);
        this.addButton(level1Button);
    }

    @Override
    public void drawScene(Canvas canvas) {
        canvas.drawBitmap(BitmapsManager.SELECT_LEVEL_BACKGROUND.getBitmap(),0f,0f, CanvasManager.getPaint(CanvasManager.IMAGE_HD));
        backButton.draw(canvas);
        level1Button.draw(canvas);
    }

    @Override
    public void initializeScene() {
        super.camera = new Camera(new float[]{0, 0}, new float[]{ScreenManager.width, ScreenManager.height});

    }
}
