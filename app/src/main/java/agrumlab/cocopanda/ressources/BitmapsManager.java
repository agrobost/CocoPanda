package agrumlab.cocopanda.ressources;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import agrumlab.cocopanda.R;

public enum BitmapsManager {
    MENU_BACKGROUND(R.drawable.menu_background, 1080f, 1920f),
    MENU_HEADER(R.drawable.menu_header, 1080f, 480f),
    MENU_BUYCOINS_BUTTON(R.drawable.menu_buycoins_button, 589f, 176f),
    MENU_PLAY_BUTTON(R.drawable.menu_play_button, 555f, 555f),
    MENU_SHOP_BUTTON(R.drawable.menu_shop_button, 493f, 176f),
    MENU_RANK_BUTTON(R.drawable.menu_rank_button, 493f, 176f),
    GAME_BANNER_TIME(R.drawable.game_banner_time, 380f, 114f),
    GAME_BANNER_COIN(R.drawable.game_banner_coin, 380f, 114f),
    GAME_BANNER_NUMBER_OF_HEART(R.drawable.game_banner_number_of_heart, 223f, 114f),
    GAME_PAUSE_BUTTON(R.drawable.game_pause_button, 140f, 140f),
    GAME_BACKGROUND_GAMEOBJECT(R.drawable.game_background_gameobject, 2160f, 1920f),
    GAME_COCO_GAMEOBJECT(R.drawable.game_coco_gameobject, 70f, 72f),
    GAME_PANDA_GAMEOBJECT(R.drawable.game_panda_gameobject, 80f, 87f),
    GAME_TIMER_GAMEOBJECT(R.drawable.game_timer_gameobject, 70f, 81f),
    GAME_HEART_GAMEOBJECT(R.drawable.game_heart_gameobject, 60f, 49f),
    GAME_BEE_GAMEOBJECT(R.drawable.game_bee_gameobject, 70f, 80f),
    GAME_COIN_GAMEOBJECT(R.drawable.game_coin_gameobject, 70f, 70f),
    PAUSE_BACKGROUND(R.drawable.pause_fond, 898f, 982f),
    PAUSE_SENSITIVITY_BUTTON(R.drawable.pause_sensitivity_button, 79f, 79f),
    PAUSE_SOUNDEFFECTS_BUTTON(R.drawable.pause_soundeffects_button, 256f, 63f),
    PAUSE_MUSIC_BUTTON(R.drawable.pause_music_button, 270f, 63f),
    PAUSE_CHECKED(R.drawable.pause_checked, 78f, 79f),
    PAUSE_RESUME_BUTTON(R.drawable.pause_resume_button, 243f, 243f),
    LOOSE_BACKGROUND(R.drawable.loose_background, 898f, 982f),
    LOOSE_EMPTYSTAR(R.drawable.loose_emptystar, 257f, 246f),
    LOOSE_FULLSTAR(R.drawable.loose_fullstar, 257f, 246f),
    BUTTON_REPLAY(R.drawable.button_replay, 243f, 243f),
    BUTTON_MENU(R.drawable.button_menu, 243f, 243f),
    SELECT_LEVEL_BACKGROUND(R.drawable.select_level_background,1080f,1920f),
    SELECT_LEVEL_BACK_BUTTON(R.drawable.select_level_back_button,244f,244f),
    SELECT_LEVEL_CADENA(R.drawable.select_level_cadena,258f,260f),
    SELECTLEVEL_LEVEL1_BUTTON(R.drawable.selectlevel_level1_button,258f,260f),
    SELECTLEVEL_LEVEL2_BUTTON(R.drawable.selectlevel_level2_button,258f,260f),
    SELECTLEVEL_LEVEL3_BUTTON(R.drawable.selectlevel_level3_button,258f,260f),
    SELECTLEVEL_LEVEL4_BUTTON(R.drawable.selectlevel_level4_button,258f,260f),
    SELECTLEVEL_LEVEL5_BUTTON(R.drawable.selectlevel_level5_button,258f,260f),
    SELECTLEVEL_LEVEL6_BUTTON(R.drawable.selectlevel_level6_button,258f,260f),
    SELECTLEVEL_LEVEL7_BUTTON(R.drawable.selectlevel_level7_button,258f,260f),
    SELECTLEVEL_LEVEL8_BUTTON(R.drawable.selectlevel_level8_button,258f,260f),
    SELECTLEVEL_LEVEL9_BUTTON(R.drawable.selectlevel_level9_button,258f,260f),
    SELECT_LEVEL_FULLSTAR(R.drawable.select_level_fullstar,116f,112f),
    SELECT_LEVEL_EMPTYSTAR(R.drawable.select_level_emptystar,116f,112f);

    private float width;
    private float height;
    private int ref;
    private Bitmap bitmap = null;

    BitmapsManager(int ref, float width, float height) {
        this.ref = ref;
        this.width = width;
        this.height = height;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    private void load(Context context) {
        this.bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), this.ref), (int) (width), (int) (height), true);
    }

    public static void loadBitmaps(Context context) {
        for (BitmapsManager bitmapsManager : BitmapsManager.values()) {
            bitmapsManager.load(context);
        }
    }

}