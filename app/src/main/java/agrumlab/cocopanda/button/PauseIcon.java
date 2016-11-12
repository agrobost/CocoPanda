package agrumlab.cocopanda.button;

import android.graphics.Bitmap;

import agrumlab.cocopanda.Surface;
import agrumlab.cocopanda.ressources.SoundManager;
import agrumlab.cocopanda.scene.Scene;

/**
 * Created by Alexandre on 06/02/2015.
 */
public class PauseIcon extends ButtonIcon {

    public PauseIcon(Scene scene, Bitmap icon, float[] coord) {
        super(scene, icon, coord);
    }

    @Override
    protected void click() {
        scene.getSurface().changeLayout(Surface.Layout.PAUSE_GAME);

    }
}
