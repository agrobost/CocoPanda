package agrumlab.cocopanda;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.util.ArrayList;
import java.util.Objects;

import agrumlab.cocopanda.ressources.SoundManager;
import agrumlab.cocopanda.scene.Scene;
import agrumlab.cocopanda.scene.game.GameScene;
import agrumlab.cocopanda.scene.game.Level1Scene;
import agrumlab.cocopanda.scene.loose.LooseScene;
import agrumlab.cocopanda.scene.menu.MenuScene;
import agrumlab.cocopanda.scene.pause.PauseScene;
import agrumlab.cocopanda.scene.selection_level.ChooseLevelScene;

/**
 * Created by Alexandre on 28/01/2015.
 */
public class Surface extends SurfaceView implements Runnable {
    private ActivityMain activityMain;
    private SurfaceHolder surfaceHolder;
    private Thread thread = null;
    private boolean isRunning = false;
    private ArrayList<Scene> drawnScenes = new ArrayList<>();
    private ArrayList<Scene> touchScenes = new ArrayList<>();

    private GameScene gameScene = null;
    private PauseScene pauseScene = null;
    private MenuScene menuScene = null;
    private LooseScene looseScene = null;
    private ChooseLevelScene chooseLevelScene = null;


    public Surface(ActivityMain activityMain) {
        super(activityMain);
        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                fetchScenes(motionEvent);
                return true;
            }
        });
        this.activityMain = activityMain;
        this.surfaceHolder = getHolder();
        this.pauseScene = new PauseScene(this);
        this.menuScene = new MenuScene(this);
        this.looseScene = new LooseScene(this);
        this.chooseLevelScene = new ChooseLevelScene(this);
        changeLayout(Layout.MENU);
    }


    @Override
    public void run() {
        while (isRunning) {
            if (!surfaceHolder.getSurface().isValid()) {
                continue;
            }
            Canvas canvas = surfaceHolder.lockCanvas();
            canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
            fetchScenes(canvas);
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    public synchronized void fetchScenes(Object obj) {
        if (obj instanceof Canvas) {
            for (Scene scene : drawnScenes) {
                scene.drawScene((Canvas) obj);
            }
        }
        if (obj instanceof MotionEvent) {
            for (Scene scene : touchScenes) {
                scene.touch((MotionEvent) obj);
            }
        }
    }


    public void pause() {
        SoundManager.pauseGameMusic();
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread = null;
    }

    public void resume() {
        if (this.gameScene != null) {
            if (this.gameScene.isRunning()) {
                SoundManager.playGameMusic();
            }
        }
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    public PauseScene getPauseScene() {
        return pauseScene;
    }


    public GameScene getGameScene() {
        return this.gameScene;
    }

    public ActivityMain getActivityMain() {
        return this.activityMain;
    }

    public enum Layout {
        MENU, SELECT_LEVEL, NEW_GAME, PAUSE_GAME, RESUME_GAME, LOOSE_GAME, REPLAY;
    }

    public void changeLayout(Layout layout) {
        drawnScenes.clear();
        touchScenes.clear();
        switch (layout) {
            case MENU:
                drawnScenes.add(menuScene);
                touchScenes.add(menuScene);
                break;
            case NEW_GAME:
                drawnScenes.add(gameScene);
                touchScenes.add(gameScene);
                SoundManager.playGameMusic();
                SoundManager.stopGameMusic();
                SoundManager.playGameMusic();
                break;
            case PAUSE_GAME:
                gameScene.setRunning(false);
                drawnScenes.add(gameScene);
                drawnScenes.add(pauseScene);
                touchScenes.add(pauseScene);
                SoundManager.pauseGameMusic();
                break;
            case RESUME_GAME:
                gameScene.setRunning(true);
                drawnScenes.add(gameScene);
                touchScenes.add(gameScene);
                SoundManager.playGameMusic();
                break;
            case LOOSE_GAME:
                gameScene.setRunning(false);
                drawnScenes.add(gameScene);
                drawnScenes.add(looseScene);
                touchScenes.add(looseScene);
                SoundManager.playSoundEffect(R.raw.lose);
                SoundManager.stopGameMusic();
                break;
            case REPLAY:
                gameScene = new Level1Scene(this);
                drawnScenes.add(gameScene);
                touchScenes.add(gameScene);
                SoundManager.stopGameMusic();
                SoundManager.playGameMusic();
                break;
            case SELECT_LEVEL:
                drawnScenes.add(chooseLevelScene);
                touchScenes.add(chooseLevelScene);
                break;
        }
    }

    public void setGameScene(GameScene gameScene) {
        this.gameScene = gameScene;
    }
}