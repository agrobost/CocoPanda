package agrumlab.cocopanda.scene.menu.button;

import agrumlab.cocopanda.ressources.BitmapsManager;
import agrumlab.cocopanda.scene.Button;
import agrumlab.cocopanda.scene.Scene;
import agrumlab.cocopanda.util.ButtonListener;

/**
 * Created by Alexandre on 06/02/2015.
 */
public class Rank extends Button {

    public Rank(Scene scene) {
        super(scene);
        this.addButtonListener(new ButtonListener() {
            @Override
            public void buttonClicked(Button button) {

            }
        });
    }

    @Override
    protected void initializeBitmap() {
        super.bitmap = BitmapsManager.MENU_RANK_BUTTON.getBitmap();
    }

    @Override
    protected void initializePosition() {
        setPosition(Mark.TOP_LEFT,0.03f,0.873f);
    }
}
