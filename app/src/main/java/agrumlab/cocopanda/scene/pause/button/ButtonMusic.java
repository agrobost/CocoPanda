package agrumlab.cocopanda.scene.pause.button;

import agrumlab.cocopanda.ressources.EnumBitmaps;
import agrumlab.cocopanda.scene.Button;
import agrumlab.cocopanda.ressources.PreferenceMemory;
import agrumlab.cocopanda.ressources.SoundManager;
import agrumlab.cocopanda.scene.Scene;
import agrumlab.cocopanda.util.ButtonListener;

/**
 * Created by Alexandre on 06/02/2015.
 */
public class ButtonMusic extends Button {

    public ButtonMusic(Scene scene) {
        super(scene);
        this.addButtonListener(new ButtonListener() {
            @Override
            public void buttonClicked(Button button) {
                if (PreferenceMemory.gameMusicIsEnable()) {
                    PreferenceMemory.muteGameMusic();
                    SoundManager.muteGameMusic();
                } else {
                    PreferenceMemory.demuteGameMusic();
                    SoundManager.demuteGameMusic();
                }
            }
        });
    }

    @Override
    protected void initializeBitmap() {
        super.bitmap = EnumBitmaps.PAUSE_MUSIC.getBitmap();
    }

    @Override
    protected void initializePosition() {
        setPosition(Mark.TOP_LEFT,0.5416f,0.5651f);
    }

}
