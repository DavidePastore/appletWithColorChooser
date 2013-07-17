package applet;

import java.awt.*;

import javax.swing.JPanel;

/**
 * This is the panel where we create all the colors pixel for pixel.
 * @author <a reef="https://github.com/DavidePastore">DavidePastore</a>
 *
 */
public class ColorPanel extends JPanel {

    int numCols = 300;

    /**
     * Standard method called for the paint of the component.
     */
    public void paint(Graphics g) {

        float h = 0, dh = (float) getHeight() / numCols;
        Color[] cols = getDifferentColors(numCols);

        for (int i = 0; i < numCols; i++) {
            g.setColor(cols[i]);
            g.fillRect(0, (int) h, getWidth(), (int) (h += dh));
        }
    }

    /**
     * Create an array of colors.
     * @param n the fluctuating value of the hue component of the Color.
     * @return the array of the color
     */
    public static Color[] getDifferentColors(int n) {
        Color[] cols = new Color[n];
        for (int i = 0; i < n; i++)
            cols[i] = Color.getHSBColor((float) i / n, 1, 1);
        return cols;
    }
}