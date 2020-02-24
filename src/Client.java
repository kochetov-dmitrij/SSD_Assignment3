import action.Action;
import action.filter.Shadow;
import exporter.Exporter;
import img.Image;
import img.ImageBuilder;

import java.io.File;
import java.nio.file.Path;

public class Client {
    public static File open(String path){
        return null;
    }
    public static void save(String path){
        System.out.println("Saving file.. " );
    }

    public static ImageBuilder editImage(ImageBuilder image, Action action){
        return image.apply(action);
    }

    public static void main(String[] args) {
        String path = "some/path";
        open(path);
        Image someImage = new Image(path);
        ImageBuilder ib = new ImageBuilder(someImage);
        Action action = new Shadow(12);
        editImage(ib, action);
        save(path);
    }
}
