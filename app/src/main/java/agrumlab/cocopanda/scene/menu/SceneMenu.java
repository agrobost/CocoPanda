package agrumlab.cocopanda.scene.menu;

import android.graphics.Canvas;

import agrumlab.cocopanda.Surface;
import agrumlab.cocopanda.ressources.CanvasManager;
import agrumlab.cocopanda.ressources.EnumBitmaps;
import agrumlab.cocopanda.ressources.Screen;
import agrumlab.cocopanda.scene.Camera;
import agrumlab.cocopanda.scene.Scene;
import agrumlab.cocopanda.scene.menu.button.ButtonGold;
import agrumlab.cocopanda.scene.menu.button.ButtonPlay;
import agrumlab.cocopanda.scene.menu.button.ButtonRank;
import agrumlab.cocopanda.scene.menu.button.ButtonShop;

/**
 * Created by Alexandre on 06/02/2015.
 */
public class SceneMenu extends Scene {

    private ButtonGold buttonGold;
    private ButtonShop buttonShop;
    private ButtonPlay buttonPlay;
    private ButtonRank buttonRank;


    public SceneMenu(Surface surface) {
        super(surface);
        buttonRank = new ButtonRank(this);
        buttonPlay = new ButtonPlay(this);
        buttonShop = new ButtonShop(this);
        buttonGold = new ButtonGold(this);
        this.addButton(buttonGold);
        this.addButton(buttonPlay);
        this.addButton(buttonShop);
        this.addButton(buttonGold);
    }

    @Override
    public void drawScene(Canvas canvas) {
        canvas.drawBitmap(EnumBitmaps.MENU_BACKGROUND.getBitmap(), 0f, 0f, CanvasManager.getPaint(CanvasManager.IMAGE_HD));
        canvas.drawBitmap(EnumBitmaps.MENU_HEADER.getBitmap(), 0f, 0f, CanvasManager.getPaint(CanvasManager.IMAGE_HD));
        buttonGold.draw(canvas);
        buttonShop.draw(canvas);
        buttonPlay.draw(canvas);
        buttonRank.draw(canvas);
    }


    @Override
    public void initializeScene() {
        super.camera = new Camera(new float[]{0, 0}, new float[]{Screen.width, Screen.height});
    }

}
