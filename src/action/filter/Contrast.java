package action.filter;

import img.Image;

public class Contrast extends Filter {
    public Contrast(double ratio) {
        this.ratio = ratio;
    }

    @Override
    public Image doAction(Image image) {
        return image;
    }
}
