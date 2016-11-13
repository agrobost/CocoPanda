package agrumlab.cocopanda.scene.menu.button;

import android.graphics.Bitmap;

import agrumlab.cocopanda.Surface;
import agrumlab.cocopanda.scene.ButtonIcon;
import agrumlab.cocopanda.scene.Scene;

/**
 * Created by Alexandre on 06/02/2015.
 */
public class MenuPlay extends ButtonIcon {
    public MenuPlay(Scene scene, Bitmap icon, float[] coord) {
        super(scene, icon, coord);
    }

    @Override
    protected void click() {
        scene.getSurface().changeLayout(Surface.Layout.NEW_GAME);

    }
}
