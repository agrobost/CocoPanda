package agrumlab.cocopanda.scene.loose;

import android.graphics.Canvas;
import android.view.MotionEvent;

import java.text.DecimalFormat;

import agrumlab.cocopanda.Surface;
import agrumlab.cocopanda.ressources.CanvasManager;
import agrumlab.cocopanda.ressources.EnumBitmaps;
import agrumlab.cocopanda.ressources.PreferenceMemory;
import agrumlab.cocopanda.ressources.Screen;
import agrumlab.cocopanda.scene.Camera;
import agrumlab.cocopanda.scene.Scene;
import agrumlab.cocopanda.scene.ButtonIcon;
import agrumlab.cocopanda.scene.loose.button.IconMenu;
import agrumlab.cocopanda.scene.loose.button.IconReplay;

/**
 * Created by Alexandre on 08/02/2015.
 */
public class LooseInterface extends Scene {

    private ButtonIcon pauseReplay, pauseMenu;
    private DecimalFormat df = new DecimalFormat("#.##");


    public LooseInterface(Surface surface) {
        super(surface);
        pauseReplay = new IconReplay(this, EnumBitmaps.REPLAY.geBitmap(), new float[]{246f, 1205f});
        pauseMenu = new IconMenu(this, EnumBitmaps.MENU.geBitmap(), new float[]{600f, 1205f});
    }

    @Override
    public void drawScene(Canvas canvas) {
        CanvasManager.drawBitmapAdjust(canvas, EnumBitmaps.LOOSE_BACKGROUND.geBitmap(), 94f, 370f, CanvasManager.getPaint(CanvasManager.IMAGE_HD));
        pauseMenu.draw(canvas);
        pauseReplay.draw(canvas);
        CanvasManager.drawTextAdjust(canvas, surface.getLevel().getScore().toString() + " s", 540f, 644f, CanvasManager.getPaint(CanvasManager.TEXT_PAUSE_LOOSE));
        CanvasManager.drawTextAdjust(canvas, df.format(PreferenceMemory.getValueRecord(surface.getLevel().reference)) + " s", 540f, 771f, CanvasManager.getPaint(CanvasManager.TEXT_PAUSE_LOOSE));

        //etoile 1
        if (PreferenceMemory.getValueRecord(surface.getLevel().reference) < surface.getLevel().oneStar) {
            CanvasManager.drawBitmapAdjust(canvas, EnumBitmaps.LOOSE_STAR_EMPTY.geBitmap(), 159f, 909f, CanvasManager.getPaint(CanvasManager.IMAGE_HD));
        } else {
            CanvasManager.drawBitmapAdjust(canvas, EnumBitmaps.LOOSE_STAR_FILL.geBitmap(), 159f, 909f, CanvasManager.getPaint(CanvasManager.IMAGE_HD));
        }

        //etoile 2
        if (PreferenceMemory.getValueRecord(surface.getLevel().reference) < surface.getLevel().twoStar) {
            CanvasManager.drawBitmapAdjust(canvas, EnumBitmaps.LOOSE_STAR_EMPTY.geBitmap(), 420f, 909f, CanvasManager.getPaint(CanvasManager.IMAGE_HD));
        } else {
            CanvasManager.drawBitmapAdjust(canvas, EnumBitmaps.LOOSE_STAR_FILL.geBitmap(), 420f, 909f, CanvasManager.getPaint(CanvasManager.IMAGE_HD));
        }

        //etoile 3
        if (PreferenceMemory.getValueRecord(surface.getLevel().reference) < surface.getLevel().threeStar) {
            CanvasManager.drawBitmapAdjust(canvas, EnumBitmaps.LOOSE_STAR_EMPTY.geBitmap(), 681f, 909f, CanvasManager.getPaint(CanvasManager.IMAGE_HD));
        } else {
            CanvasManager.drawBitmapAdjust(canvas, EnumBitmaps.LOOSE_STAR_FILL.geBitmap(), 684f, 909f, CanvasManager.getPaint(CanvasManager.IMAGE_HD));
        }

    }

    @Override
    public void initializeScene() {
        this.camera = new Camera(new float[]{0f, 0f}, new float[]{Screen.width, Screen.height});
    }

    @Override
    public void touch(MotionEvent event) {
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                pauseReplay.actionDown(event);
                pauseMenu.actionDown(event);
                break;

            case MotionEvent.ACTION_MOVE:
                pauseReplay.actionMove(event);
                pauseMenu.actionMove(event);
                break;

            case MotionEvent.ACTION_UP:
                pauseReplay.actionUp(event);
                pauseMenu.actionUp(event);
                break;
        }

    }
}
