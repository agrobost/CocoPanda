package agrumlab.cocopanda.scene.menu.button;

import android.graphics.Bitmap;
import android.util.Log;

import agrumlab.cocopanda.ressources.EnumBitmaps;
import agrumlab.cocopanda.scene.Button;
import agrumlab.cocopanda.scene.Scene;
import agrumlab.cocopanda.util.ButtonListener;

/**
 * Created by Alexandre on 13/11/2016.
 */

public class ButtonGold extends Button {

    public ButtonGold(Scene scene) {
        super(scene);
        this.addButtonListener(new ButtonListener() {
            @Override
            public void buttonClicked(Button button) {

            }
        });
    }

    @Override
    protected void initializeBitmap() {
        super.bitmap = EnumBitmaps.MENU_COIN.geBitmap();
    }

    @Override
    protected void initializePosition() {
        setPosition(Mark.MIDDLE, 0.33f,0.33f);
    }
}
