package agrumlab.cocopanda.scene;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.MotionEvent;

import java.util.ArrayList;

import agrumlab.cocopanda.ressources.CanvasManager;
import agrumlab.cocopanda.ressources.Screen;
import agrumlab.cocopanda.util.ButtonListener;
import agrumlab.cocopanda.util.ButtonObservable;
import agrumlab.cocopanda.util.Position;

public abstract class Button implements ButtonObservable {
    private ArrayList<ButtonListener> buttonListeners;
    protected Bitmap bitmap = null;
    private Scene scene;
    protected Position position;
    protected enum Mark{
        LEFT, TOP_LEFT, TOP, TOP_RIGHT, RIGHT, BOT_RIGHT, BOT, BOT_LEFT, MIDDLE;
    }

    public Button(Scene scene) {
        this.scene = scene;
        buttonListeners = new ArrayList<>();
        initializeBitmap();
        initializePositon();
    }

    protected abstract void initializeBitmap();

    protected abstract void initializePositon();


    private boolean down = false;

    public void actionDown(MotionEvent event) {
        if (event.getX() >= position.getX() && event.getX() <= position.getX() + bitmap.getWidth() && event.getY() >= position.getY() && event.getY() <= position.getY() + bitmap.getHeight()) {
            down = true;
        } else {
            down = false;
        }
    }

    //si le doigt ne sort pas du bouton
    public void actionMove(MotionEvent event) {
        if (!(event.getX() >= position.getX() && event.getX() <= position.getX() + bitmap.getWidth() && event.getY() >= position.getY() && event.getY() <= position.getY() + bitmap.getHeight())) {
            down = false;
        } else {
            down = true;
        }
    }

    public void actionUp(MotionEvent event) {
        if (down) {
            down = false;
            notifyListenerButtonClicked();
        }
    }


    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, position.getX(), position.getY(), CanvasManager.getPaint(CanvasManager.IMAGE_HD));
    }


    @Override
    public void addButtonListener(ButtonListener buttonListener) {
        buttonListeners.add(buttonListener);
    }

    @Override
    public void removeButtonListener(ButtonListener buttonListener) {
        int i = buttonListeners.indexOf(buttonListener);
        if(i>=0){
            buttonListeners.remove(i);
        }
    }

    @Override
    public void notifyListenerButtonClicked() {
        for(int i = 0; i < buttonListeners.size(); i++){
            ButtonListener buttonListener = buttonListeners.get(i);
            buttonListener.buttonClicked();
        }
    }
    public void setPosition(Mark mark, float percentageX, float percentageY){
        float adjustX_withMark = 0f, adjustY_withMark = 0f;
        float realX, realY;
        float widthBitmap = bitmap.getWidth();
        float heightBitmap = bitmap.getHeight();
        switch (mark){
            case LEFT:
                adjustX_withMark = 0f;
                adjustY_withMark = -0.5f;
                break;
            case TOP_LEFT:
                adjustX_withMark = 0f;
                adjustY_withMark = 0f;
                break;
            case TOP:
                adjustX_withMark = -0.5f;
                adjustY_withMark = 0f;
                break;
            case TOP_RIGHT:
                adjustX_withMark = -1f;
                adjustY_withMark = 0f;
                break;
            case RIGHT:
                adjustX_withMark = -1f;
                adjustY_withMark = -0.5f;
                break;
            case BOT_RIGHT:
                adjustX_withMark = -1f;
                adjustY_withMark = -1f;
                break;
            case BOT:
                adjustX_withMark = -0.5f;
                adjustY_withMark = -1f;
                break;
            case BOT_LEFT:
                adjustX_withMark = 0f;
                adjustY_withMark = -1f;
                break;
            case MIDDLE:
                adjustX_withMark = -0.5f;
                adjustY_withMark = -0.5f;
                break;
        }
        adjustX_withMark = adjustX_withMark*widthBitmap;
        adjustY_withMark = adjustY_withMark*heightBitmap;
        realX = Screen.width*percentageX + adjustX_withMark;
        realY = Screen.height*percentageY + adjustY_withMark;
        this.position = new Position(realX,realY);
    }
}
