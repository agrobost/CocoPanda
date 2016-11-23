package agrumlab.cocopanda;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.util.ArrayList;

import agrumlab.cocopanda.ressources.SoundManager;
import agrumlab.cocopanda.scene.Scene;
import agrumlab.cocopanda.scene.game.Game;
import agrumlab.cocopanda.scene.game.Level1;
import agrumlab.cocopanda.scene.loose.Loose;
import agrumlab.cocopanda.scene.menu.Menu;
import agrumlab.cocopanda.scene.pause.Pause;
import agrumlab.cocopanda.scene.selection_level.ChooseLevel;

/**
 * Created by Alexandre on 28/01/2015.
 */
public class Surface extends SurfaceView {
    private ActivityMain activityMain;
    private SurfaceHolder surfaceHolder;
    private Thread thread = null;
    private boolean isRunning = false;
    private ArrayList<Scene> drawnScenes = new ArrayList<>();
    private ArrayList<Scene> touchScenes = new ArrayList<>();

    private Game game = null;
    private Pause pause = null;
    private Menu menu = null;
    private Loose loose = null;
    private ChooseLevel chooseLevel = null;

    public Surface(Context context, AttributeSet attrs) {
        super(context, attrs);
        if(!isInEditMode()){
            this.setOnTouchListener(new OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    fetchScenes(motionEvent);
                    return true;
                }
            });
            this.activityMain = activityMain;
            this.surfaceHolder = getHolder();
            this.pause = new Pause(this);
            this.menu = new Menu(this);
            this.loose = new Loose(this);
            this.chooseLevel = new ChooseLevel(this);
            changeLayout(Layout.MENU);
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
        if (this.game != null) {
            if (this.game.isRunning()) {
                SoundManager.playGameMusic();
            }
        }
        isRunning = true;
        thread = new Thread(new Runnable() {
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
        });
        thread.start();
    }

    public Game getGame() {
        return this.game;
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
                drawnScenes.add(menu);
                touchScenes.add(menu);
                break;
            case NEW_GAME:
                drawnScenes.add(game);
                touchScenes.add(game);
                SoundManager.playGameMusic();
                SoundManager.stopGameMusic();
                SoundManager.playGameMusic();
                break;
            case PAUSE_GAME:
                game.setRunning(false);
                drawnScenes.add(game);
                drawnScenes.add(pause);
                touchScenes.add(pause);
                SoundManager.pauseGameMusic();
                break;
            case RESUME_GAME:
                game.setRunning(true);
                drawnScenes.add(game);
                touchScenes.add(game);
                SoundManager.playGameMusic();
                break;
            case LOOSE_GAME:
                game.setRunning(false);
                drawnScenes.add(game);
                drawnScenes.add(loose);
                touchScenes.add(loose);
                SoundManager.playSoundEffect(R.raw.lose);
                SoundManager.stopGameMusic();
                break;
            case REPLAY:
                game = new Level1(this);
                drawnScenes.add(game);
                touchScenes.add(game);
                SoundManager.stopGameMusic();
                SoundManager.playGameMusic();
                break;
            case SELECT_LEVEL:
                drawnScenes.add(chooseLevel);
                touchScenes.add(chooseLevel);
                break;
        }
    }

    public void setGame(Game game) {
        this.game = game;
    }
}