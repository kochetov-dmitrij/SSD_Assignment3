package img;

import action.Action;
import exporter.Exporter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ImageBuilderCaretaker {
    private ImageBuilder imageBuilder;
    private List<ImageBuilder.Memento> snapshots = new ArrayList<>();
    private int snapshotId;

    public ImageBuilderCaretaker(ImageBuilder imageBuilder) {
        this.imageBuilder = imageBuilder;
    }

    public void redo() {
        if (this.snapshotId >= this.snapshots.size() - 1) throw new ArrayIndexOutOfBoundsException("Nothing to redo");
        this.snapshotId++;
        this.imageBuilder.restore(this.snapshots.get(snapshotId));
    }

    public void undo() {
        if (this.snapshotId <= 0) throw new ArrayIndexOutOfBoundsException("Nothing to undo");
        this.snapshotId--;
        this.imageBuilder.restore(this.snapshots.get(snapshotId));
    }

    public ArrayList<ImageState> getHistory() {
        return snapshots.stream()
                .map(ImageBuilder.Memento::getImageState)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ImageBuilderCaretaker apply(Action action) {
        // Save the current state
        ImageBuilder.Memento snapshot = this.imageBuilder.save();

        // Remove all of the next states since they are not valid anymore
        if (this.snapshotId < this.snapshots.size() - 1) {
            for (int idx = this.snapshots.size() - 1; idx > snapshotId; idx--) {
                this.snapshots.remove(idx);
            }
        }
        this.snapshots.add(snapshot);
        this.snapshotId++;

        // Do apply filter
        this.imageBuilder.apply(action);
        return this;
    }

    public File exportTo(Exporter exporter, String path) {
        return this.imageBuilder.exportTo(exporter, path);
    }

    public Image getCurrentImage() {
        return this.imageBuilder.getCurrentImage();
    }
}
