package gui;

import img.ImageBuilderCaretaker;

/**
 * Interface of a view to be inserted inside Window
 */
public interface View {
    void display();
    ImageBuilderCaretaker getImageBuilderCaretaker();
}
