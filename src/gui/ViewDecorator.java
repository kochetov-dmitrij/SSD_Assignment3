package gui;

/**
 * Base class for all decorators of BaseView
 */
public class ViewDecorator extends BaseView {

    protected BaseView originalView;

    protected BaseView getOriginalView() {
        return originalView;
    }

    public void displayWrapper(){};

    @Override
    public void display() {
        System.out.print("{ ");
        this.originalView.display();
        displayWrapper();
        System.out.print(" } ");
    }

    public ViewDecorator(BaseView originalView) {
        super(originalView.img);
        this.originalView = originalView;
    }
}
