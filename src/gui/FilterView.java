package gui;

public class FilterView extends ViewDecorator {
    @Override
    public void displayWrapper() {
        System.out.println(" available filters ");
    }

    public FilterView(BaseView originalView) {
        super(originalView);
    }
}
