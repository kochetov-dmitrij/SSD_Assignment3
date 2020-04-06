package gui;

/**
 * Provides panel with available filters
 */
public class FilterView extends ViewDecorator {
    @Override
    public void displayWrapper() {
        System.out.println(" available filters ");
    }

    public FilterView(View originalView) {
        super(originalView);
    }
}
