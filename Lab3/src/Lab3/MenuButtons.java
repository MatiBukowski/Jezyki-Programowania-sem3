package Lab3;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MenuButtons extends JButton {
    private Color color1 = Color.decode("#0099F7");
    private Color color2 = Color.decode("#F11712");
    public MenuButtons(String label) {
        super(label);
        setContentAreaFilled(false);
        setForeground(Color.ORANGE);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBorder(new EmptyBorder(20,30,20,30));
        setFocusable(false);
    }

    @Override
    protected void paintComponent(Graphics g) {

        int width = getWidth();
        int height = getHeight();
        GradientPaint gradient = new GradientPaint(0,0, color1, width, 0, color2);

        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setPaint(gradient);
        g2.fillRoundRect(0,0,width,height,height,height);
        g.drawImage(img,0,0,null);

        super.paintComponent(g);
    }

}
