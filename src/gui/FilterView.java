package gui;

public class FilterView extends ViewDecorator {

    @Override
    public void displayWrapper() {
        System.out.println("{");
        super.display();
        System.out.println(" available filters }");
    }

    public FilterView(BaseView originalView) {
        super(originalView);
    }
}
