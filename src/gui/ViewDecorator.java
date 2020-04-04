package gui;

public class ViewDecorator extends BaseView {

    protected BaseView originalView;

    protected BaseView getOriginalView() {
        return originalView;
    }

    public void displayWrapper(){};

    @Override
    public void display() {
        System.out.print("{ ");
        super.display();
        displayWrapper();
        System.out.print(" } ");
    }

    public ViewDecorator(BaseView originalView) {
        this.originalView = originalView;
    }
}
