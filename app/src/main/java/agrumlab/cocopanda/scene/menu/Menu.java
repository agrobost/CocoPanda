package agrumlab.cocopanda.scene.menu;

import android.graphics.Canvas;

import agrumlab.cocopanda.Surface;
import agrumlab.cocopanda.ressources.BitmapsManager;
import agrumlab.cocopanda.ressources.CanvasManager;
import agrumlab.cocopanda.ressources.ScreenManager;
import agrumlab.cocopanda.scene.Button;
import agrumlab.cocopanda.scene.Camera;
import agrumlab.cocopanda.scene.Scene;
import agrumlab.cocopanda.scene.menu.button.BuyCoins;
import agrumlab.cocopanda.scene.menu.button.Play;
import agrumlab.cocopanda.scene.menu.button.Rank;
import agrumlab.cocopanda.scene.menu.button.Shop;

/**
 * Created by Alexandre on 06/02/2015.
 */
public class Menu extends Scene {

    private Button goldButton, shopButton, playButton, rankButton;


    public Menu(Surface surface) {
        super(surface);
        rankButton = new Rank(this);
        playButton = new Play(this);
        shopButton = new Shop(this);
        goldButton = new BuyCoins(this);
        this.addButton(goldButton);
        this.addButton(playButton);
        this.addButton(shopButton);
        this.addButton(goldButton);
    }

    @Override
    public void drawScene(Canvas canvas) {
        canvas.drawBitmap(BitmapsManager.MENU_BACKGROUND.getBitmap(), 0f, 0f, CanvasManager.getPaint(CanvasManager.IMAGE_HD));
        canvas.drawBitmap(BitmapsManager.MENU_HEADER.getBitmap(), 0f, 0f, CanvasManager.getPaint(CanvasManager.IMAGE_HD));
        goldButton.draw(canvas);
        shopButton.draw(canvas);
        playButton.draw(canvas);
        rankButton.draw(canvas);
    }


    @Override
    public void initializeScene() {
        super.camera = new Camera(new float[]{0, 0}, new float[]{ScreenManager.width, ScreenManager.height});
    }

}
