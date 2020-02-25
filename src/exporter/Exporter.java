package exporter;

import img.Image;

import java.io.File;

public interface Exporter {
    File convertAndSave(String path, Image image);
}
