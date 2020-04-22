package img;

import action.Action;
import cloud.CloudSync;
import exporter.Exporter;

import java.io.File;

public class ImageBuilder {
    private ImageState imageState;

    public ImageBuilder(Image sourceImage) {
        this.imageState = new ImageState(sourceImage, null);
    }

    public Memento save() {
        return new Memento(this.imageState);
    }

    public void restore(Memento memento) {
        this.imageState = memento.imageState;
    }

    public ImageBuilder apply(Action action) {
        // Add to the queue to send
        CloudSync.getCloudSync().addToQueue(action);
        // Process locally
        this.imageState = new ImageState(action.doAction(imageState.img), action);
        return this;
    }

    public File exportTo(Exporter exporter, String path) {
        return exporter.convertAndSave(path, this.getCurrentImage());
    }

    Image getCurrentImage() {
        return this.imageState.img;
    }

    public class Memento {
        private ImageState imageState;

        Memento(ImageState imageState) {
            this.imageState = imageState;
        }

        public ImageState getImageState() {
            return this.imageState;
        }
    }
}
