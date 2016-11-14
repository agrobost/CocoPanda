package agrumlab.cocopanda.scene.game.button;

import agrumlab.cocopanda.Surface;
import agrumlab.cocopanda.scene.Button;
import agrumlab.cocopanda.ressources.EnumBitmaps;
import agrumlab.cocopanda.scene.Scene;
import agrumlab.cocopanda.util.ButtonListener;

/**
 * Created by Alexandre on 06/02/2015.
 */
public class PauseIcon extends Button {

    public PauseIcon(Scene scene) {
        super(scene);
        this.addButtonListener(new ButtonListener() {
            @Override
            public void buttonClicked(Button button) {
                button.getScene().getSurface().changeLayout(Surface.Layout.PAUSE_GAME);
            }
        });
    }

    @Override
    protected void initializeBitmap() {
        super.bitmap = EnumBitmaps.GAME_PAUSE.getBitmap();
    }

    @Override
    protected void initializePosition() {
        setPosition(Mark.TOP_LEFT, 0.8602f,0.9229f);
    }

}
