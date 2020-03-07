package action.filter;

import img.Image;

public class Highlights extends Filter {

    public Highlights(double ratio) {
        this.ratio = ratio;
    }

    @Override
    public Image doAction(Image image) {
        return image;
    }
}
