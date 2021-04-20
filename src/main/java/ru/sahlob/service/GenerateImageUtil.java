package ru.sahlob.service;

import ru.sahlob.persistance.Image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

public class GenerateImageUtil {

    public static ru.sahlob.persistance.Image convertByteToImage(byte[] bytes) {
        return new Image(
                String.valueOf(System.currentTimeMillis()),
                "png",
                bytes);
    }

    public static byte[] generateRandomImage() {
        try {
            return convertBufferedImageToByte(generateImage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static BufferedImage generateImage() {
        var w = 1200;
        var h = 1000;
        var wCount = 0;
        var hCount = 0;
        while (wCount == 0 || hCount == 0) {
            wCount = new Random().nextInt(w / 2);
            hCount = new Random().nextInt(h / 2);
        }


        var image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        for (int i = 0; i < w / wCount; i++) {
            for (int j = 0; j < h / hCount; j++) {
                fillOneReact(image, i * wCount, j * hCount, wCount, hCount);
            }
        }
        return image;
    }

    private static byte[] convertBufferedImageToByte(BufferedImage image) throws IOException {
        var baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        return baos.toByteArray();
    }

    private static Color getRandomRGB() {
        var random = new Random();
        var red = random.nextInt(256);
        var green = random.nextInt(256);
        var blue = random.nextInt(256);
        return new Color(red, green, blue);
    }

    private static void fillOneReact(BufferedImage image, int x, int y, int wCount, int hCount) {
        var g = image.getGraphics();
        g.setColor(getRandomRGB());
        g.fillRect(x, y, wCount, hCount);
    }
}
