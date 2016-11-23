package agrumlab.cocopanda.scene.pause.button;

import agrumlab.cocopanda.ressources.BitmapsManager;
import agrumlab.cocopanda.scene.Button;
import agrumlab.cocopanda.ressources.PreferenceMemory;
import agrumlab.cocopanda.scene.Scene;
import agrumlab.cocopanda.util.ButtonListener;

/**
 * Created by Alexandre on 06/02/2015.
 */
public class SoundEffects extends Button {

    public SoundEffects(Scene scene) {
        super(scene);
        this.addButtonListener(new ButtonListener() {
            @Override
            public void buttonClicked(Button button) {
                if (PreferenceMemory.soundEffectsIsEnable()) {
                    PreferenceMemory.muteSoundEffects();
                } else {
                    PreferenceMemory.demuteSoundEffects();
                }
            }
        });
    }

    @Override
    protected void initializeBitmap() {
        super.bitmap = BitmapsManager.PAUSE_SOUNDEFFECTS_BUTTON.getBitmap();
    }

    @Override
    protected void initializePosition() {
        setPosition(Mark.TOP_LEFT,0.1685f,0.5651f);
    }

}
