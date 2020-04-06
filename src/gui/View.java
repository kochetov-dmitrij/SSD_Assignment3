package gui;

import img.ImageBuilder;

/**
 * Interface of a view to be inserted inside Window
 */
public interface View {
    void display();
    ImageBuilder getImageBuilder();
}
