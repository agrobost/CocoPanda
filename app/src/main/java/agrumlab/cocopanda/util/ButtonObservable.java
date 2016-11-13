package agrumlab.cocopanda.util;

import agrumlab.cocopanda.scene.Button;

/**
 * Created by Alexandre on 13/11/2016.
 */

public interface ButtonObservable extends Observable {
    public void addButtonListener(ButtonListener buttonListener);
    public void removeButtonListener(ButtonListener buttonListener);
    public void notifyListenerButtonClicked();
}
