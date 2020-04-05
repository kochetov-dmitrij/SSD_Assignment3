package img;

import action.Action;

public class ImageState {
    public Image img;
    public Action lastAction;

    public ImageState(Image img, Action lastAction) {
        this.img = img;
        this.lastAction = lastAction;
    }
}
