package Lab3;

import javax.swing.*;
import java.awt.*;

public class MenuLines extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.drawLine(120,100,120,480);
        g2.drawLine(550,100,550,480);
    }
}
