package agrumlab.cocopanda.scene.loose;

import android.graphics.Canvas;

import java.text.DecimalFormat;

import agrumlab.cocopanda.Surface;
import agrumlab.cocopanda.ressources.BitmapsManager;
import agrumlab.cocopanda.ressources.CanvasManager;
import agrumlab.cocopanda.ressources.PreferenceMemory;
import agrumlab.cocopanda.ressources.ScreenManager;
import agrumlab.cocopanda.scene.Button;
import agrumlab.cocopanda.scene.Camera;
import agrumlab.cocopanda.scene.Scene;
import agrumlab.cocopanda.scene.pause.button.Menu;
import agrumlab.cocopanda.scene.pause.button.Replay;

/**
 * Created by Alexandre on 08/02/2015.
 */
public class Loose extends Scene {

    private Button pauseReplay, pauseMenu;
    private DecimalFormat df = new DecimalFormat("#.##");


    public Loose(Surface surface) {
        super(surface);
        pauseReplay = new Replay(this);
        pauseMenu = new Menu(this);
        this.addButton(pauseReplay);
        this.addButton(pauseMenu);

    }

    @Override
    public void drawScene(Canvas canvas) {
        CanvasManager.drawBitmapAdjust(canvas, BitmapsManager.LOOSE_BACKGROUND.getBitmap(), 94f, 370f, CanvasManager.getPaint(CanvasManager.IMAGE_HD));
        pauseMenu.draw(canvas);
        pauseReplay.draw(canvas);
        CanvasManager.drawTextAdjust(canvas, surface.getGame().getScore().toString() + " s", 540f, 644f, CanvasManager.getPaint(CanvasManager.TEXT_PAUSE_LOOSE));
        CanvasManager.drawTextAdjust(canvas, df.format(PreferenceMemory.getValueRecord(surface.getGame().reference)) + " s", 540f, 771f, CanvasManager.getPaint(CanvasManager.TEXT_PAUSE_LOOSE));

        //etoile 1
        if (PreferenceMemory.getValueRecord(surface.getGame().reference) < surface.getGame().oneStar) {
            CanvasManager.drawBitmapAdjust(canvas, BitmapsManager.LOOSE_EMPTYSTAR.getBitmap(), 159f, 909f, CanvasManager.getPaint(CanvasManager.IMAGE_HD));
        } else {
            CanvasManager.drawBitmapAdjust(canvas, BitmapsManager.LOOSE_FULLSTAR.getBitmap(), 159f, 909f, CanvasManager.getPaint(CanvasManager.IMAGE_HD));
        }

        //etoile 2
        if (PreferenceMemory.getValueRecord(surface.getGame().reference) < surface.getGame().twoStar) {
            CanvasManager.drawBitmapAdjust(canvas, BitmapsManager.LOOSE_EMPTYSTAR.getBitmap(), 420f, 909f, CanvasManager.getPaint(CanvasManager.IMAGE_HD));
        } else {
            CanvasManager.drawBitmapAdjust(canvas, BitmapsManager.LOOSE_FULLSTAR.getBitmap(), 420f, 909f, CanvasManager.getPaint(CanvasManager.IMAGE_HD));
        }

        //etoile 3
        if (PreferenceMemory.getValueRecord(surface.getGame().reference) < surface.getGame().threeStar) {
            CanvasManager.drawBitmapAdjust(canvas, BitmapsManager.LOOSE_EMPTYSTAR.getBitmap(), 681f, 909f, CanvasManager.getPaint(CanvasManager.IMAGE_HD));
        } else {
            CanvasManager.drawBitmapAdjust(canvas, BitmapsManager.LOOSE_FULLSTAR.getBitmap(), 684f, 909f, CanvasManager.getPaint(CanvasManager.IMAGE_HD));
        }

    }

    @Override
    public void initializeScene() {
        this.camera = new Camera(new float[]{0f, 0f}, new float[]{ScreenManager.width, ScreenManager.height});
    }
}
