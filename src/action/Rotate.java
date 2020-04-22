package action;

import img.Image;

public class Rotate implements Action {
    private float angle;

    public Rotate(float angle) {
        this.angle = angle;
    }

    @Override
    public Image doAction(Image image) {
        return image;
    }

    @Override
    public String toString() {
        return "Rotate{" +
                "angle=" + angle +
                '}';
    }
}
