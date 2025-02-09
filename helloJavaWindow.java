import javax.swing.*;
import java.awt.*;

public class helloJavaWindow {
    public static void main(String[] args) {
        // Crée une nouvelle fenêtre JFrame
        JFrame frame = new JFrame("Fenêtre Hello Java");

        // Crée un panneau personnalisé pour dessiner dedans
        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                // Définir le fond noir
                setBackground(Color.BLACK);

                // Définir la couleur du texte en blanc
                g.setColor(Color.WHITE);

                // Dessiner le texte "Hello Java" au centre de la fenêtre
                g.setFont(new Font("Arial", Font.PLAIN, 40)); // Choisir une taille de police
                g.drawString("Hello Java", 100, 100); // Position du texte
            }
        };

        // Ajoute le panneau à la fenêtre
        frame.add(panel);

        // Spécifie la fermeture de la fenêtre
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Définit la taille de la fenêtre
        frame.setSize(400, 300);

        // Rendre la fenêtre visible
        frame.setVisible(true);
    }
}

