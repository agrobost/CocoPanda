package agrumlab.cocopanda.scene.pause;

import android.graphics.Canvas;
import android.view.MotionEvent;

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
import agrumlab.cocopanda.scene.pause.button.Music;
import agrumlab.cocopanda.scene.pause.button.Resume;
import agrumlab.cocopanda.scene.pause.button.Replay;
import agrumlab.cocopanda.scene.pause.button.Sensitivity;
import agrumlab.cocopanda.scene.pause.button.SoundEffects;

/**
 * Created by Alexandre on 03/02/2015.
 */
public class Pause extends Scene {

    private Button replayButton, resumeButton, musicButton, soundEffectsButton, menuButton;
    private Sensitivity pauseSensitivity;
    private DecimalFormat df = new DecimalFormat("#.##");


    public Pause(Surface surface) {
        super(surface);
        replayButton = new Replay(this);
        resumeButton = new Resume(this);
        menuButton = new Menu(this);
        musicButton = new Music(this);
        soundEffectsButton = new SoundEffects(this);
        this.addButton(replayButton);
        this.addButton(resumeButton);
        this.addButton(menuButton);
        this.addButton(musicButton);
        this.addButton(soundEffectsButton);
        pauseSensitivity = new Sensitivity(this);
    }


    @Override
    public void initializeScene() {
        this.camera = new Camera(new float[]{0f, 0f}, new float[]{ScreenManager.width, ScreenManager.height});
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
        CanvasManager.drawBitmapAdjust(canvas, BitmapsManager.PAUSE_BACKGROUND.getBitmap(), 91f, 370f, CanvasManager.getPaint(CanvasManager.IMAGE_HD));
        musicButton.draw(canvas);
        resumeButton.draw(canvas);
        pauseSensitivity.draw(canvas);
        replayButton.draw(canvas);
        soundEffectsButton.draw(canvas);
        menuButton.draw(canvas);

        if (PreferenceMemory.gameMusicIsEnable()) {
            CanvasManager.drawBitmapAdjust(canvas, BitmapsManager.PAUSE_CHECKED.getBitmap(), 788f, 1077f, CanvasManager.getPaint(CanvasManager.IMAGE_HD));
        }

        if (PreferenceMemory.soundEffectsIsEnable()) {
            CanvasManager.drawBitmapAdjust(canvas, BitmapsManager.PAUSE_CHECKED.getBitmap(), 371f, 1077f, CanvasManager.getPaint(CanvasManager.IMAGE_HD));
        }

        CanvasManager.drawTextAdjust(canvas, surface.getGame().getScore().toString() + " s", 545f, 640f, CanvasManager.getPaint(CanvasManager.TEXT_PAUSE_LOOSE));
        CanvasManager.drawTextAdjust(canvas, df.format(PreferenceMemory.getValueRecord(surface.getGame().reference)) + " s", 545f, 767f, CanvasManager.getPaint(CanvasManager.TEXT_PAUSE_LOOSE));


    }
}
