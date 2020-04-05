package gui;

import action.Crop;
import action.Rotate;
import action.filter.Brightness;
import img.Image;
import img.ImageBuilder;

class WindowTest {

    @org.junit.jupiter.api.Test
    void TestDecorators() {// load an image
        ImageBuilder im_builder = new ImageBuilder(new Image("C:\\picture.jpg"));

        // perform all actions and export
        im_builder.apply(new Rotate(45)).apply(new Crop(20, 20, 30, 30)).apply(new Brightness(1.5));

        Window MaceWindow = new Window(new BaseView(im_builder));

        MaceWindow.displayContent();
        System.out.println();

        MaceWindow.addHistoryPanel();

        MaceWindow.displayContent();
        System.out.println();

        MaceWindow.addFiltersPanel();

        MaceWindow.displayContent();
        System.out.println();

    }

    @org.junit.jupiter.api.Test
    void TestDecoratorEdit() {
        ImageBuilder im_builder = new ImageBuilder(new Image("C:\\picture.jpg"));

        // perform all actions and export
        im_builder.apply(new Rotate(45)).apply(new Crop(20, 20, 30, 30)).apply(new Brightness(1.5));

        Window MaceWindow = new Window(new BaseView(im_builder));

        MaceWindow.addHistoryPanel();

        MaceWindow.addFiltersPanel();

        MaceWindow.hideFiltersPanel();

        MaceWindow.displayContent();
        System.out.println();

        MaceWindow.hideHistoryPanel();

        MaceWindow.displayContent();
        System.out.println();


    }
}