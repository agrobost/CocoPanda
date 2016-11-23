package agrumlab.cocopanda.ressources;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Debug;
import android.util.Log;
import android.widget.ProgressBar;

import agrumlab.cocopanda.ActivityMain;
import agrumlab.cocopanda.R;
import agrumlab.cocopanda.Surface;

public class LoadingRessources extends AsyncTask <Context, Integer, Void>{
    ActivityMain activityMain;
    ProgressBar progressBar;

    public LoadingRessources(ActivityMain activityMain, ProgressBar progressBar) {
        this.activityMain = activityMain;
        this.progressBar = progressBar;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        this.progressBar.setProgress(values[0]);
    }

    @Override
    protected Void doInBackground(Context... contexts) {
        float numberBitmaps = BitmapsManager.values().length;
        float bitmapLoaded = 0;
        float tmp;
        for(BitmapsManager bitmapsManager : BitmapsManager.values()){
            BitmapsManager.loadBitmap(bitmapsManager,contexts[0]);
            bitmapLoaded++;
            tmp = bitmapLoaded/numberBitmaps * 100f;
            publishProgress((int)Math.round(tmp));
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        activityMain.surface = new Surface(activityMain,null);
        activityMain.surface.resume();
        //555
         activityMain.setContentView(activityMain.surface);
    }
}
