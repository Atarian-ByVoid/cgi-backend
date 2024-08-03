package com.cgi.utils;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.springframework.stereotype.Component;

@Component
public class FileHelper {

    public BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        g.dispose();
        return resizedImage;
    }

}
