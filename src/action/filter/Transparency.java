package action.filter;

import img.Image;

public class Transparency extends Filter {

    public Transparency(double ratio) {
        this.ratio = ratio;
    }

    @Override
    public Image doAction(Image image) {
        return image;
    }
}
