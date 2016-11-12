package agrumlab.cocopanda.ressources;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import agrumlab.cocopanda.R;

/**
 * Created by Alexandre on 12/11/2016.
 */
public enum EnumBitmaps {
    MENU_BACKGROUND(R.drawable.menu_background, 1080f, 1920f),
    MENU_HEADER(R.drawable.menu_head, 1080f, 480f),
    MENU_COIN(R.drawable.menu_gold, 589f, 176f),
    MENU_PLAY(R.drawable.menu_play, 555f, 555f),
    MENU_SHOP(R.drawable.menu_shop, 493f, 176f),
    MENU_RANK(R.drawable.menu_rank, 493f, 176f),
    GAME_SCORE(R.drawable.game_score, 380f, 114f),
    GAME_COIN(R.drawable.game_piece, 380f, 114f),
    GAME_LIFE(R.drawable.game_vie, 223f, 114f),
    GAME_PAUSE(R.drawable.game_pause, 140f, 140f),
    GAME_BACKGROUND(R.drawable.game_object_background, 2160f, 1920f),
    OBJECT_COCO(R.drawable.game_object_coco, 70f, 72f),
    OBJECT_PANDA(R.drawable.game_object_panda, 80f, 87f),
    OBJECT_TIMER(R.drawable.game_object_timer, 70f, 81f),
    OBJECT_HEART(R.drawable.game_object_coeur, 60f, 49f),
    OBJECT_BEE(R.drawable.game_object_bee, 70f, 80f),
    OBJECT_COIN(R.drawable.game_object_coin, 70f, 70f),
    PAUSE_BACKGROUND(R.drawable.pause_fond, 898f, 982f),
    PAUSE_SENSITIVITY(R.drawable.pause_sensitivity, 79f, 79f),
    PAUSE_SOUND_EFFECTS(R.drawable.pause_sound, 256f, 63f),
    PAUSE_MUSIC(R.drawable.pause_music, 270f, 63f),
    PAUSE_CHECKED(R.drawable.pause_checked, 78f, 79f),
    PAUSE_RESUME(R.drawable.pause_resume, 243f, 243f),
    LOOSE_BACKGROUND(R.drawable.loose_background, 898f, 982f),
    LOOSE_STAR_EMPTY(R.drawable.loose_star_empty, 257f, 246f),
    LOOSE_STAR_FILL(R.drawable.loose_star_fill, 257f, 246f),
    REPLAY(R.drawable.pause_replay, 243f, 243f),
    MENU(R.drawable.pause_menu, 243f, 243f);

    private float width;
    private float height;
    private int ref;
    private Bitmap bitmap = null;

    EnumBitmaps(int ref, float width, float height) {
        this.ref = ref;
        this.width = width;
        this.height = height;
    }

    public Bitmap geBitmap() {
        return bitmap;
    }

    private void load(Context context) {
        this.bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), this.ref), (int) (width), (int) (height), true);
    }

    public static void loadBitmaps(Context context) {
        for (EnumBitmaps enumBitmaps : EnumBitmaps.values()) {
            enumBitmaps.load(context);
        }
    }

}