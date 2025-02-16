import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DisplayWindow extends JFrame {
    private Canvas canvas;

    public DisplayWindow(int width, int height, String title) {
        super(title);
        canvas = new Canvas();
        canvas.setSize(width, height);
        canvas.setBackground(Color.BLACK);

        this.add(canvas);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void render(ArrayList<Triangle> triangles) {
        Graphics g = canvas.getGraphics();
        int screenWidth = canvas.getWidth();
        g.setColor(Color.WHITE);

        for (Triangle t : triangles) {
            Vect3[] v = t.getVertices();
            int[] xPoints = {(int) v[0].getX()*screenWidth + 250, (int) v[1].getX()*screenWidth + 250, (int) v[2].getX()*screenWidth + 250};
            int[] yPoints = {(int) v[0].getY()*screenWidth + 250, (int) v[1].getY()*screenWidth + 250, (int) v[2].getY()*screenWidth + 250};

            g.drawPolygon(xPoints, yPoints, 3);
        }

        g.dispose();
    }
}
