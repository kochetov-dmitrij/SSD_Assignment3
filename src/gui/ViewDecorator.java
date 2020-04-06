package gui;

import img.ImageBuilder;

/**
 * Base class for all decorators of BaseView
 */
public class ViewDecorator implements View {

    protected View originalView;

    protected View getOriginalView() {
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

    @Override
    public ImageBuilder getImageBuilder() {
        return this.originalView.getImageBuilder();
    }

    public ViewDecorator(View originalView) {
        this.originalView = originalView;
    }
}
