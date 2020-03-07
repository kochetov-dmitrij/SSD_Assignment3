package action.filter;

import img.Image;

public class Expose extends Filter {

    public Expose(double ratio) {
        this.ratio = ratio;
    }

    @Override
    public Image doAction(Image image) {
        return image;
    }
}
