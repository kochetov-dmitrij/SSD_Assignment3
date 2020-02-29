package cloud;

import action.Crop;
import action.Rotate;
import action.filter.Brightness;
import action.filter.Warmth;
import exporter.pngExporter;
import img.Image;
import img.ImageBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CloudSyncTest {

    /**
     * The same test as for image builder, but with sleep and CloudSync.sendCurrentQueue()
     * to show the work of CloudSync
     */
    @Test
    public void test() throws Exception{

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
        im_builder.apply(new Rotate(45)).apply(new Crop(20, 20, 30, 30));
        Thread.sleep(7000);
        im_builder.apply(new Brightness(1.5)).apply(new Warmth(0.6)).exportTo(new pngExporter(), "C:\\result.png");
        CloudSync.getCloudSync().sendCurrentQueue();
        System.out.println("DONE");
    }
}