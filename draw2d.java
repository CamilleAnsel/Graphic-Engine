import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class draw2d {

  public static void main(String[] args) {
    // Vars
    int width = 400;
    int height = 300;

    // Initalise image
    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    // Set the entire image to black by filling the pixels manually
    for (int x = 0; x < width; x++) {
        for (int y = 0; y < height; y++) {
            bufferedImage.setRGB(x, y, Color.BLACK.getRGB()); // Set pixel to black
        }
    }

    // Draw some pixels
    for (int x = width/2-5; x < width/2+5; x++) {
        for (int y = height/2-5; y < height/2+5; y++) {
            bufferedImage.setRGB(x, y, Color.WHITE.getRGB()); // Set pixel to white
        }
    }

    // Create a JFrame to display the image
    JFrame frame = new JFrame("Java BufferedImage View");
    frame.setSize(300,200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // create a JPanel to display the BufferedImage
    JPanel panel = new JPanel(){
      @Override
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the BufferedImage onto the JPanel
        g.drawImage(bufferedImage, 0, 0, this);
      }
    };

    // Add the panel to the frame and display
    frame.add(panel);
    frame.setVisible(true);
  }
}
