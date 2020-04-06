package gui;

import img.ImageBuilder;

/**
 * BaseView displays an image itself and provides zoom-in / zoom-out, scroll operations
 */
public class ImageView implements View {
    public void display(){
        System.out.println("{ " + img.getCurrentImage().toString() + " }");
    }
    protected ImageBuilder img;

    public ImageBuilder getImageBuilder() {
        return img;
    }

    public ImageView(ImageBuilder img) {
        this.img = img;
    }
}
