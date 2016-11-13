package agrumlab.cocopanda.scene.pause;

import android.graphics.Canvas;
import android.view.MotionEvent;

import java.text.DecimalFormat;

import agrumlab.cocopanda.Surface;
import agrumlab.cocopanda.ressources.CanvasManager;
import agrumlab.cocopanda.ressources.EnumBitmaps;
import agrumlab.cocopanda.ressources.PreferenceMemory;
import agrumlab.cocopanda.scene.ButtonIcon;
import agrumlab.cocopanda.ressources.Screen;
import agrumlab.cocopanda.scene.Camera;
import agrumlab.cocopanda.scene.Scene;
import agrumlab.cocopanda.scene.loose.button.IconMenu;
import agrumlab.cocopanda.scene.pause.button.PauseMusic;
import agrumlab.cocopanda.scene.pause.button.PauseResume;
import agrumlab.cocopanda.scene.loose.button.IconReplay;
import agrumlab.cocopanda.scene.pause.button.PauseSensitivity;
import agrumlab.cocopanda.scene.pause.button.PauseSoundEffects;

/**
 * Created by Alexandre on 03/02/2015.
 */
public class PauseInterface extends Scene {

    private ButtonIcon pauseReplay, pauseResume, pauseMusic, pauseSoundEffects, pauseMenu;
    private PauseSensitivity pauseSensitivity;
    private DecimalFormat df = new DecimalFormat("#.##");


    public PauseInterface(Surface surface) {
        super(surface);
        pauseReplay = new IconReplay(this, EnumBitmaps.REPLAY.geBitmap(), new float[]{170f, 1193f});
        pauseResume = new PauseResume(this, EnumBitmaps.PAUSE_RESUME.geBitmap(), new float[]{419f, 1193f});
        pauseMenu = new IconMenu(this, EnumBitmaps.MENU.geBitmap(), new float[]{667f, 1193f});
        pauseMusic = new PauseMusic(this, EnumBitmaps.PAUSE_MUSIC.geBitmap(), new float[]{585f, 1085f});
        pauseSensitivity = new PauseSensitivity(this);
        pauseSoundEffects = new PauseSoundEffects(this, EnumBitmaps.PAUSE_SOUND_EFFECTS.geBitmap(), new float[]{182f, 1085f});
    }


    @Override
    public void initializeScene() {
        this.camera = new Camera(new float[]{0f, 0f}, new float[]{Screen.width, Screen.height});
    }

    @Override
    public void touch(MotionEvent event) {
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                pauseResume.actionDown(event);
                pauseSoundEffects.actionDown(event);
                pauseSensitivity.actionDown(event);
                pauseReplay.actionDown(event);
                pauseMusic.actionDown(event);
                pauseMenu.actionDown(event);

                pauseSensitivity.actionDown(event);
                break;
            case MotionEvent.ACTION_MOVE:
                pauseResume.actionMove(event);
                pauseSoundEffects.actionMove(event);
                pauseSensitivity.actionMove(event);
                pauseReplay.actionMove(event);
                pauseMusic.actionMove(event);
                pauseMenu.actionMove(event);
                break;

            case MotionEvent.ACTION_UP:
                pauseResume.actionUp(event);
                pauseSoundEffects.actionUp(event);
                pauseSensitivity.actionUp(event);
                pauseReplay.actionUp(event);
                pauseMusic.actionUp(event);
                pauseMenu.actionUp(event);
                break;
        }

    }

    @Override
    public void drawScene(Canvas canvas) {
        //fond noire transparent pour faire stylé
        CanvasManager.drawBitmapAdjust(canvas, EnumBitmaps.PAUSE_BACKGROUND.geBitmap(), 91f, 370f, CanvasManager.getPaint(CanvasManager.IMAGE_HD));
        pauseMusic.draw(canvas);
        pauseResume.draw(canvas);
        pauseSensitivity.draw(canvas);
        pauseReplay.draw(canvas);
        pauseSoundEffects.draw(canvas);
        pauseMenu.draw(canvas);

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
