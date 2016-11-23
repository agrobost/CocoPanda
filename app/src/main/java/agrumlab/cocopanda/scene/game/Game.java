package agrumlab.cocopanda.scene.game;

import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.List;

import agrumlab.cocopanda.Surface;
import agrumlab.cocopanda.ressources.PreferenceMemory;
import agrumlab.cocopanda.ressources.ScreenManager;
import agrumlab.cocopanda.scene.Button;
import agrumlab.cocopanda.scene.game.button.Pause;
import agrumlab.cocopanda.scene.GameObject;
import agrumlab.cocopanda.scene.game.game_objects.Panda;
import agrumlab.cocopanda.scene.game.game_objects.Background;
import agrumlab.cocopanda.scene.Camera;
import agrumlab.cocopanda.scene.Scene;

/**
 * Created by Alexandre on 30/01/2015.
 */
public abstract class Game extends Scene {


    public String reference;
    public float oneStar, twoStar, threeStar;
    protected Boolean running = true;
    protected Panda panda = new Panda(this);
    protected Background background = new Background(this);
    protected List<GameObject> gameObjects = new ArrayList<>();
    protected Score score = new Score(this);
    protected Button pauseButton = new Pause(this);

    protected Game(Surface surface) {
        super(surface);
        this.addButton(pauseButton);
    }

    @Override
    public void initializeScene() {
        this.camera = new Camera(new float[]{ScreenManager.width / 2, 0f}, new float[]{ScreenManager.width, ScreenManager.height});
    }

    @Override
    public void touch(MotionEvent event) {
        super.touch(event);
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                panda.actionDown(event);
                break;

            case MotionEvent.ACTION_MOVE:
                panda.actionMove(event);
                break;

            case MotionEvent.ACTION_UP:
                break;
        }

    }


    public Score getScore() {
        return score;
    }

    public Panda getPanda() {
        return panda;
    }

    public Boolean isRunning() {
        return running;
    }

    public void lose() {
        float record = PreferenceMemory.getValueRecord(reference);
        if (record < score.getScoreActuel()) {
            PreferenceMemory.putValueRecord(reference, score.getScoreActuel());
        }

        PreferenceMemory.putGold(getScore().getGold());
        this.surface.changeLayout(Surface.Layout.LOOSE_GAME);
        //this.surface.getActivityMain().showInterstitial();

    }

    public void setRunning(Boolean running) {
        this.running = running;
    }

}
