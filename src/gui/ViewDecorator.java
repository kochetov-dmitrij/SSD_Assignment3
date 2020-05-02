package gui;

import img.ImageBuilderCaretaker;

/**
 * Base class for all decorators of BaseView
 */
public abstract class ViewDecorator implements View {

    protected View originalView;

    protected View getOriginalView() {
        return originalView;
    }

    public abstract void displayWrapper();

    @Override
    public void display() {
        System.out.print("{ ");
        this.originalView.display();
        displayWrapper();
        System.out.print(" } ");
    }

    @Override
    public ImageBuilderCaretaker getImageBuilderCaretaker() {
        return this.originalView.getImageBuilderCaretaker();
    }

    ViewDecorator(View originalView) {
        this.originalView = originalView;
    }
}
