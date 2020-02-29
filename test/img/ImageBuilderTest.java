package img;

import action.Crop;
import action.Rotate;
import action.filter.Brightness;
import action.filter.Warmth;
import exporter.pngExporter;

import static org.junit.jupiter.api.Assertions.*;

class ImageBuilderTest {


    @org.junit.jupiter.api.Test
    void apply() {
        /*
        load an image
        rotate an image 45 degrees clockwise
        crop an image
        increase its brightness
        decrease its warmth
        export a result as a .png
         */

        // load an image
        ImageBuilder im_builder = new ImageBuilder(new Image("C:\\picture.jpg"));

        // perform all actions and export
        im_builder.apply(new Rotate(45)).apply(new Crop(20, 20, 30, 30)).apply(new Brightness(1.5)).apply(new Warmth(0.6)).exportTo(new pngExporter(), "C:\result.png");
        System.out.println("DONE");
    }
}