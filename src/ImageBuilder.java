import java.io.File;
import java.util.LinkedList;

public class ImageBuilder {
    LinkedList<Image> states;

    ImageBuilder(Image sourceImage) {

    }

    ImageBuilder apply(Action action) {
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
