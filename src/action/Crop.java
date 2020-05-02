package action;

import img.Image;

public class Crop implements Action {
    private int x1, y1, x2, y2;

    public Crop(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public Image doAction(Image image) {
        return image;
    }

    @Override
    public String toString() {
        return "Crop{" +
                "x1=" + x1 +
                ", y1=" + y1 +
                ", x2=" + x2 +
                ", y2=" + y2 +
                '}';
    }
}
