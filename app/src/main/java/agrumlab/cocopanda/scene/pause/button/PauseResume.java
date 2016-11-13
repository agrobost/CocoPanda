package agrumlab.cocopanda.scene.pause.button;

import android.graphics.Bitmap;

import agrumlab.cocopanda.Surface;
import agrumlab.cocopanda.scene.ButtonIcon;
import agrumlab.cocopanda.scene.Scene;

/**
 * Created by Alexandre on 06/02/2015.
 */
public class PauseResume extends ButtonIcon {

    public PauseResume(Scene scene, Bitmap icon, float[] coord) {
        super(scene, icon, coord);
    }

    @Override
    protected void click() {
        scene.getSurface().changeLayout(Surface.Layout.RESUME_GAME);
    }
}
