package img;

import action.Action;
import exporter.Exporter;

import java.io.File;
import java.util.LinkedList;

public class ImageBuilder {
    LinkedList<Image> states;

    public ImageBuilder(Image sourceImage) {

    }

    public ImageBuilder apply(Action action) {
        return null;
    }

    ImageBuilder undo() {
        return null;
    }

    ImageBuilder redo() {
        return null;
    }

    File exportTo(Exporter exporter, String path) {
        return null;
    }

    Image getCurrentImage() {
        return null;
    }
}
