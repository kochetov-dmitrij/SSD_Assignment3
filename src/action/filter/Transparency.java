package action.filter;

import img.Image;

public class Transparency extends Filter {

    Transparency(float ratio) {
        this.ratio = ratio;
    }

    @Override
    public Image doAction(Image image) {
        return null;
    }
}
