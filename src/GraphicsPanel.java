import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;


@SuppressWarnings("serial")
public class GraphicsPanel extends JPanel {

	/**
	 * The default BG colour of the image.
	 */
	private final static Color BACKGROUND_COL = Color.WHITE;
	
	/**
	 * The underlying image used for drawing. This is required so any previous drawing activity is persistent on the panel.
	 */
	static BufferedImage image;

		/**
	 * Draw a line on the image using the given colour.
	 * 
	 * @param color
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	
	public static int xo = 500, yo = 281;

	
	public void drawLine(Color color, int x1, int y1, int x2, int y2) {	
		
		Graphics g = image.getGraphics();
		g.setColor(color);
		g.drawLine(x1, y1, x2, y2);
		repaint();
	}
	
	public void dontDrawLine(int x1, int y1, int x2, int y2) {		
//		Graphics g = image.getGraphics();
		
		repaint();
	}
	
	/**
	 * Clears the image contents.
	 */
	public void clear() {
		
		Graphics g = image.getGraphics();
		
		g.setColor(BACKGROUND_COL);
		
		g.fillRect(0, 0, image.getWidth(),  image.getHeight());
		
		xo = 500;
		yo = 281;
		
		repaint();
	}
	
	@Override
	public void paint(Graphics g) {

		// render the image on the panel.
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
	}

	/**
	 * Constructor.
	 * @param scroll 
	 */
	GraphicsPanel() {

		setPreferredSize(new Dimension(1200, 675));

		image = new BufferedImage(1000, 563, BufferedImage.TYPE_INT_RGB);
		
		// Set max size of the panel, so that is matches the max size of the image.
		setMaximumSize(new Dimension(image.getWidth(), image.getHeight()));
		
		clear();
	}

	public RenderedImage image() {
		return image;
	}
	
}