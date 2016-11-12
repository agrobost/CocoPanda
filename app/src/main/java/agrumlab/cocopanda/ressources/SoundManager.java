package agrumlab.cocopanda.ressources;

import android.media.MediaPlayer;

import com.google.android.gms.games.Game;

import agrumlab.cocopanda.R;

/**
 * Created by Alexandre on 10/11/2016.
 */

public class SoundManager {
    private static MediaPlayer gameMusic = MediaPlayer.create(GameApplication.getAppContext(), R.raw.song);
    public static void playSoundEffect(int id){
        if(!PreferenceMemory.soundEffectsIsEnable()){
            return;
        }
        MediaPlayer mp = MediaPlayer.create(GameApplication.getAppContext(), id);
        mp.start();
    }
    public static void playGameMusic(){
        gameMusic.start();
    }

    public static void pauseGameMusic(){
        gameMusic.pause();
    }

    public static void stopGameMusic(){
        gameMusic.pause();
        gameMusic.seekTo(0);
    }

    public static void muteGameMusic(){
        gameMusic.setVolume(0f,0f);
    }
    public static void demuteGameMusic(){
        gameMusic.setVolume(1f,1f);
    }
}
