package gui;

import img.ImageState;

import java.util.ArrayList;

/**
 * Provides panel with history of changes in the image
 */
public class HistoryView extends ViewDecorator {

    @Override
    public void displayWrapper() {
        ArrayList<ImageState> history = this.getOriginalView().getImageBuilder().getHistory();
        System.out.print(history.toString());
    }

    public HistoryView(View originalView) {
        super(originalView);
    }
}
