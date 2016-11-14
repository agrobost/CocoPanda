package agrumlab.cocopanda.scene.game;

import android.graphics.Canvas;

import java.text.DecimalFormat;

import agrumlab.cocopanda.ressources.CanvasManager;
import agrumlab.cocopanda.ressources.EnumBitmaps;
import agrumlab.cocopanda.ressources.PreferenceMemory;
import agrumlab.cocopanda.scene.Scene;

public class Score {

    private float scoreActuel = 0f;
    private int numberLife = 1;
    private DecimalFormat df = new DecimalFormat("#.###");
    private int gold;
    private Scene scene;

    public Score(Scene scene) {
        this.scene = scene;
        gold = PreferenceMemory.getGold();
    }

    public void drawScene(Canvas canvas, boolean running, float time) {

        CanvasManager.drawBitmapAdjust(canvas, EnumBitmaps.GAME_SCORE.geBitmap(), 11f, 8f, CanvasManager.getPaint(CanvasManager.IMAGE_HD));
        CanvasManager.drawBitmapAdjust(canvas, EnumBitmaps.GAME_LIFE.geBitmap(), 11f, 260f, CanvasManager.getPaint(CanvasManager.IMAGE_HD));
        CanvasManager.drawBitmapAdjust(canvas, EnumBitmaps.GAME_COIN.geBitmap(), 11f, 134f, CanvasManager.getPaint(CanvasManager.IMAGE_HD));

        CanvasManager.drawTextAdjust(canvas, df.format(time/1000f) + "s", 145f, 86f, CanvasManager.getPaint(CanvasManager.TEXT_SCORE));
        CanvasManager.drawTextAdjust(canvas, "" + gold, 145f, 214f, CanvasManager.getPaint(CanvasManager.TEXT_SCORE));
        CanvasManager.drawTextAdjust(canvas, "" + numberLife, 145f, 342f, CanvasManager.getPaint(CanvasManager.TEXT_SCORE));

    }

    public int getNumberLife() {
        return numberLife;
    }

    public void setNumberLife(int numberLife) {
        if (numberLife >= 0) {
            this.numberLife = numberLife;
        } else {
            scene.getSurface().getLevel().lose();
        }
    }

    public float getScoreActuel() {
        return scoreActuel;
    }

    @Override
    public String toString() {
        return "" + df.format(scoreActuel);
    }

    public void setGold(int i) {
        gold = i;
    }

    public int getGold() {
        return gold;
    }
}
