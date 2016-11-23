package agrumlab.cocopanda;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import agrumlab.cocopanda.ressources.BitmapsManager;
import agrumlab.cocopanda.ressources.LoadingRessources;
import agrumlab.cocopanda.ressources.ScreenManager;

/**
 * Created by Alexandre on 10/12/2014.
 */
public class ActivityMain extends Activity {

    public Surface surface = null;
    private InterstitialAd mInterstitialAd;
    private LoadingRessources loadingRessources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        hideSystemUI();


        mInterstitialAd = newInterstitialAd();
        loadInterstitial();
        ScreenManager.initialize(this);
        for(BitmapsManager bitmapsManager : BitmapsManager.values()){
            BitmapsManager.loadBitmap(bitmapsManager,this);
        }
        //setContentView(R.layout.menu);
        //surface = (Surface)findViewById(R.id.surface);
        loadingRessources = new LoadingRessources(this, (ProgressBar) findViewById(R.id.progressBar_loading));
        loadingRessources.execute(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(surface!=null){
            surface.resume();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        if(surface!=null){
            surface.pause();
        }

    }

    // This snippet hides the system bars.
    private void hideSystemUI() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Set the IMMERSIVE flag.
        // Set the content to appear under the system bars so that the content
        // doesn't resize when the system bars hide and show.
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);
    }


    private InterstitialAd newInterstitialAd() {
        InterstitialAd interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-7890994963397260/1713489638");
        interstitialAd.setAdListener(new AdListener() {

            @Override
            public void onAdClosed() {
                // Proceed to the next level.
                goToNextLevel();
            }
        });
        return interstitialAd;
    }

    public void showInterstitial() {
        // Show the ad if it's ready. Otherwise toast and reload the ad.
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
            }
        });
    }

    private void loadInterstitial() {
        // Disable the next level button and load the ad.
        final AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mInterstitialAd.loadAd(adRequest);
            }
        });
    }

    private void goToNextLevel() {
        // Show the next level and reload the ad to prepare for the level after.
        mInterstitialAd = newInterstitialAd();
        loadInterstitial();
    }
}
