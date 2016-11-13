package agrumlab.cocopanda.scene.game.button;

import agrumlab.cocopanda.Surface;
import agrumlab.cocopanda.scene.ButtonIcon;
import agrumlab.cocopanda.ressources.EnumBitmaps;
import agrumlab.cocopanda.scene.Scene;

/**
 * Created by Alexandre on 06/02/2015.
 */
public class PauseIcon extends ButtonIcon {

    public PauseIcon(Scene scene) {
        super(scene, EnumBitmaps.GAME_PAUSE.geBitmap(), new float[]{929f, 1772f});
    }

    @Override
    protected void click() {
        scene.getSurface().changeLayout(Surface.Layout.PAUSE_GAME);
    }
}
