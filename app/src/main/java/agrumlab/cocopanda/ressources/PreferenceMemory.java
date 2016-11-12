package agrumlab.cocopanda.ressources;

import android.content.SharedPreferences;

/**
 * Created by Alexandre on 10/02/2015.
 */
public class PreferenceMemory {


    public static void putValueRecord(String level, float record) {
        SharedPreferences sharedPreferences = GameApplication.getAppContext().getSharedPreferences(level, GameApplication.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.putFloat("record", record);
        editor.commit();
    }

    public static float getValueRecord(String level) {
        SharedPreferences sharedPreferences = GameApplication.getAppContext().getSharedPreferences(level, GameApplication.MODE_PRIVATE);
        float record = sharedPreferences.getFloat("record", new Float(0f));
        return record;
    }

    /////////////////GAME MUSIC/////////////////
    public static void muteGameMusic() {
        putMusic(false);
    }

    public static void demuteGameMusic() {
        putMusic(true);
    }

    private static void putMusic(boolean music) {
        SharedPreferences sharedPreferences = GameApplication.getAppContext().getSharedPreferences("music", GameApplication.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.putBoolean("music", music);
        editor.commit();
    }

    public static boolean gameMusicIsEnable() {
        SharedPreferences sharedPreferences = GameApplication.getAppContext().getSharedPreferences("music", GameApplication.MODE_PRIVATE);
        boolean isMusic = sharedPreferences.getBoolean("music", true);
        return isMusic;
    }

    /////////////////SOUND EFFECTS/////////////////
    public static void muteSoundEffects() {
        putSoundEffects(false);
    }

    public static void demuteSoundEffects() {
        putSoundEffects(true);
    }

    private static void putSoundEffects(boolean music) {
        SharedPreferences sharedPreferences = GameApplication.getAppContext().getSharedPreferences("sound_effects", GameApplication.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.putBoolean("sound_effects", music);
        editor.commit();
    }

    public static boolean soundEffectsIsEnable() {
        SharedPreferences sharedPreferences = GameApplication.getAppContext().getSharedPreferences("sound_effects", GameApplication.MODE_PRIVATE);
        boolean isSoundEffects = sharedPreferences.getBoolean("sound_effects", true);
        return isSoundEffects;
    }

    /////////////////SENSITIVITY/////////////////

    public static void putSensitivity(float sensitivity) {
        SharedPreferences sharedPreferences = GameApplication.getAppContext().getSharedPreferences("sensitivity", GameApplication.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.putFloat("sensitivity", sensitivity);
        editor.commit();
    }

    public static float getSensitivity() {
        SharedPreferences sharedPreferences = GameApplication.getAppContext().getSharedPreferences("sensitivity", GameApplication.MODE_PRIVATE);
        float sensitivity = sharedPreferences.getFloat("sensitivity", 1.5f);
        return sensitivity;
    }

    public static void putGold(int gold) {
        SharedPreferences sharedPreferences = GameApplication.getAppContext().getSharedPreferences("gold", GameApplication.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.putInt("gold", gold);
        editor.commit();
    }

    public static int getGold() {
        SharedPreferences sharedPreferences = GameApplication.getAppContext().getSharedPreferences("gold", GameApplication.MODE_PRIVATE);
        int gold = sharedPreferences.getInt("gold", 0);
        return gold;
    }
}
