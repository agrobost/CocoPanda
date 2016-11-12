package agrumlab.cocopanda;

import android.view.MotionEvent;
import android.view.View;

public class TouchEvent implements View.OnTouchListener {
    private Surface surface;
    public TouchEvent(Surface surface) {
        this.surface = surface;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        surface.fetchScenes(null, event);
        return true;
    }

}
