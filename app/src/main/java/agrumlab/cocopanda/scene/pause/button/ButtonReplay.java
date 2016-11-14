package agrumlab.cocopanda.scene.pause.button;

import agrumlab.cocopanda.Surface;
import agrumlab.cocopanda.ressources.EnumBitmaps;
import agrumlab.cocopanda.scene.Button;
import agrumlab.cocopanda.scene.Scene;
import agrumlab.cocopanda.util.ButtonListener;

/**
 * Created by Alexandre on 06/02/2015.
 */
public class ButtonReplay extends Button {

    public ButtonReplay(Scene scene) {
        super(scene);
        this.addButtonListener(new ButtonListener() {
            @Override
            public void buttonClicked(Button button) {
                button.getScene().getSurface().changeLayout(Surface.Layout.REPLAY);
            }
        });
    }



    @Override
    protected void initializeBitmap() {
        super.bitmap = EnumBitmaps.REPLAY.getBitmap();
    }

    @Override
    protected void initializePosition() {
        setPosition(Mark.TOP_LEFT,0.1574f,0.6213f);
    }
}
