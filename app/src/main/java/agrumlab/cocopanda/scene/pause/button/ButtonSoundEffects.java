package agrumlab.cocopanda.scene.pause.button;

import agrumlab.cocopanda.ressources.EnumBitmaps;
import agrumlab.cocopanda.scene.Button;
import agrumlab.cocopanda.ressources.PreferenceMemory;
import agrumlab.cocopanda.scene.Scene;
import agrumlab.cocopanda.util.ButtonListener;

/**
 * Created by Alexandre on 06/02/2015.
 */
public class ButtonSoundEffects extends Button {

    public ButtonSoundEffects(Scene scene) {
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
        super.bitmap = EnumBitmaps.PAUSE_SOUND_EFFECTS.getBitmap();
    }

    @Override
    protected void initializePosition() {
        setPosition(Mark.TOP_LEFT,0.1685f,0.5651f);
    }

}
