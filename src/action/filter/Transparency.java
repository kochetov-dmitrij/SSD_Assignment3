package action.filter;

import img.Image;

public class Transparency extends Filter {

    public Transparency(float ratio) {
        this.ratio = ratio;
    }

    @Override
    public Image doAction(Image image) {
        return null;
    }
}
