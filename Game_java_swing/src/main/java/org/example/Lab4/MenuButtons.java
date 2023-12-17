package org.example.Lab4;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MenuButtons extends JButton {
    private Color color1;
    private Color color2;
    public MenuButtons(String label, int top, int left, int bottom, int right, int fontSize, Color fontColor, String color1Code, String color2Code) {
        super(label);
        color1 = Color.decode(color1Code);
        color2 = Color.decode(color2Code);
        setContentAreaFilled(false);
        setForeground(fontColor);
        setFont(new Font("Serif", Font.BOLD, fontSize));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBorder(new EmptyBorder(top,left,bottom,right));
        setFocusable(false);
    }

    @Override
    protected void paintComponent(Graphics g) {

        int width = getWidth();
        int height = getHeight();
        GradientPaint gradient = new GradientPaint(0,0, color1, width, 0, color2);

        //BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        //Graphics2D g2 = img.createGraphics();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setPaint(gradient);
        g2.fillRoundRect(0,0,width,height,height,height);
        //g.drawImage(img,0,0,null);

        super.paintComponent(g);
    }
}
