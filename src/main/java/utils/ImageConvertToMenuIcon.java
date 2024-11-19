package utils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Utility class for converting images into white menu icons with resizing.
 */
public class ImageConvertToMenuIcon {

    /**
     * Loads an image from the specified file path.
     *
     * @param path The path to the image file.
     * @return The loaded image.
     * @throws IOException If the image cannot be loaded.
     */
    public static BufferedImage loadImage(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            throw new IOException("File not found: " + path);
        }
        return ImageIO.read(file);
    }

    /**
     * Converts an image into a white menu icon by resizing and changing its color.
     *
     * @param imagePath The path to the image file.
     * @param width     The desired width of the icon.
     * @param height    The desired height of the icon.
     * @return An ImageIcon suitable for use in menus, or null if an error occurs.
     */
    public static ImageIcon convertToMenuIcon(String imagePath, int width, int height) {
        try {
            BufferedImage originalImage = loadImage(imagePath);
            BufferedImage resizedImage = resizeImage(originalImage, width, height);
            BufferedImage whiteImage = changeColorToWhite(resizedImage);
            return new ImageIcon(whiteImage);
        } catch (IOException e) {
            System.err.println("Error processing image: " + e.getMessage());
            return null;
        }
    }

    /**
     * Resizes the given image to the specified width and height.
     *
     * @param originalImage The image to resize.
     * @param width         The new width of the image.
     * @param height        The new height of the image.
     * @return A resized BufferedImage.
     */
    private static BufferedImage resizeImage(BufferedImage originalImage, int width, int height) {
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = null;
        try {
            graphics = resizedImage.createGraphics();
            graphics.drawImage(originalImage, 0, 0, width, height, null);
        } finally {
            if (graphics != null) {
                graphics.dispose();  // Ensure resources are freed
            }
        }
        return resizedImage;
    }

    /**
     * Changes the color of the image to white.
     *
     * @param image The image to modify.
     * @return A new BufferedImage with white color applied.
     */
    private static BufferedImage changeColorToWhite(BufferedImage image) {
        BufferedImage whiteImage = new BufferedImage(
            image.getWidth(),
            image.getHeight(),
            BufferedImage.TYPE_INT_ARGB
        );

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int rgba = image.getRGB(x, y);
                Color color = new Color(rgba, true);
                if (color.getAlpha() > 0) { // Ignore fully transparent pixels
                    whiteImage.setRGB(x, y, Color.WHITE.getRGB());
                }
            }
        }
        return whiteImage;
    }
}
