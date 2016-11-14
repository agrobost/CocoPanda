package agrumlab.cocopanda.scene.menu.button;

        import agrumlab.cocopanda.ressources.EnumBitmaps;
        import agrumlab.cocopanda.scene.Button;
        import agrumlab.cocopanda.scene.Scene;

/**
 * Created by Alexandre on 06/02/2015.
 */
public class ButtonShop extends Button {

    public ButtonShop(Scene scene) {
        super(scene);
    }

    @Override
    protected void initializeBitmap() {
        super.bitmap = EnumBitmaps.MENU_SHOP.geBitmap();
    }

    @Override
    protected void initializePosition() {
        setPosition(Mark.TOP_RIGHT,0.97f,0.873f);
    }

}
