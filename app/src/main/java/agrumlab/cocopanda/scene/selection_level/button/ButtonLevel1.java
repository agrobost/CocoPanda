package agrumlab.cocopanda.scene.selection_level.button;

import agrumlab.cocopanda.Surface;
import agrumlab.cocopanda.ressources.EnumBitmaps;
import agrumlab.cocopanda.scene.Button;
import agrumlab.cocopanda.scene.Scene;
import agrumlab.cocopanda.scene.game.Level_1;
import agrumlab.cocopanda.util.ButtonListener;

/**
 * Created by Alexandre on 13/11/2016.
 */

public class ButtonLevel1 extends Button {


    public ButtonLevel1(final Scene scene) {
        super(scene);
        this.addButtonListener(new ButtonListener() {
            @Override
            public void buttonClicked(Button button) {
                button.getScene().getSurface().setLevel(new Level_1(button.getScene().getSurface()));
                button.getScene().getSurface().changeLayout(Surface.Layout.NEW_GAME);

            }
        });
    }

    @Override
    protected void initializeBitmap() {
        super.bitmap = EnumBitmaps.SELECT_LEVEL_LEVEL1.getBitmap();

    }

    @Override
    protected void initializePosition() {
        setPosition(Mark.TOP_LEFT,0.0574f,0.2094f);
    }
}
