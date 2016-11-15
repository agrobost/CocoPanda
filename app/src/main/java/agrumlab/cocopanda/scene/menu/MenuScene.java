package agrumlab.cocopanda.scene.menu;

import android.graphics.Canvas;

import agrumlab.cocopanda.Surface;
import agrumlab.cocopanda.ressources.BitmapsManager;
import agrumlab.cocopanda.ressources.CanvasManager;
import agrumlab.cocopanda.ressources.ScreenManager;
import agrumlab.cocopanda.scene.Camera;
import agrumlab.cocopanda.scene.Scene;
import agrumlab.cocopanda.scene.menu.button.GoldButton;
import agrumlab.cocopanda.scene.menu.button.PlayButton;
import agrumlab.cocopanda.scene.menu.button.RankButton;
import agrumlab.cocopanda.scene.menu.button.ShopButton;

/**
 * Created by Alexandre on 06/02/2015.
 */
public class MenuScene extends Scene {

    private GoldButton goldButton;
    private ShopButton shopButton;
    private PlayButton playButton;
    private RankButton rankButton;


    public MenuScene(Surface surface) {
        super(surface);
        rankButton = new RankButton(this);
        playButton = new PlayButton(this);
        shopButton = new ShopButton(this);
        goldButton = new GoldButton(this);
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
