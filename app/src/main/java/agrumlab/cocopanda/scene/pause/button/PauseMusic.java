package agrumlab.cocopanda.scene.pause.button;

import android.graphics.Bitmap;

import agrumlab.cocopanda.scene.ButtonIcon;
import agrumlab.cocopanda.ressources.PreferenceMemory;
import agrumlab.cocopanda.ressources.SoundManager;
import agrumlab.cocopanda.scene.Scene;

/**
 * Created by Alexandre on 06/02/2015.
 */
public class PauseMusic extends ButtonIcon {

    public PauseMusic(Scene scene, Bitmap icon, float[] coord) {
        super(scene, icon, coord);
    }

    @Override
    protected void click() {
        if (PreferenceMemory.gameMusicIsEnable()) {
            PreferenceMemory.muteGameMusic();
            SoundManager.muteGameMusic();
        } else {
            PreferenceMemory.demuteGameMusic();
            SoundManager.demuteGameMusic();
        }
    }
}
