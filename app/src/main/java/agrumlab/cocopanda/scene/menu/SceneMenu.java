package agrumlab.cocopanda.scene.menu;

import android.graphics.Canvas;
import android.view.MotionEvent;

import agrumlab.cocopanda.Surface;
import agrumlab.cocopanda.ressources.CanvasManager;
import agrumlab.cocopanda.ressources.EnumBitmaps;
import agrumlab.cocopanda.ressources.Screen;
import agrumlab.cocopanda.scene.Camera;
import agrumlab.cocopanda.scene.Scene;
import agrumlab.cocopanda.button.MenuPlay;

/**
 * Created by Alexandre on 06/02/2015.
 */
public class SceneMenu extends Scene {

    //private MenuGold menuGold;
    //private MenuShop menuShop;
    private MenuPlay menuPlay;
    //private MenuRank menuRank;

    public SceneMenu(Surface surface) {
        super(surface);
        //menuRank = new MenuRank(this,BitmapManager.getBitMap(BitmapManager.MENU_RANK), new float[]{54f, 1677f});
        menuPlay = new MenuPlay(this, EnumBitmaps.MENU_PLAY.geBitmap(), new float[]{278f, 800f});
        //menuShop = new MenuShop(this,BitmapManager.getBitMap(BitmapManager.MENU_SHOP), new float[]{587f, 1677f});
        // menuGold = new MenuGold(this,BitmapManager.getBitMap(BitmapManager.MENU_COIN), new float[]{54f, 510f});
    }

    @Override
    public void drawScene(Canvas canvas) {
        canvas.drawBitmap(EnumBitmaps.MENU_BACKGROUND.geBitmap(), 0f, 0f, CanvasManager.getPaint(CanvasManager.IMAGE_HD));
        canvas.drawBitmap(EnumBitmaps.MENU_HEADER.geBitmap(), 0f, 0f, CanvasManager.getPaint(CanvasManager.IMAGE_HD));

        //menuGold.draw(canvas);
        // menuShop.draw(canvas);
        menuPlay.draw(canvas);
        // menuRank.draw(canvas);

    }

    @Override
    public void initializeScene() {
        super.camera = new Camera(new float[]{0, 0}, new float[]{Screen.width, Screen.height});
    }

    @Override
    public void touch(MotionEvent event) {

        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                //menuGold.actionDown(event);
                menuPlay.actionDown(event);
                //menuRank.actionDown(event);
                // menuShop.actionDown(event);
                break;
            case MotionEvent.ACTION_MOVE:
                //menuGold.actionMove(event);
                menuPlay.actionMove(event);
                // menuRank.actionMove(event);
                // menuShop.actionMove(event);
                break;

            case MotionEvent.ACTION_UP:
                //  menuGold.actionUp(event);
                menuPlay.actionUp(event);
                // menuRank.actionUp(event);
                //  menuShop.actionUp(event);
                break;
        }

    }
}
