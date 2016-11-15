package agrumlab.cocopanda.scene.menu.button;

import agrumlab.cocopanda.Surface;
import agrumlab.cocopanda.ressources.BitmapsManager;
import agrumlab.cocopanda.scene.Button;
import agrumlab.cocopanda.scene.Scene;
import agrumlab.cocopanda.util.ButtonListener;

/**
 * Created by Alexandre on 06/02/2015.
 */
public class PlayButton extends Button {
    public PlayButton(Scene scene) {
        super(scene);
        this.addButtonListener(new ButtonListener() {
            @Override
            public void buttonClicked(Button button) {
                button.getScene().getSurface().changeLayout(Surface.Layout.SELECT_LEVEL);
            }
        });
    }

    @Override
    protected void initializeBitmap() {
        super.bitmap = BitmapsManager.MENU_PLAY_BUTTON.getBitmap();
    }

    @Override
    protected void initializePosition() {
        setPosition(Mark.TOP, 0.5f,0.416f);
    }
}
