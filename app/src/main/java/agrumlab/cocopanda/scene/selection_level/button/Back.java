package agrumlab.cocopanda.scene.selection_level.button;

import agrumlab.cocopanda.Surface;
import agrumlab.cocopanda.ressources.BitmapsManager;
import agrumlab.cocopanda.scene.Button;
import agrumlab.cocopanda.scene.Scene;
import agrumlab.cocopanda.util.ButtonListener;

/**
 * Created by Alexandre on 14/11/2016.
 */

public class Back extends Button {

    public Back(Scene scene) {
        super(scene);
        this.addButtonListener(new ButtonListener() {
            @Override
            public void buttonClicked(Button button) {
                button.getScene().getSurface().changeLayout(Surface.Layout.MENU);
            }
        });
    }

    @Override
    protected void initializeBitmap() {
        super.bitmap = BitmapsManager.SELECT_LEVEL_BACK_BUTTON.getBitmap();

    }

    @Override
    protected void initializePosition() {
        setPosition(Mark.TOP_LEFT,0.0222f,0.8604f);
    }
}
