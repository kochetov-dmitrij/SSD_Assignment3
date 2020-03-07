package action.filter;

import img.Image;

public class Saturation extends Filter {

    public Saturation(double ratio) {
        this.ratio = ratio;
    }

    @Override
    public Image doAction(Image image) {
        return image;
    }
}
