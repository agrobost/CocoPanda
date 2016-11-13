package agrumlab.cocopanda.scene.loose.button;

import android.graphics.Bitmap;

import agrumlab.cocopanda.Surface;
import agrumlab.cocopanda.scene.ButtonIcon;
import agrumlab.cocopanda.scene.Scene;

/**
 * Created by Alexandre on 08/02/2015.
 */
public class IconMenu extends ButtonIcon {

    public IconMenu(Scene scene, Bitmap icon, float[] coord) {
        super(scene, icon, coord);
    }

    @Override
    protected void click() {
        scene.getSurface().changeLayout(Surface.Layout.MENU);
    }
}
