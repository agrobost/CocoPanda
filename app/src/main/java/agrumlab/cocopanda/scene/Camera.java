package agrumlab.cocopanda.scene;

/**
 * Created by Alexandre on 10/01/2015.
 */
public class Camera {

    public float[] coordCamera = null, dimCamera = null;

    public Camera(float[] coordCamera, float[] dimCamera) {
        this.coordCamera = coordCamera;
        this.dimCamera = dimCamera;
    }

    public float[] getCoordCamera() {
        return coordCamera;
    }

    public void setCoordCamera(float[] coordCamera) {
        this.coordCamera = coordCamera;
    }

    public float[] getDimCamera() {
        return dimCamera;
    }

    public void setDimCamera(float[] dimCamera) {
        this.dimCamera = dimCamera;
    }

}
