package img;

import action.Action;
import action.Crop;
import action.Rotate;
import action.filter.Brightness;
import action.filter.Warmth;
import exporter.PngExporter;

import static org.junit.jupiter.api.Assertions.*;

class ImageBuilderCaretakerTest {

    boolean compareActions(Action a1, Action a2){
        return a1.toString().equals(a2.toString());
    }

    @org.junit.jupiter.api.Test
    void historyChangeTest() {
        /*
        load an image
        rotate an image 45 degrees clockwise
        crop an image
        increase its brightness
        decrease its warmth

        then undo x2, redo x1, undo x3 (returns to initial image)
         */

        // load an image
        ImageBuilder im_builder = new ImageBuilder(new Image("C:\\picture.jpg"));
        ImageBuilderCaretaker im_caretaker = new ImageBuilderCaretaker(im_builder);

        // perform all actions
        im_caretaker.apply(new Rotate(45)).apply(new Crop(20, 20, 30, 30)).apply(new Brightness(1.5)).apply(new Warmth(0.6));

        // undo x2
        im_caretaker.undo();
        im_caretaker.undo();

        // assertEquals ensures that no changes were made in history
        assertEquals(4 + 1, im_caretaker.getHistory().size());
        assertTrue(this.compareActions(im_caretaker.getCurrentImageState().lastAction, new Crop(20, 20, 30, 30)));

        // redo x1
        im_caretaker.redo();

        assertEquals(4 + 1, im_caretaker.getHistory().size());
        assertTrue(this.compareActions(im_caretaker.getCurrentImageState().lastAction, new Brightness(1.5)));

        // undo x3
        im_caretaker.undo();
        im_caretaker.undo();
        im_caretaker.undo();

        assertEquals(4 + 1, im_caretaker.getHistory().size());
        assertNull(im_caretaker.getCurrentImageState().lastAction);

        System.out.println("DONE");
    }
}