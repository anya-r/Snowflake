import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class SierpinskiPanel extends JPanel
{
	public SierpinskiPanel()
	{
		super.setPreferredSize(new Dimension(400, 400));
		super.setBackground(Color.WHITE);
	}

	public void paintComponent(Graphics g)
	{
		int width  = getWidth();
		int height = getHeight();

		super.paintComponent(g);

		/*
		 * DRAWING CODE BELOW
		 */
		g.setColor(Color.BLUE);
		drawTriangle(g, 0, 0, width, 7);
		
		
		}
	public void drawTriangle(Graphics g, int x, int y, int size, int times)
	{
		if (times == 0) 
			return;
		else
		{
			g.drawLine(x, y, x + size, y);
			g.drawLine(x, y, x, y + size);
			g.drawLine(x+size, y, x, y + size);

			drawTriangle(g, x, y, size/2, times-1);
			drawTriangle(g, x + size/2, y, size/2, times-1);
			drawTriangle(g, x, y + size/2, size/2, times-1);
		}

	}

	
}

public class Sierpinski
{
	public static void main (String[] args)
	{
		/*
		 * A frame is a container for a panel
		 * The panel is where the drawing will take place
		 */
		JFrame frame = new JFrame("Sierpinski Triangle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new SierpinskiPanel());
		frame.pack();
		frame.setVisible(true);
	}
}
