package agrumlab.cocopanda.scene.pause.button;

import android.graphics.Bitmap;

import agrumlab.cocopanda.scene.ButtonIcon;
import agrumlab.cocopanda.ressources.PreferenceMemory;
import agrumlab.cocopanda.scene.Scene;

/**
 * Created by Alexandre on 06/02/2015.
 */
public class PauseSoundEffects extends ButtonIcon {

    public PauseSoundEffects(Scene scene, Bitmap icon, float[] coord) {
        super(scene, icon, coord);
    }

    @Override
    protected void click() {
        if (PreferenceMemory.soundEffectsIsEnable()) {
            PreferenceMemory.muteSoundEffects();
        } else {
            PreferenceMemory.demuteSoundEffects();
        }
    }
}
