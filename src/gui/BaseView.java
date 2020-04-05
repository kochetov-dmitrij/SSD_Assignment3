package gui;

import img.ImageBuilder;

/**
 * BaseView displays an image itself and provides zoom-in / zoom-out, scroll operations
 */
public class BaseView {
    public void display(){
        System.out.println("{ " + img.getCurrentImage().toString() + " }");
    }
    protected ImageBuilder img;

    public BaseView(ImageBuilder img) {
        this.img = img;
    }
}
