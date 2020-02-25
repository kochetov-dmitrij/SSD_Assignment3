package img;

import action.Action;
import exporter.Exporter;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ImageBuilder {
    private List<Image> states;
    private int currentStateIdx;

    public ImageBuilder(Image sourceImage) {
        this.states = new ArrayList<>();
        this.states.add(sourceImage);
        currentStateIdx = 0;
    }

    public ImageBuilder apply(Action action) {
        Image newState = action.doAction(this.states.get(currentStateIdx));
        // Remove all of the next states since they are not valid anymore
        if (currentStateIdx != this.states.size() - 1){
            for (int idx = this.states.size() - 1; idx > currentStateIdx ; idx-- ){
                this.states.remove(idx);
            }
        }
        this.states.add(newState);
        this.currentStateIdx++;
        return this;
    }

    public ImageBuilder undo() {
        if (this.states.size() > 0){
            this.currentStateIdx--;
        }
        return this;
    }

    public ImageBuilder redo() {
        if (this.currentStateIdx < this.states.size() - 1){
            this.currentStateIdx++;
        }
        return this;
    }

    public File exportTo(Exporter exporter, String path) {
        return exporter.convertAndSave(path, this.getCurrentImage());
    }

    public Image getCurrentImage() {
        return this.states.get(currentStateIdx);
    }
}
