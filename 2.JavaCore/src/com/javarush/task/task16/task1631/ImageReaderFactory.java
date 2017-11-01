package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.BmpReader;
import com.javarush.task.task16.task1631.common.JpgReader;
import com.javarush.task.task16.task1631.common.PngReader;
import com.javarush.task.task16.task1631.common.ImageReader;
import com.javarush.task.task16.task1631.common.ImageTypes;

public class ImageReaderFactory implements ImageReader {

    public static ImageReader getImageReader(ImageTypes type) {
        if (type == ImageTypes.BMP) return new BmpReader();
        if (type == ImageTypes.PNG) return new PngReader();
        if (type == ImageTypes.JPG) return new JpgReader();
        else throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
