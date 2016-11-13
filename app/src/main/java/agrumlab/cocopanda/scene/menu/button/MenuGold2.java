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

public class MenuGold2 extends Button {

    public MenuGold2(Scene scene) {
        super(scene);
        this.addButtonListener(new ButtonListener() {
            @Override
            public void buttonClicked() {
                Log.d("lsitener","champino");
            }
        });
    }

    @Override
    protected void initializeBitmap() {
        super.bitmap = EnumBitmaps.MENU_COIN.geBitmap();
        Log.d("rho","rho");
    }

    @Override
    protected void initializePositon() {
        setPosition(Mark.MIDDLE, 0.33f,0.33f);
    }
}
