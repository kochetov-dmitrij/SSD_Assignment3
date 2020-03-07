package img;

import java.util.ArrayList;

public class Image {
    private Pixel[][] matrix;
    private int width;

    private int height;

    public Image(String path) {
        // TODO : replace stub
        this.width = 100;
        this.height = 100;

        this.matrix = new Pixel[width][height];
    }

    public Image(Image image) {
        this.matrix = image.matrix.clone();
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Pixel getPixel(int x, int y) {
        return this.matrix[x][y];
    }

    public void setPixel(int x, int y, Pixel pixel) {
        this.matrix[x][y] = pixel;
    }

    public Image getSubMatrix(int x1, int y1, int x2, int y2) {
        return null;
    }

    public void setSubMatrix(int x1, int y1, int x2, int y2, Image image) {

    }
}
