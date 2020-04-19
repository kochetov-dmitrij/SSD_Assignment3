package gui;

import img.ImageBuilderCaretaker;

/**
 * BaseView displays an image itself and provides zoom-in / zoom-out, scroll operations
 */
public class ImageView implements View {
    public void display(){
        System.out.println("{ " + img.getCurrentImage().toString() + " }");
    }
    protected ImageBuilderCaretaker img;

    public ImageBuilderCaretaker getImageBuilderCaretaker() {
        return img;
    }

    public ImageView(ImageBuilderCaretaker img) {
        this.img = img;
    }
}
