package gui;

import img.ImageBuilder;

public class BaseView {
    public void display(){
        System.out.println(img.getCurrentImage().toString());
    }
    protected ImageBuilder img;

    public BaseView(ImageBuilder img) {
        this.img = img;
    }
}
