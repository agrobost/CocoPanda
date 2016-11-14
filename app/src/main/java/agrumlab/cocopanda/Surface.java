package agrumlab.cocopanda;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

import agrumlab.cocopanda.ressources.SoundManager;
import agrumlab.cocopanda.scene.Scene;
import agrumlab.cocopanda.scene.game.Level;
import agrumlab.cocopanda.scene.game.Level_1;
import agrumlab.cocopanda.scene.loose.LooseInterface;
import agrumlab.cocopanda.scene.menu.SceneMenu;
import agrumlab.cocopanda.scene.pause.PauseInterface;
import agrumlab.cocopanda.scene.selection_level.SelectionLevel;

/**
 * Created by Alexandre on 28/01/2015.
 */
public class Surface extends SurfaceView implements Runnable {
    private ActivityMain activityMain;
    private SurfaceHolder surfaceHolder;
    private Thread thread = null;
    private boolean isRunning = false;
    ArrayList<Scene> drawnScenes = new ArrayList<>();
    ArrayList<Scene> touchScenes = new ArrayList<>();

    private Level level = null;
    private PauseInterface pauseInterface = null;
    private SceneMenu sceneMenu = null;
    private LooseInterface looseInterface = null;
    private SelectionLevel selectionLevel = null;


    public Surface(ActivityMain activityMain) {
        super(activityMain);
        this.setOnTouchListener(new TouchEvent(this));
        this.activityMain = activityMain;
        surfaceHolder = getHolder();

        this.pauseInterface = new PauseInterface(this);
        this.sceneMenu = new SceneMenu(this);
        this.looseInterface = new LooseInterface(this);
        this.selectionLevel = new SelectionLevel(this);

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
            fetchScenes(canvas, null);
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    public synchronized void fetchScenes(Canvas canvas, MotionEvent event) {
        for (Scene scene : drawnScenes) {
            if (canvas != null) {
                scene.drawScene(canvas);
            }
        }
        for (Scene scene : touchScenes) {
            if (event != null) {
                scene.touch(event);
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
        if (this.level != null) {
            if (this.level.isRunning()) {
                SoundManager.playGameMusic();
            }
        }
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    public PauseInterface getPauseInterface() {
        return pauseInterface;
    }


    public Level getLevel() {
        return this.level;
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
                drawnScenes.add(sceneMenu);
                touchScenes.add(sceneMenu);
                break;
            case NEW_GAME:
                level = new Level_1(this);
                drawnScenes.add(level);
                touchScenes.add(level);
                SoundManager.playGameMusic();
                break;
            case PAUSE_GAME:
                level.setRunning(false);
                drawnScenes.add(level);
                drawnScenes.add(pauseInterface);
                touchScenes.add(pauseInterface);
                SoundManager.pauseGameMusic();
                break;
            case RESUME_GAME:
                level.setRunning(true);
                drawnScenes.add(level);
                touchScenes.add(level);
                SoundManager.playGameMusic();
                break;
            case LOOSE_GAME:
                level.setRunning(false);
                drawnScenes.add(level);
                drawnScenes.add(looseInterface);
                touchScenes.add(looseInterface);
                SoundManager.playSoundEffect(R.raw.lose);
                SoundManager.stopGameMusic();
                break;
            case REPLAY:
                level = new Level_1(this);
                drawnScenes.add(level);
                touchScenes.add(level);
                SoundManager.stopGameMusic();
                SoundManager.playGameMusic();
                break;
            case SELECT_LEVEL:
                drawnScenes.add(selectionLevel);
                touchScenes.add(selectionLevel);
                break;
        }
    }

}