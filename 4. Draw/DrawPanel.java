package vehinh;

import java.awt.*;
import javax.swing.*;

public class DrawPanel extends JPanel {

    private Color color;
    private String shape;
    private int x, y;
    private boolean isEmpty;

    public DrawPanel() {
        super();
        this.setLayout(null);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (shape == null) {
            return;
        }

        x = this.getWidth() / 2;
        y = this.getHeight() / 2;
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(this.color);

        if (shape.equals("Rectangle")) {
            System.out.println(x + y);
            g2.drawRect(x, y, 100, 150);
            if (!this.isEmpty) {
                g2.fillRect(x, y, 100, 150);
            }
        }
        if (shape.equals("Square")) {
            System.out.println(x + y);
            g2.drawRect(x, y, 100, 100);
            if (!this.isEmpty) {
                g2.fillRect(x, y, 100, 100);
            }
        }
        if (shape.equals("Circle")) {
            g2.drawOval(x, y, 100, 100);
            if (!this.isEmpty) {
                g2.fillOval(x, y, 100, 100);
            }
        }
        if (shape.equals("Polygon")) {
            g2.drawPolygon(new int[]{10, 200, 100}, new int[]{10, 10, 100}, 3);
            if (!this.isEmpty) {
                g2.fillPolygon(new int[]{10, 200, 100}, new int[]{10, 10, 100}, 3);
            }
        }
    }

    public void setShape(String newShape) {
        this.shape = newShape;
    }
    public void setColor(String newColor) {
        switch (newColor) {
            case "RED":
                this.color = Color.RED;
                break;
            case "BLUE":
                this.color = Color.BLUE;
                break;
            case "GREEN":
                this.color = Color.GREEN;
                break;
            case "YELLOW":
                this.color = Color.YELLOW;
                break;
        }
    }

    public void setEmpty(boolean empty) {
        this.isEmpty = empty;
    }

}
