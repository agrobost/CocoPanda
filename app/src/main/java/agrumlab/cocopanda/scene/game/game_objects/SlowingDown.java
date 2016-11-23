package agrumlab.cocopanda.scene.game.game_objects;

/**
 * Created by Alexandre on 30/01/2015.
 */
/*
public class SlowingDown extends GameObject {

    private Random random = new Random();

    public SlowingDown(Scene scene, int vitesseY_min, int vitesseY_max) {
        super(scene);
        super.bitmap = BitmapsManager.GAME_TIMER_GAMEOBJECT.getBitmap();

        float x, y;
        y = -bitmap.getHeight();
        x = (random.nextInt((int) ScreenManager.width) - (bitmap.getWidth() / 2))+ ScreenManager.width /2;
        super.coord = new float[]{x,y};

        super.vitesse[1] = ScreenManager.height *(random.nextInt(vitesseY_max - vitesseY_min + 1) + vitesseY_min)/1920;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, super.getCoordOnScreen()[0], super.getCoordOnScreen()[1], CanvasManager.getPaint(CanvasManager.IMAGE_HD));
    }


    @Override
    public void animation(Iterator iterator) {
        if(super.coord[1]> ScreenManager.height){
            /*
            super.coord[1] = -bitmap.getHeight();
            super.coord[0] = (random.nextInt(1080) - (bitmap.getWidth() / 2))+1080/2;
            *//*
            iterator.remove();

        }else {
            super.coord[1] = super.coord[1] + super.vitesse[1] ;
        }
    }

    @Override
    protected void inCollision(GameObject panda, Iterator iterator) {
        SoundManager.playSoundEffect(R.raw.timer);
        Game level = scene.getSurface().getGame();
        iterator.remove();
       // scene.getSurface().getGame().setSpeed(-10f * ScreenManager.adjustHeight);
        Timer timer = new Timer();
       /* timer.schedule(new TimerTask() {
            @Override
            public void run() {
                scene.getSurface().getGame().setSpeed(0);
            }
        },5000);
        //le top serait de créer une fonction destroy dans game_object_coco pour lancer une animation de l'explosion de la game_object_coco et la détruire par la suite
        //aussi lancer une animation sur le panda genre le front rouge
    }
}
*/