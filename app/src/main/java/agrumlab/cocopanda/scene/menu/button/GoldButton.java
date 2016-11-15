package agrumlab.cocopanda.scene.menu.button;

import agrumlab.cocopanda.ressources.BitmapsManager;
import agrumlab.cocopanda.scene.Button;
import agrumlab.cocopanda.scene.Scene;
import agrumlab.cocopanda.util.ButtonListener;

/**
 * Created by Alexandre on 13/11/2016.
 */

public class GoldButton extends Button {

    public GoldButton(Scene scene) {
        super(scene);
        this.addButtonListener(new ButtonListener() {
            @Override
            public void buttonClicked(Button button) {

            }
        });
    }

    @Override
    protected void initializeBitmap() {
        super.bitmap = BitmapsManager.MENU_BUYCOINS_BUTTON.getBitmap();
    }

    @Override
    protected void initializePosition() {
        setPosition(Mark.MIDDLE, 0.33f,0.33f);
    }
}
