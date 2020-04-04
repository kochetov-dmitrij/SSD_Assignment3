package gui;

import action.Crop;
import action.Rotate;
import action.filter.Brightness;
import action.filter.Warmth;
import exporter.PngExporter;
import img.Image;
import img.ImageBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WindowTest {

    @Test
    void TestDecorators() {// load an image
        ImageBuilder im_builder = new ImageBuilder(new Image("C:\\picture.jpg"));

        // perform all actions and export
        im_builder.apply(new Rotate(45)).apply(new Crop(20, 20, 30, 30)).apply(new Brightness(1.5)).apply(new Warmth(0.6)).exportTo(new PngExporter(), "C:\result.png");

        Window MaceWindow = new Window(new BaseView(im_builder));

        MaceWindow.displayContent();

        MaceWindow.addHistoryPanel();

        MaceWindow.displayContent();

        MaceWindow.AddFiltersPanel();

        MaceWindow.displayContent();
    }
}