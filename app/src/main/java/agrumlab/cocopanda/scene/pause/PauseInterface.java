package agrumlab.cocopanda.scene.pause;

import android.graphics.Canvas;
import android.view.MotionEvent;

import java.text.DecimalFormat;

import agrumlab.cocopanda.Surface;
import agrumlab.cocopanda.ressources.CanvasManager;
import agrumlab.cocopanda.ressources.EnumBitmaps;
import agrumlab.cocopanda.ressources.PreferenceMemory;
import agrumlab.cocopanda.scene.Button;
import agrumlab.cocopanda.ressources.Screen;
import agrumlab.cocopanda.scene.Camera;
import agrumlab.cocopanda.scene.Scene;
import agrumlab.cocopanda.scene.pause.button.ButtonMenu;
import agrumlab.cocopanda.scene.pause.button.ButtonMusic;
import agrumlab.cocopanda.scene.pause.button.ButtonResume;
import agrumlab.cocopanda.scene.pause.button.ButtonReplay;
import agrumlab.cocopanda.scene.pause.button.Sensitivity;
import agrumlab.cocopanda.scene.pause.button.ButtonSoundEffects;

/**
 * Created by Alexandre on 03/02/2015.
 */
public class PauseInterface extends Scene {

    private Button buttonReplay, buttonResume, buttonMusic, buttonSoundEffects, buttonMenu;
    private Sensitivity pauseSensitivity;
    private DecimalFormat df = new DecimalFormat("#.##");


    public PauseInterface(Surface surface) {
        super(surface);
        buttonReplay = new ButtonReplay(this);
        buttonResume = new ButtonResume(this);
        buttonMenu = new ButtonMenu(this);
        buttonMusic = new ButtonMusic(this);
        buttonSoundEffects = new ButtonSoundEffects(this);
        this.addButton(buttonReplay);
        this.addButton(buttonResume);
        this.addButton(buttonMenu);
        this.addButton(buttonMusic);
        this.addButton(buttonSoundEffects);
        pauseSensitivity = new Sensitivity(this);
    }


    @Override
    public void initializeScene() {
        this.camera = new Camera(new float[]{0f, 0f}, new float[]{Screen.width, Screen.height});
    }

    @Override
    public void touch(MotionEvent event) {
        super.touch(event);
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                pauseSensitivity.actionDown(event);
                break;
            case MotionEvent.ACTION_MOVE:
                pauseSensitivity.actionMove(event);
                break;

            case MotionEvent.ACTION_UP:
                pauseSensitivity.actionUp(event);
                break;
        }
    }

    @Override
    public void drawScene(Canvas canvas) {
        //fond noire transparent pour faire stylé
        CanvasManager.drawBitmapAdjust(canvas, EnumBitmaps.PAUSE_BACKGROUND.geBitmap(), 91f, 370f, CanvasManager.getPaint(CanvasManager.IMAGE_HD));
        buttonMusic.draw(canvas);
        buttonResume.draw(canvas);
        pauseSensitivity.draw(canvas);
        buttonReplay.draw(canvas);
        buttonSoundEffects.draw(canvas);
        buttonMenu.draw(canvas);

        if (PreferenceMemory.gameMusicIsEnable()) {
            CanvasManager.drawBitmapAdjust(canvas, EnumBitmaps.PAUSE_CHECKED.geBitmap(), 788f, 1077f, CanvasManager.getPaint(CanvasManager.IMAGE_HD));
        }

        if (PreferenceMemory.soundEffectsIsEnable()) {
            CanvasManager.drawBitmapAdjust(canvas, EnumBitmaps.PAUSE_CHECKED.geBitmap(), 371f, 1077f, CanvasManager.getPaint(CanvasManager.IMAGE_HD));
        }

        CanvasManager.drawTextAdjust(canvas, surface.getLevel().getScore().toString() + " s", 545f, 640f, CanvasManager.getPaint(CanvasManager.TEXT_PAUSE_LOOSE));
        CanvasManager.drawTextAdjust(canvas, df.format(PreferenceMemory.getValueRecord(surface.getLevel().reference)) + " s", 545f, 767f, CanvasManager.getPaint(CanvasManager.TEXT_PAUSE_LOOSE));


    }
}
