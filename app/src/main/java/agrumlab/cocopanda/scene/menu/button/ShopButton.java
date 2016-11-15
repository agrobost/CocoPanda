package agrumlab.cocopanda.scene.menu.button;

        import agrumlab.cocopanda.ressources.BitmapsManager;
        import agrumlab.cocopanda.scene.Button;
        import agrumlab.cocopanda.scene.Scene;

/**
 * Created by Alexandre on 06/02/2015.
 */
public class ShopButton extends Button {

    public ShopButton(Scene scene) {
        super(scene);
    }

    @Override
    protected void initializeBitmap() {
        super.bitmap = BitmapsManager.MENU_SHOP_BUTTON.getBitmap();
    }

    @Override
    protected void initializePosition() {
        setPosition(Mark.TOP_RIGHT,0.97f,0.873f);
    }

}
