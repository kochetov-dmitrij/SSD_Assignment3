package gui;

import img.ImageState;

import java.util.ArrayList;

/**
 * Provides panel with history of changes in the image
 */
public class HistoryView extends ViewDecorator {

    @Override
    public void displayWrapper() {
        ArrayList<ImageState> history = this.getOriginalView().img.getHistory();
        System.out.print(history.toString());
    }

    public HistoryView(BaseView originalView) {
        super(originalView);
    }
}
